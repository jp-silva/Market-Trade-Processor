package com.currencyfair.mtp.models;

import java.io.Serializable;

public class SimpleRestResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private final String status;
	private final String message;

	public SimpleRestResponse(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public static SimpleRestResponse getSimpleSuccessResponse(String message) {
		return new SimpleRestResponse("success", message);
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
}
