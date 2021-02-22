package com.ztt.movie.service.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztt.movie.service.edu.entity.Subject;
import com.ztt.movie.service.edu.entity.vo.SubjectVo;

import java.util.List;

/**
 * <p>
 * 课程科目 Mapper 接口
 * </p>
 *
 * @author ztt
 * @since 2021-01-22
 */
public interface SubjectMapper extends BaseMapper<Subject> {


    List<SubjectVo> selectNestedListByParentId(String parentId);
}
