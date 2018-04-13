package com.zhangxin.mybatis.model;

import java.util.Date;

import javax.persistence.Column;

import com.zhangxin.mybatis.util.StringUtil;

public class ContentTemp {

	private Long cId;

	private String cTitle;

	private String cAuthor;

	private String cDesc;

	private Date cCreateDate;
	private byte[] cContent;

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
	 * @param cTitle
	 *            小说标题
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
	 * @param cAuthor
	 *            小说作者
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
	 * @param cDesc
	 *            小说简介
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
	 * @param cCreateDate
	 *            小说创建时间
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
	 * @param cContent
	 *            小说内容
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

	public void setcPic(byte[] cPic) {
		this.cPic = cPic;
	}

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	/***
	 * 小说标题图
	 */
    private String cPicStr;

	public String getcPicStr() {
		return cPicStr;
	}

	public void setcPicStr(String cPicStr) {
		this.cPicStr = cPicStr;
	}
	/***
	 * 小说内容
	 */
	private String detail;
	
	/***
	 * 小说内容
	 */
	private String detailHtml;

	public String getDetail() {
		return StringUtil.delHtmlTag(detail);
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	private String typeStr;

	public String getTypeStr() {
		return typeStr;
	}

	public void setTypeStr(String typeStr) {
		this.typeStr = typeStr;
	}
	
	private Long cAdmin;

	public Long getcAdmin() {
		return cAdmin;
	}

	public void setcAdmin(Long cAdmin) {
		this.cAdmin = cAdmin;
	}
	
	private String adminStr;

	public String getAdminStr() {
		return adminStr;
	}

	public void setAdminStr(String adminStr) {
		this.adminStr = adminStr;
	}

	public String getDetailHtml() {
		return detailHtml;
	}

	public void setDetailHtml(String detailHtml) {
		this.detailHtml = detailHtml;
	}
	
	
}