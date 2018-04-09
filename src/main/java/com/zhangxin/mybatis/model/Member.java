package com.zhangxin.mybatis.model;

import java.util.Date;
import javax.persistence.*;
/***
 * 会员管理
 * @author pc
 *
 */
@Table(name = "member")
public class Member {
    @Id
    @Column(name = "m_Id")
    @GeneratedValue(generator = "JDBC")
    private Long mId;

    /**
     * 邮箱
     */
    @Column(name = "m_email")
    private String mEmail;

    /**
     * 电话
     */
    @Column(name = "m_phone")
    private String mPhone;

    /**
     * 密码
     */
    @Column(name = "m_password")
    private String mPassword;

    /**
     * 创建时间
     */
    @Column(name = "m_create_date")
    private Date mCreateDate;

    /**
     * 是否管理员
     */
    @Column(name = "m_type")
    private Integer mType;

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
     * 获取邮箱
     *
     * @return m_email - 邮箱
     */
    public String getmEmail() {
        return mEmail;
    }

    /**
     * 设置邮箱
     *
     * @param mEmail 邮箱
     */
    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    /**
     * 获取电话
     *
     * @return m_phone - 电话
     */
    public String getmPhone() {
        return mPhone;
    }

    /**
     * 设置电话
     *
     * @param mPhone 电话
     */
    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    /**
     * 获取密码
     *
     * @return m_password - 密码
     */
    public String getmPassword() {
        return mPassword;
    }

    /**
     * 设置密码
     *
     * @param mPassword 密码
     */
    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    /**
     * 获取创建时间
     *
     * @return m_create_date - 创建时间
     */
    public Date getmCreateDate() {
        return mCreateDate;
    }

    /**
     * 设置创建时间
     *
     * @param mCreateDate 创建时间
     */
    public void setmCreateDate(Date mCreateDate) {
        this.mCreateDate = mCreateDate;
    }

    /**
     * 获取是否管理员
     *
     * @return m_type - 是否管理员
     */
    public Integer getmType() {
        return mType;
    }

    /**
     * 设置是否管理员
     *
     * @param mType 是否管理员
     */
    public void setmType(Integer mType) {
        this.mType = mType;
    }
}