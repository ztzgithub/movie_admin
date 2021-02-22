package com.ztt.movie.service.sms.controller;

import com.ztt.movie.common.base.result.R;
import com.ztt.movie.service.sms.util.SmsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/sms/sample")
public class SampleController {

    @Autowired
    private SmsProperties smsProperties;
    @Value("${aliyun.sms.signName}")
    private String signName;

    @GetMapping("test1")
    public R test1(){
        return R.ok().data("signName", signName);
    }

    @GetMapping("test2")
    public R test2(){
        return R.ok().data("smsProperties", smsProperties);
    }
}