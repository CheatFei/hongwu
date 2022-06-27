package com.hw.dm.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;


/**
 * 请求消息返回
 * IMPORTANT: 所有错误码消息全部通过 ErrCode#reply() 返回，请勿在此类增加创建错误消息的public方法。
 */
@Data
@AllArgsConstructor
public class ReturnMsg<T> implements Serializable {
	@JsonProperty("return_code")
	private Integer code;
	@JsonProperty("return_message")
	private String msg;
	private T data;

	public ReturnMsg() {
	}

	public static <T> ReturnMsg<T> success() {
		return success(null);
	}

	public static <T>ReturnMsg<T> success(T data) {
		ReturnMsg<T> returnMsg = new ReturnMsg<>();
		returnMsg.setCode(0);
		returnMsg.setMsg("操作成功");
		returnMsg.setData(data);
		return returnMsg;
	}

	/**
	 * 不主动使用，调用资金时异常报文转换
	 * @param data
	 * @param <T>
	 * @return
	 */
	public static <T> ReturnMsg<T> fail(Integer code, T data) {
		ReturnMsg<T> returnMsg = new ReturnMsg<>();
		returnMsg.setCode(code);
		returnMsg.setMsg("操作成功");
		returnMsg.setData(data);
		return returnMsg;
	}

}
