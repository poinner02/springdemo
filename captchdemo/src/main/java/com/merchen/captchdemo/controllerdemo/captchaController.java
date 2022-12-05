package com.merchen.captchdemo.controllerdemo;

import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.ChineseCaptcha;
import com.wf.captcha.base.Captcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试图片验证码获取
 *
 * @author MrChen
 * @create 2022-12-05 22:08
 */
@Slf4j
@RestController
@RequestMapping("/getpng")
public class captchaController {
    //以流形式返回,service不写了
    @GetMapping(value = "/algorithmpng", produces = "image/png")
    public void captcha(@RequestParam(value = "key") String key,
                        HttpServletResponse response) throws IOException {
        //中文验证码
//        Captcha captcha = new ChineseCaptcha(150,60);
        //获取本次生成的验证码
//        String text = captcha.text();
//        log.info("captcha test={}",text);
//        captcha.out(new FileOutputStream(new File("D:\\captcha.png")));

        //算数验证码
        ArithmeticCaptcha arithmeticCaptcha = new ArithmeticCaptcha();
        //获取本次生成的验证码
        String text1 = arithmeticCaptcha.text();
        log.info("captcha text1={}", text1);
        //todo save in redis .....
        //以流形式返回给客户浏览器
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        response.setHeader(HttpHeaders.PRAGMA, "No-cache");
        response.setHeader(HttpHeaders.CACHE_CONTROL, "No-cache");
        response.setDateHeader(HttpHeaders.EXPIRES, 0L);
        arithmeticCaptcha.out(response.getOutputStream());

    }

}
