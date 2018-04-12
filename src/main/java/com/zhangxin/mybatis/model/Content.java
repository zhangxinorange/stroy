package com.zhangxin.mybatis.model;
/****
 * 销售内容
 */
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zhangxin.mybatis.util.CustomDateSerializer;

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
    @OrderBy("desc")
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
    @JsonSerialize(using = CustomDateSerializer.class) 
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
	public Content() {
		super();
	}

	public Content(String cTitle, String cAuthor, String cDesc) {
		super();
		this.cTitle = cTitle;
		this.cAuthor = cAuthor;
		this.cDesc = cDesc;
	}
	/***
	 * 小说标题图
	 */
	@Column(name = "c_picStr")
    private String cPicStr;

	public String getcPicStr() {
		return cPicStr;
	}

	public void setcPicStr(String cPicStr) {
		this.cPicStr = cPicStr;
	}

	public Content(Long cId, String cTitle, String cAuthor, String cDesc) {
		super();
		this.cId = cId;
		this.cTitle = cTitle;
		this.cAuthor = cAuthor;
		this.cDesc = cDesc;
	}
	public Content(Long cId, String cTitle, String cAuthor, String cDesc,Long cAdmin) {
		super();
		this.cId = cId;
		this.cTitle = cTitle;
		this.cAuthor = cAuthor;
		this.cDesc = cDesc;
		this.cAdmin = cAdmin;
	}
	
	public Content( String cTitle, String cAuthor, String cDesc,Long cAdmin) {
		super();
		this.cTitle = cTitle;
		this.cAuthor = cAuthor;
		this.cDesc = cDesc;
		this.cAdmin = cAdmin;
	}
    
	/***
	 *是否需要下载观看
	 */
	@Column(name = "c_admin")
	private Long cAdmin;

	public Long getcAdmin() {
		return cAdmin;
	}

	public void setcAdmin(Long cAdmin) {
		this.cAdmin = cAdmin;
	}
	
    
}