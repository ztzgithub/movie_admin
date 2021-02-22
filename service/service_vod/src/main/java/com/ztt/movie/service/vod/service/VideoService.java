package com.ztt.movie.service.vod.service;

import com.aliyun.oss.ClientException;

import java.io.InputStream;
import java.util.List;

public interface VideoService {
    String uploadVideo(InputStream file, String originalFilename);

    void removeVideo(String videoId) throws ClientException, com.aliyuncs.exceptions.ClientException;

    void removeVideoByIdList(List<String> videoIdList) throws com.aliyuncs.exceptions.ClientException;

    String getPlayAuth(String videoSourceId) throws com.aliyuncs.exceptions.ClientException;
}