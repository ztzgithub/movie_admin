package com.ztt.movie.service.sms.service;

import com.netflix.client.ClientException;

public interface SmsService {

    void send(String mobile, String checkCode) throws ClientException, com.aliyuncs.exceptions.ClientException;
}