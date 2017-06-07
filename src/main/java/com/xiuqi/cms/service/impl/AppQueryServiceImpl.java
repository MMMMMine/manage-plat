package com.xiuqi.cms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiuqi.cms.constant.XiuConstant;
import com.xiuqi.cms.dto.Result;
import com.xiuqi.cms.persistance.AppQueryMapper;
import com.xiuqi.cms.persistance.po.AppQuery;
import com.xiuqi.cms.service.IAppQueryService;
import com.xiuqi.cms.dto.AppQueryReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by frank on 2017/6/6.
 */
@Service
public class AppQueryServiceImpl implements IAppQueryService {

    @Autowired
    private AppQueryMapper appQueryMapper;

    @Override
    public Object addOrUpdateAppQuery(AppQueryReq req) {

        //查询是否已存在记录
        int id = req.getId() == null ? 0 : req.getId();
        AppQuery appQuery = appQueryMapper.selectAppQueryById(id);

        //无则新增,有则更新
        if (appQuery == null) {

            AppQuery appQueryNew = new AppQuery();
            BeanUtils.copyProperties(req, appQueryNew);
            appQueryNew.setCreateTime(new Date());

            appQueryMapper.insertAppQuery(appQueryNew);

        } else {

            BeanUtils.copyProperties(req, appQuery);
            appQuery.setUpdateTime(new Date());
            appQueryMapper.updateAppQueryById(appQuery);


        }

        return new Result(XiuConstant.SUCCESS_CODE, XiuConstant.SUCCESS_MSG);
    }

    @Override
    public Object deleteAppQuery(Integer id) {

        //删除
        appQueryMapper.deleteAppQueryById(id);

        return new Result(XiuConstant.SUCCESS_CODE, XiuConstant.SUCCESS_MSG);

    }

    @Override
    public Object selectAppQueryList(Integer nowPage, Integer pageSize) {

        Result result = new Result(XiuConstant.FAIL_CODE, XiuConstant.FAIL_MSG);

        try {

            PageHelper.startPage(nowPage, pageSize);
            List<AppQuery> list = appQueryMapper.selectAppQueryList();
            PageInfo pageInfo = new PageInfo(list);
            result.setData(pageInfo);
            result.setCode(XiuConstant.SUCCESS_CODE);
            result.setMsg(XiuConstant.SUCCESS_MSG);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return result;

    }
}
