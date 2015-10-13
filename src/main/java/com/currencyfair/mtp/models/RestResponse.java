package com.currencyfair.mtp.models;

import java.io.Serializable;

public class RestResponse<T> extends SimpleRestResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private final T data;

	private RestResponse(String status, String message, T data) {
		super(status, message);
		this.data = data;
	}

	public static <T> RestResponse<T> getSuccessResponse(String message) {
		return new RestResponse<T>("success", message, null);
	}

	public T getData() {
		return data;
	}
}
