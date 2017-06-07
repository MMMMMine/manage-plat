package com.xiuqi.cms.service;

import com.xiuqi.cms.dto.AppQueryReq;

/**
 * Created by frank on 2017/6/6.
 */
public interface IAppQueryService {

    Object addOrUpdateAppQuery(AppQueryReq req);

    Object deleteAppQuery(Integer id);

    Object selectAppQueryList(Integer nowPage, Integer pageSize);
}
