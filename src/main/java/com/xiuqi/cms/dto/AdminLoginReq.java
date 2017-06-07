package com.xiuqi.cms.dto;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * Created by frank on 2017/5/27.
 */
public class AdminLoginReq {

    @NotEmpty(message = "用户名不能为空")
    private String account;

    @NotEmpty(message = "密码不能为空")
    private String password;

    @NotEmpty(message = "验证码不能为空")
    private String randomCode;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRandomCode() {
        return randomCode;
    }

    public void setRandomCode(String randomCode) {
        this.randomCode = randomCode;
    }
}
