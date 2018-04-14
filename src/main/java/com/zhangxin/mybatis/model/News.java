package com.zhangxin.mybatis.model;

import java.util.Date;
import javax.persistence.*;
/***
 * 新闻表
 * @author pc
 *
 */
@Table(name = "news")
public class News {
    @Id
    @Column(name = "n_Id")
    @GeneratedValue(generator = "JDBC")
    private Long nId;

    /**
     * 新闻标题
     */
    @Column(name = "n_title")
    private String nTitle;

    /**
     * 发布时间
     */
    @Column(name = "n_create_date")
    @OrderBy("desc")
    private Date nCreateDate;

    /**
     * 新闻内容
     */
    @Column(name = "n_content")
    private String nContent;

    /**
     * @return n_Id
     */
    public Long getnId() {
        return nId;
    }

    /**
     * @param nId
     */
    public void setnId(Long nId) {
        this.nId = nId;
    }

    /**
     * 获取新闻标题
     *
     * @return n_title - 新闻标题
     */
    public String getnTitle() {
        return nTitle;
    }

    /**
     * 设置新闻标题
     *
     * @param nTitle 新闻标题
     */
    public void setnTitle(String nTitle) {
        this.nTitle = nTitle;
    }

    /**
     * 获取发布时间
     *
     * @return n_create_date - 发布时间
     */
    public Date getnCreateDate() {
        return nCreateDate;
    }

    /**
     * 设置发布时间
     *
     * @param nCreateDate 发布时间
     */
    public void setnCreateDate(Date nCreateDate) {
        this.nCreateDate = nCreateDate;
    }

    /**
     * 获取新闻内容
     *
     * @return n_content - 新闻内容
     */
    public String getnContent() {
        return nContent;
    }

    /**
     * 设置新闻内容
     *
     * @param nContent 新闻内容
     */
    public void setnContent(String nContent) {
        this.nContent = nContent;
    }
}