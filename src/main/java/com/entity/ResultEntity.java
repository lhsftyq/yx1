package com.entity;

public class ResultEntity {

	private String code;
	private String message;
	private Object data;

	ResultEntity(String code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public static ResultEntity resultEntity(String code, String message, Object data) {
		return new ResultEntity(code, message, data);
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

}
