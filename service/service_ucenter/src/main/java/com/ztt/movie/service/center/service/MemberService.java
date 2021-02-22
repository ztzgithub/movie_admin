package com.ztt.movie.service.center.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ztt.movie.service.base.dto.MemberDto;
import com.ztt.movie.service.center.entity.Member;
import com.ztt.movie.service.center.entity.vo.LoginVo;
import com.ztt.movie.service.center.entity.vo.RegisterVo;

/**
 * @author ztt
 * @Date: Created in 2021/2/18 22:44
 */
public interface MemberService extends IService<Member> {

    void register(RegisterVo registerVo);

    String login(LoginVo loginVo);

    MemberDto getMemberDtoByMemberId(String memberId);

    Integer countRegisterNum(String day);
}
