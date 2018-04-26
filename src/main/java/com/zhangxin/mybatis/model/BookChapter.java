package com.zhangxin.mybatis.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "book_chapter")
public class BookChapter {
    @Id
    @Column(name = "b_id")
    @GeneratedValue(generator = "JDBC")
    private Long bId;

    /**
     * 小说Id
     */
    @Column(name = "c_id")
    private Long cId;

    /**
     * 章节标题
     */
    private String title;

    /**
     * 创建时间
     */
    @Column(name = "c_create_date")
    private Date cCreateDate;

    /**
     * 章节内容
     */
    private byte[] content;

    /**
     * @return b_id
     */
    public Long getbId() {
        return bId;
    }

    /**
     * @param bId
     */
    public void setbId(Long bId) {
        this.bId = bId;
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
     * 获取章节标题
     *
     * @return title - 章节标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置章节标题
     *
     * @param title 章节标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取创建时间
     *
     * @return c_create_date - 创建时间
     */
    public Date getcCreateDate() {
        return cCreateDate;
    }

    /**
     * 设置创建时间
     *
     * @param cCreateDate 创建时间
     */
    public void setcCreateDate(Date cCreateDate) {
        this.cCreateDate = cCreateDate;
    }

    /**
     * 获取章节内容
     *
     * @return content - 章节内容
     */
    public byte[] getContent() {
        return content;
    }

    /**
     * 设置章节内容
     *
     * @param content 章节内容
     */
    public void setContent(byte[] content) {
        this.content = content;
    }
}