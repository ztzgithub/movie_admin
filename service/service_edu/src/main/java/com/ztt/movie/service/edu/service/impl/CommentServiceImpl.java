package com.ztt.movie.service.edu.service.impl;

import com.ztt.movie.service.edu.entity.Comment;
import com.ztt.movie.service.edu.mapper.CommentMapper;
import com.ztt.movie.service.edu.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author ztt
 * @since 2021-01-22
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
