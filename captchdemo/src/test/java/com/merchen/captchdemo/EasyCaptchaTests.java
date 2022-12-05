package com.merchen.captchdemo;

import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.ChineseCaptcha;
import com.wf.captcha.base.Captcha;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Slf4j
@SpringBootTest
public class EasyCaptchaTests {

    @Test
    public void  CaptchaTest() throws FileNotFoundException {
        //中文验证码
        Captcha captcha = new ChineseCaptcha(150,60);
        //获取本次生成的验证码
        String text = captcha.text();
        log.info("captcha test={}",text);
        captcha.out(new FileOutputStream(new File("D:\\captcha.png")));

        //算数验证码
        ArithmeticCaptcha arithmeticCaptcha = new ArithmeticCaptcha();
        //获取本次生成的验证码
        String text1 = arithmeticCaptcha.text();
        log.info("captcha text1={}",text1);
        arithmeticCaptcha.out(new FileOutputStream(new File("D:\\captcha1.png")));

    }

}
