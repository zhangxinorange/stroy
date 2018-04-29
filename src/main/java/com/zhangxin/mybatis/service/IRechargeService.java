package com.zhangxin.mybatis.service;

import java.util.List;

import com.zhangxin.mybatis.model.Recharge;

/**
 * @author liuzh_3nofxnp
 * @since 2015-09-19 17:17
 */
public interface IRechargeService extends IService<Recharge> {

	 /**
     * 根据条件分页查询
     *
     * @param country
     * @param page
     * @param rows
     * @return
     */
    List<Recharge> selectByRecharge(Recharge recharge, int page, int rows);
}
