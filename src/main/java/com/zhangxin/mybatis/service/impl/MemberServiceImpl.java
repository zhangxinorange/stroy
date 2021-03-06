package com.zhangxin.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zhangxin.mybatis.mapper.MemberMapper;
import com.zhangxin.mybatis.model.Member;
import com.zhangxin.mybatis.service.MemberService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

@Service
public class MemberServiceImpl extends BaseService<Member> implements MemberService{
	
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public List<Member> selectAllMember(Member member, int page, int row) {
		Example example = new Example(Member.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(member.getmEmail())) {
            criteria.andLike("mEmail", "%" + member.getmEmail() + "%");
        }
        if (member.getmId() != null) {
            criteria.andEqualTo("mId", member.getmId());
        }
        //分页查询
        PageHelper.startPage(page, row);
        return selectByExample(example);
	}

	@Override
	public List<Member> selectMember(Member member) {
		List<Member> lst=memberMapper.select(member);
		return lst;
	}

}
