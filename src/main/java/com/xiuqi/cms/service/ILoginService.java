package com.xiuqi.cms.service;

import com.xiuqi.cms.dto.AdminLoginReq;
import com.xiuqi.cms.dto.Result;

/**
 * Created by frank on 2017/5/27.
 */
public interface ILoginService {

    Result adminLogin(AdminLoginReq req);
}
