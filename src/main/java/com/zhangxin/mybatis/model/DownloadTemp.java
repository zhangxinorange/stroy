package com.zhangxin.mybatis.model;

import java.util.Date;
import javax.persistence.*;
/***
 * 下载量
 * @author pc
 *
 */
public class DownloadTemp {
    private Long dId;

    /**
     * 下载人
     */
    private Long sId;

    /**
     * 下载人
     */
    private Long cId;

    /**
     * 下载时间
     */
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
    
    private String mName;
    
    private String cTitle;

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getcTitle() {
		return cTitle;
	}

	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}
    
    
    
}