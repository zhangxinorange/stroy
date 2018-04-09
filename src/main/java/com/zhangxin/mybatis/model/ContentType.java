package com.zhangxin.mybatis.model;

import javax.persistence.*;

@Table(name = "content_type")
public class ContentType {
    @Id
    @Column(name = "c_type_id")
    @GeneratedValue(generator = "JDBC")
    private Long cTypeId;

    /**
     * 类别Id
     */
    @Column(name = "t_id")
    private Long tId;

    /**
     * 小说Id
     */
    @Column(name = "c_id")
    private Long cId;

    /**
     * @return c_type_id
     */
    public Long getcTypeId() {
        return cTypeId;
    }

    /**
     * @param cTypeId
     */
    public void setcTypeId(Long cTypeId) {
        this.cTypeId = cTypeId;
    }

    /**
     * 获取类别Id
     *
     * @return t_id - 类别Id
     */
    public Long gettId() {
        return tId;
    }

    /**
     * 设置类别Id
     *
     * @param tId 类别Id
     */
    public void settId(Long tId) {
        this.tId = tId;
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
}