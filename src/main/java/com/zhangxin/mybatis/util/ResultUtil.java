package com.zhangxin.mybatis.util;

/**
 * Created by 张鑫 2017-01-21 13:39
 */
public class ResultUtil {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Result success(Object object) {
		Result result = new Result();
		result.setCode(0);
		result.setMsg("成功");
		result.setData(object);
		return result;
	}

	@SuppressWarnings("rawtypes")
	public static Result success() {
		return success(new Object());
	}

	public static Result success(String msg) {
		Result result = new Result();
		result.setCode(0);
		result.setMsg(msg);
		result.setData(null);
		return result;
	}

	@SuppressWarnings("rawtypes")
	public static Result error(Integer code, String msg) {
		Result result = new Result();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
}
