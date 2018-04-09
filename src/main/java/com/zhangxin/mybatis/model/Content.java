package com.zhangxin.mybatis.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "content")
public class Content {
    @Id
    @Column(name = "c_Id")
    @GeneratedValue(generator = "JDBC")
    private Long cId;

    /**
     * 小说标题
     */
    @Column(name = "c_title")
    private String cTitle;

    /**
     * 小说作者
     */
    @Column(name = "c_author")
    private String cAuthor;

    /**
     * 小说简介
     */
    @Column(name = "c_desc")
    private String cDesc;

    /**
     * 小说创建时间
     */
    @Column(name = "c_create_date")
    private Date cCreateDate;

    /**
     * 小说内容
     */
    @Column(name = "c_content")
    private byte[] cContent;

    /**
     * 小说标题图
     */
    @Column(name = "c_pic")
    private byte[] cPic;

    /**
     * @return c_Id
     */
    public Long getcId() {
        return cId;
    }

    /**
     * @param cId
     */
    public void setcId(Long cId) {
        this.cId = cId;
    }

    /**
     * 获取小说标题
     *
     * @return c_title - 小说标题
     */
    public String getcTitle() {
        return cTitle;
    }

    /**
     * 设置小说标题
     *
     * @param cTitle 小说标题
     */
    public void setcTitle(String cTitle) {
        this.cTitle = cTitle;
    }

    /**
     * 获取小说作者
     *
     * @return c_author - 小说作者
     */
    public String getcAuthor() {
        return cAuthor;
    }

    /**
     * 设置小说作者
     *
     * @param cAuthor 小说作者
     */
    public void setcAuthor(String cAuthor) {
        this.cAuthor = cAuthor;
    }

    /**
     * 获取小说简介
     *
     * @return c_desc - 小说简介
     */
    public String getcDesc() {
        return cDesc;
    }

    /**
     * 设置小说简介
     *
     * @param cDesc 小说简介
     */
    public void setcDesc(String cDesc) {
        this.cDesc = cDesc;
    }

    /**
     * 获取小说创建时间
     *
     * @return c_create_date - 小说创建时间
     */
    public Date getcCreateDate() {
        return cCreateDate;
    }

    /**
     * 设置小说创建时间
     *
     * @param cCreateDate 小说创建时间
     */
    public void setcCreateDate(Date cCreateDate) {
        this.cCreateDate = cCreateDate;
    }

    /**
     * 获取小说内容
     *
     * @return c_content - 小说内容
     */
    public byte[] getcContent() {
        return cContent;
    }

    /**
     * 设置小说内容
     *
     * @param cContent 小说内容
     */
    public void setcContent(byte[] cContent) {
        this.cContent = cContent;
    }

    /**
     * 获取小说标题图
     *
     * @return c_pic - 小说标题图
     */
    public byte[] getcPic() {
        return cPic;
    }

    /**
     * 设置小说标题图
     *
     * @param cPic 小说标题图
     */
    public void setcPic(byte[] cPic) {
        this.cPic = cPic;
    }
}