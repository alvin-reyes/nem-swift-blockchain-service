package com.nem.swift.bc.object;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionResponse {
	
	@JsonProperty("request")
	private TransactionRequest request;
	
	@JsonProperty("status")
	private Status status;
	
	@JsonProperty("message")
	private String message;
	
	public TransactionResponse(TransactionRequest req, Status status, String message) {
		this.request = req;
		this.status = status;
		this.message = message;
	}

	public TransactionRequest getRequest() {
		return request;
	}

	public void setRequest(TransactionRequest request) {
		this.request = request;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
