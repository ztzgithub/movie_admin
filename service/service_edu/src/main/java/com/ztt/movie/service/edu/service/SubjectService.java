package com.ztt.movie.service.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ztt.movie.service.edu.entity.Subject;
import com.ztt.movie.service.edu.entity.vo.SubjectVo;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author ztt
 * @since 2021-01-22
 */
public interface SubjectService extends IService<Subject> {

    void batchImport(InputStream inputStream);

    List<SubjectVo> nestedList();
}
