package com.xiuqi.cms.service.impl;

import com.xiuqi.cms.persistance.po.Admin;
import com.xiuqi.cms.constant.XiuConstant;
import com.xiuqi.cms.persistance.AdminMapper;
import com.xiuqi.cms.service.ILoginService;
import com.xiuqi.cms.dto.AdminLoginReq;
import com.xiuqi.cms.dto.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by frank on 2017/5/27.
 */
@Service
public class LoginServiceImpl implements ILoginService {

    private Logger Log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Result adminLogin(AdminLoginReq req) {

        Result result = new Result(XiuConstant.FAIL_CODE, XiuConstant.FAIL_MSG);

        Admin admin = adminMapper.selectAdminByAccount(req.getAccount());

        if (admin == null){

            result.setMsg("账号不存在");
            return result;
        }

        if (!req.getPassword().equals(admin.getPassword())) {

            result.setMsg("密码错误");
            return result;

        }

        Map<String,Object> data = new HashMap<>();

        data.put("roleId",admin.getRoleId());

        result.setData(data);
        result.setCode(XiuConstant.SUCCESS_CODE);
        result.setMsg(XiuConstant.SUCCESS_MSG);
        return result;
    }
}
