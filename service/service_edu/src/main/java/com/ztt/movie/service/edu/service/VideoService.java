package com.ztt.movie.service.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ztt.movie.service.edu.entity.Video;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author ztt
 * @since 2021-01-22
 */
public interface VideoService extends IService<Video> {

    void removeMediaVideoById(String id);


    void removeMediaVideoByChapterId(String chapterId);

    void removeMediaVideoByCourseId(String courseId);

}
