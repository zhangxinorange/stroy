package com.zhangxin.mybatis.model;

import java.util.Date;
import javax.persistence.*;
/***
 * 读取人关联
 * @author pc
 *
 */
@Table(name = "readContent")
public class ReadContent {
    @Id
    @Column(name = "r_iD")
    @GeneratedValue(generator = "JDBC")
    private Long rId;

    /**
     * 小说Id
     */
    @Column(name = "c_id")
    private Long cId;

    /**
     * 阅读人
     */
    @Column(name = "m_id")
    private Long mId;

    /**
     * 阅读时间
     */
    @Column(name = "r_create_Date")
    private Date rCreateDate;

    /**
     * @return r_iD
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
     * 获取小说Id
     *
     * @return c_id - 小说Id
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
     * 获取阅读人
     *
     * @return m_id - 阅读人
     */
    public Long getmId() {
        return mId;
    }

    /**
     * 设置阅读人
     *
     * @param mId 阅读人
     */
    public void setmId(Long mId) {
        this.mId = mId;
    }

    /**
     * 获取阅读时间
     *
     * @return r_create_Date - 阅读时间
     */
    public Date getrCreateDate() {
        return rCreateDate;
    }

    /**
     * 设置阅读时间
     *
     * @param rCreateDate 阅读时间
     */
    public void setrCreateDate(Date rCreateDate) {
        this.rCreateDate = rCreateDate;
    }
}