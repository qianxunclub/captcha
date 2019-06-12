package com.qianxunclub.captcha.service;

import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangbin
 * @date 2019-06-11 15:51
 * @description: TODO
 */
@Slf4j
public class CaptchaImageForPyTest {

    @Test
    public void check() {
        String p = CaptchaImageForPy.check(this.captchaImage());
        log.info("验证码识别结果：" + p);
    }

    private String captchaImage() {
        String utl = "https://kyfw.12306.cn/passport/captcha/captcha-image64?login_site=E&module=login&rand=sjrand&_=%s";
        HttpGet httpGet = new HttpGet(String.format(utl, Math.random()));
        String response = this.get(httpGet);
        Gson jsonResult = new Gson();
        Map rsmap = jsonResult.fromJson(response, Map.class);
        return (String) rsmap.get("image");
    }

    private String get(HttpGet httpGet){
        HttpClient httpclient = HttpClients.custom().build();
        HttpResponse response;
        try {
            response = httpclient.execute(httpGet);
            HttpEntity httpEntity = response.getEntity();
            String result = EntityUtils.toString(httpEntity,"UTF-8");
            return result;
        } catch (IOException e) {
            log.error("",e);
        }
        return "";
    }
}