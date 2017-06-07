package com.xiuqi.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Created by frank on 2017/5/28.
 */
@Configuration
public class KaptchaConfig {

    @Bean
    public DefaultKaptcha captchaProducer(){

        DefaultKaptcha captchaProducer = new DefaultKaptcha();

        Properties properties = new Properties();
        properties.setProperty("kaptcha.border","yes");
        properties.setProperty("kaptcha.border.color","105,179,90");
        properties.setProperty("kaptcha.textproducer.font.color","green");
        properties.setProperty("kaptcha.image.width","250");
        properties.setProperty("kaptcha.textproducer.font.size","80");
        properties.setProperty("kaptcha.image.height","90");
        properties.setProperty("kaptcha.session.key","code");
        properties.setProperty("kaptcha.textproducer.char.length","5");
        properties.setProperty("kaptcha.textproducer.font.names","宋体,楷体,微软雅黑");

        Config config = new Config(properties);
        captchaProducer.setConfig(config);
        return captchaProducer;

    }
}
