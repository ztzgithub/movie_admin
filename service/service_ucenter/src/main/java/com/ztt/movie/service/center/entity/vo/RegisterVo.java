package com.ztt.movie.service.center.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nickname;
    private String mobile;
    private String password;
    private String code;
}