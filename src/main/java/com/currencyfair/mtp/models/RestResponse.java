package com.currencyfair.mtp.models;

import java.io.Serializable;

public class RestResponse<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String status;
	private String message;
	private T data;

	private RestResponse(String status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	private RestResponse(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public static <T> RestResponse<T> getSuccessResponse(String message) {
		return new RestResponse<T>("success", message, null);
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}
}
