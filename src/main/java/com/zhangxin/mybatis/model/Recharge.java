package com.zhangxin.mybatis.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "recharge")
public class Recharge {
    @Id
    @Column(name = "r_id")
    @GeneratedValue(generator = "JDBC")
    private Long rId;

    /**
     * 用户Id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 充值金额
     */
    private Double total;

    /**
     * 充值时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return r_id
     */
    public Long getrId() {
        return rId;
    }

    /**
     * @param rId
     */
    public void setrId(Long rId) {
        this.rId = rId;
    }

    /**
     * 获取用户Id
     *
     * @return user_id - 用户Id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户Id
     *
     * @param userId 用户Id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取充值金额
     *
     * @return total - 充值金额
     */
    public Double getTotal() {
        return total;
    }

    /**
     * 设置充值金额
     *
     * @param total 充值金额
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * 获取充值时间
     *
     * @return create_time - 充值时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置充值时间
     *
     * @param createTime 充值时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}