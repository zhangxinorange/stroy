package com.zhangxin.mybatis.model;

import java.util.Date;
import javax.persistence.*;
/***
 * 下载量
 * @author pc
 *
 */
@Table(name = "download")
public class Download {
    @Id
    @Column(name = "d_id")
    @GeneratedValue(generator = "JDBC")
    private Long dId;

    /**
     * 小说主键
     */
    @Column(name = "s_Id")
    private Long sId;

    /**
     * 下载人
     */
    @Column(name = "c_Id")
    private Long cId;

    /**
     * 下载时间
     */
    @Column(name = "d_create_date")
    private Date dCreateDate;

    /**
     * @return d_id
     */
    public Long getdId() {
        return dId;
    }

    /**
     * @param dId
     */
    public void setdId(Long dId) {
        this.dId = dId;
    }

    /**
     * 获取小说主键
     *
     * @return s_Id - 小说主键
     */
    public Long getsId() {
        return sId;
    }

    /**
     * 设置小说主键
     *
     * @param sId 小说主键
     */
    public void setsId(Long sId) {
        this.sId = sId;
    }

    /**
     * 获取下载人
     *
     * @return c_Id - 下载人
     */
    public Long getcId() {
        return cId;
    }

    /**
     * 设置下载人
     *
     * @param cId 下载人
     */
    public void setcId(Long cId) {
        this.cId = cId;
    }

    /**
     * 获取下载时间
     *
     * @return d_create_date - 下载时间
     */
    public Date getdCreateDate() {
        return dCreateDate;
    }

    /**
     * 设置下载时间
     *
     * @param dCreateDate 下载时间
     */
    public void setdCreateDate(Date dCreateDate) {
        this.dCreateDate = dCreateDate;
    }
}