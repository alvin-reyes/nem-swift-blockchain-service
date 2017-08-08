package com.nem.swift.bc.object;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionDecodeResponse implements Serializable {
	
	@JsonProperty("decodedMessage")
	private String decodedMessage;

	public TransactionDecodeResponse(String message) {
		this.decodedMessage = message;
	}
	public String getDecodedMessage() {
		return decodedMessage;
	}

	public void setDecodedMessage(String decodedMessage) {
		this.decodedMessage = decodedMessage;
	}
	
	
	
}
