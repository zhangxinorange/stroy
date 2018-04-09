package com.zhangxin.mybatis.model;

import java.util.Date;
import javax.persistence.*;
/***
 * 文章类别
 * @author pc
 *
 */
@Table(name = "type")
public class Type {
    @Id
    @Column(name = "t_id")
    @GeneratedValue(generator = "JDBC")
    private Long tId;

    /**
     * 类别名称
     */
    @Column(name = "t_Name")
    private String tName;

    /**
     * 创建时间
     */
    @Column(name = "t_create_Date")
    private Date tCreateDate;

    /**
     * @return t_id
     */
    public Long gettId() {
        return tId;
    }

    /**
     * @param tId
     */
    public void settId(Long tId) {
        this.tId = tId;
    }

    /**
     * 获取类别名称
     *
     * @return t_Name - 类别名称
     */
    public String gettName() {
        return tName;
    }

    /**
     * 设置类别名称
     *
     * @param tName 类别名称
     */
    public void settName(String tName) {
        this.tName = tName;
    }

    /**
     * 获取创建时间
     *
     * @return t_create_Date - 创建时间
     */
    public Date gettCreateDate() {
        return tCreateDate;
    }

    /**
     * 设置创建时间
     *
     * @param tCreateDate 创建时间
     */
    public void settCreateDate(Date tCreateDate) {
        this.tCreateDate = tCreateDate;
    }
}