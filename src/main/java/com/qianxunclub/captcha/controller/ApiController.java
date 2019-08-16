package com.qianxunclub.captcha.controller;

import com.qianxunclub.captcha.model.ApiRequest;
import com.qianxunclub.captcha.service.CaptchaImageForPy;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangbin
 * @date 2019-06-08 19:31
 * @description: TODO
 */
@RestController
@AllArgsConstructor
@RequestMapping(value = "/api", produces = "application/json")
public class ApiController {

    private CaptchaImageForPy captchaImageForPy;

    @ResponseBody
    @PostMapping("captcha")
    public Object captcha(@RequestBody ApiRequest apiRequest) {
        return captchaImageForPy.check(apiRequest.getImage());
    }
}
