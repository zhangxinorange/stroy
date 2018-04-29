package com.zhangxin.mybatis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zhangxin.mybatis.model.Recharge;
import com.zhangxin.mybatis.service.IRechargeService;

import tk.mybatis.mapper.entity.Example;
@Service
public class RechargeServiceImpl extends BaseService<Recharge> implements IRechargeService {

	@Override
	public List<Recharge> selectByRecharge(Recharge recharge, int page, int rows) {
		Example example = new Example(Recharge.class);
        Example.Criteria criteria = example.createCriteria();
        
        if (recharge.getUserId()!= null) {
            criteria.andEqualTo("userId", recharge.getUserId());
        }
        example.orderBy("createTime ");
        //分页查询
        PageHelper.startPage(page, rows);
        return selectByExample(example);
	}

}
