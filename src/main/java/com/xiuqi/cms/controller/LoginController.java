package com.xiuqi.cms.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.xiuqi.cms.constant.XiuConstant;
import com.xiuqi.cms.service.ILoginService;
import com.xiuqi.cms.dto.AdminLoginReq;
import com.xiuqi.cms.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by frank on 2017/5/27.
 */
@RestController
@RequestMapping(value = "/api", method = RequestMethod.POST, produces = "application/json")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @Autowired
    private Producer captchaProducer;


    @RequestMapping("/adminLogin.do")
    Object adminLogin(@Valid AdminLoginReq req, BindingResult bindingResult, HttpServletRequest request) {

        if (bindingResult.hasErrors()){
            return new Result(XiuConstant.FAIL_CODE,bindingResult.getFieldError().getDefaultMessage());
        }

        //校验验证码
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (!req.getRandomCode().equals(code)){
            return new Result(XiuConstant.FAIL_CODE,"验证码不正确");
        }

        return loginService.adminLogin(req);
    }

    @RequestMapping(value = "/randomCode.do",method = RequestMethod.GET)
    Object randomCode(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();

        response.setDateHeader("Expires", 0);

        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");

        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");

        // return a jpeg
        response.setContentType("image/jpeg");

        // create the text for the image
        String capText = captchaProducer.createText();

        // store the text in the session
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);

        // create the image with the text
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();

        // write the data out
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }

}
