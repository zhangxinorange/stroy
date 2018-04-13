package com.zhangxin.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.zhangxin.mybatis.model.ReadContent;
import com.zhangxin.mybatis.model.ReadContentTemp;

import tk.mybatis.mapper.common.Mapper;

public interface ReadMapper extends Mapper<ReadContent> {
	/*@Select("SELECT s.*,c.`c_title`,m.`m_Name`  FROM readcontent s LEFT JOIN content c ON c.`c_Id`=s.`c_id` "
			+ "LEFT JOIN member m ON m.`m_Id`=s.`m_id` ORDER BY s.`r_create_Date` DESC  limit #{0} , #{1}")*/
	public List<ReadContentTemp> getReadMap(Map map);
	
	public int getCountReadMap();
}