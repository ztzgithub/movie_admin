package com.ztt.movie.service.trade.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztt.movie.common.base.result.ResultCodeEnum;
import com.ztt.movie.service.base.dto.CourseDto;
import com.ztt.movie.service.base.dto.MemberDto;
import com.ztt.movie.service.base.exception.MovieException;
import com.ztt.movie.service.trade.entity.Order;
import com.ztt.movie.service.trade.feign.EduCourseService;
import com.ztt.movie.service.trade.feign.UcenterMemberService;
import com.ztt.movie.service.trade.mapper.OrderMapper;
import com.ztt.movie.service.trade.service.OrderService;
import com.ztt.movie.service.trade.util.OrderNoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author ztt
 * @since 2021-02-19
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private EduCourseService eduCourseService;

    @Autowired
    private UcenterMemberService ucenterMemberService;

    @Override
    public String saveOrder(String courseId, String memberId) {

        //查询当前用户是否已有当前课程的订单
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", courseId);
        queryWrapper.eq("member_id", memberId);
        Order orderExist = baseMapper.selectOne(queryWrapper);
        if(orderExist != null){
            return orderExist.getId(); //如果订单已存在，则直接返回订单id
        }

        //查询课程信息
        CourseDto courseDto = eduCourseService.getCourseDtoById(courseId);
        if (courseDto == null) {
            throw new MovieException(ResultCodeEnum.PARAM_ERROR);
        }

        //查询用户信息
        MemberDto memberDto = ucenterMemberService.getMemberDtoByMemberId(memberId);
        if (memberDto == null) {
            throw new MovieException(ResultCodeEnum.PARAM_ERROR);
        }

        //创建订单
        Order order = new Order();
        order.setOrderNo(OrderNoUtils.getOrderNo());
        order.setCourseId(courseId);
        order.setCourseTitle(courseDto.getTitle());
        order.setCourseCover(courseDto.getCover());
        order.setTeacherName(courseDto.getTeacherName());
        order.setTotalFee(courseDto.getPrice().multiply(new BigDecimal(100)));//分
        order.setMemberId(memberId);
        order.setMobile(memberDto.getMobile());
        order.setNickname(memberDto.getNickname());
        order.setStatus(0);//未支付
        order.setPayType(1);//微信支付
        baseMapper.insert(order);
        return order.getId();
    }

    @Override
    public Order getByOrderId(String orderId, String memberId) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("id", orderId)
                .eq("member_id", memberId);
        Order order = baseMapper.selectOne(queryWrapper);
        return order;
    }

    @Override
    public Boolean isBuyByCourseId(String courseId, String memberId) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("member_id", memberId)
                .eq("course_id", courseId)
                .eq("status", 1);
        Integer count = baseMapper.selectCount(queryWrapper);
        return count.intValue() > 0;
    }
}
