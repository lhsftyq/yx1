package com.sys.entity;

public class ResultMessage {

	private String code;
	private String message;
	private long count;
	private Object data;

	ResultMessage(String code, String message, long count, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
		this.count = count;
	}

	ResultMessage(String code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	// 分页返回参数
	public static ResultMessage resultEntity(String code, String message, long count, Object data) {
		return new ResultMessage(code, message, count, data);
	}

	// 返回参数
	public static ResultMessage resultEntity(String code, String message, Object data) {
		return new ResultMessage(code, message, data);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

}
