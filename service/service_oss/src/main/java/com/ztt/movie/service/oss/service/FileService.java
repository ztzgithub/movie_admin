package com.ztt.movie.service.oss.service;

import java.io.InputStream;

public interface FileService {

    /**
     * 文件上传至阿里云
     */
    String upload(InputStream inputStream, String module, String originalFilename);

    void removeFile(String url);
}