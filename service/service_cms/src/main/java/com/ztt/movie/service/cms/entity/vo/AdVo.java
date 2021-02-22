package com.ztt.movie.service.cms.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ztt
 * @since 2020/4/26
 */
@Data
public class AdVo implements Serializable {

    private static final long serialVersionUID=1L;
    private String id;
    private String title;
    private Integer sort;
    private String type;
}
