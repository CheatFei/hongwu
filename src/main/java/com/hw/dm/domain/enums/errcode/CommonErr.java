package com.hw.dm.domain.enums.errcode;

/**
 * 基础错误码 3位即可 除这里的错误码，其他地方的用6位
 */
public enum CommonErr implements ErrCode<CommonErr>{

	C_400(-400, "参数错误"),
	C_401(-401, "Json解析错误"),
	C_777(-777, "用户未登录"),
	C_500(-500, "处理失败未知错误"),
	C_501(-501, "权限错误，不能进行此操作"),
	C_502(-502, "请求频率过高，请稍后再试");



	private final Integer code;
	private final String desc;

	CommonErr(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	@Override
	public Integer getCode() {
		return code;
	}

	@Override
	public String getDesc() {
		return desc;
	}

}