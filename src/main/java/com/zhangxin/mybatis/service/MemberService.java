package com.zhangxin.mybatis.service;

import java.util.List;

import com.zhangxin.mybatis.model.Member;

public interface MemberService extends IService<Member> {
	List<Member> selectAllMember(Member member,int page,int row);
	
	List<Member> selectMember(Member member);
}
