package com.zhangxin.mybatis.model;

import java.util.Date;
import javax.persistence.*;
/****
 * 留言版
 * @author pc
 *
 */
@Table(name = "message")
public class Message {
    @Column(name = "m_Id")
    @GeneratedValue(generator = "JDBC")
    private Long mId;

    /**
     * 发言人
     */
    @Column(name = "member_Id")
    private Long memberId;

    /**
     * 小说Id
     */
    @Column(name = "c_iD")
    private Long cId;

    /**
     * 发言对象
     */
    @Column(name = "r_Id")
    private Long rId;

    /**
     * 留言内容
     */
    @Column(name = "m_content")
    private String mContent;

    /**
     * 是否查看
     */
    private Integer status;

    /**
     * 留言时间
     */
    @Column(name = "m_create_date")
    private Date mCreateDate;

    /**
     * @return m_Id
     */
    public Long getmId() {
        return mId;
    }

    /**
     * @param mId
     */
    public void setmId(Long mId) {
        this.mId = mId;
    }

    /**
     * 获取发言人
     *
     * @return member_Id - 发言人
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * 设置发言人
     *
     * @param memberId 发言人
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    /**
     * 获取小说Id
     *
     * @return c_iD - 小说Id
     */
    public Long getcId() {
        return cId;
    }

    /**
     * 设置小说Id
     *
     * @param cId 小说Id
     */
    public void setcId(Long cId) {
        this.cId = cId;
    }

    /**
     * 获取发言对象
     *
     * @return r_Id - 发言对象
     */
    public Long getrId() {
        return rId;
    }

    /**
     * 设置发言对象
     *
     * @param rId 发言对象
     */
    public void setrId(Long rId) {
        this.rId = rId;
    }

    /**
     * 获取留言内容
     *
     * @return m_content - 留言内容
     */
    public String getmContent() {
        return mContent;
    }

    /**
     * 设置留言内容
     *
     * @param mContent 留言内容
     */
    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    /**
     * 获取是否查看
     *
     * @return status - 是否查看
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置是否查看
     *
     * @param status 是否查看
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取留言时间
     *
     * @return m_create_date - 留言时间
     */
    public Date getmCreateDate() {
        return mCreateDate;
    }

    /**
     * 设置留言时间
     *
     * @param mCreateDate 留言时间
     */
    public void setmCreateDate(Date mCreateDate) {
        this.mCreateDate = mCreateDate;
    }
}