package com.xiuqi.cms.controller;

import com.xiuqi.cms.dto.AppQueryReq;
import com.xiuqi.cms.service.IAppQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by frank on 2017/6/6.
 */
@RestController
@RequestMapping(value = "/api", method = RequestMethod.POST, produces = "application/json")
public class AppQueryController {

    @Autowired
    private IAppQueryService appQueryService;


    @RequestMapping("/addOrUpdateAppQuery.do")
    Object addOrUpdateAppQuery(@Validated(AppQueryReq.AddOrUp.class) AppQueryReq req, BindingResult bindingResult) {

        return appQueryService.addOrUpdateAppQuery(req);

    }

    @RequestMapping("/deleteAppQuery.do")
    Object deleteAppQuery(@Validated(AppQueryReq.Del.class) AppQueryReq req, BindingResult bindingResult) {

        return appQueryService.deleteAppQuery(req.getId());

    }

    @RequestMapping("/selectAppQueryList.do")
    Object selectAppQueryList(Integer nowPage, Integer pageSize) {

        return appQueryService.selectAppQueryList(nowPage, pageSize);

    }
}
