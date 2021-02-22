package com.ztt.movie.service.edu.service;

import com.ztt.movie.service.edu.entity.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ztt.movie.service.edu.entity.vo.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author ztt
 * @since 2021-01-22
 */
public interface ChapterService extends IService<Chapter> {

    boolean removeChapterById(String id);

    List<ChapterVo> nestedList(String courseId);
}
