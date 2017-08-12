package com.nem.swift.bc.object;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionRequest {

	@JsonProperty("sender")
	private String senderAddress;
	
	@JsonProperty("receipt")
	private String receiptAddress;
	
	@JsonProperty("multisig")
	private String multiSig;
	
	public String getMultiSig() {
		return multiSig;
	}

	public void setMultiSig(String multiSig) {
		this.multiSig = multiSig;
	}

	@JsonProperty("swift")
	private String swiftMessage;

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getReceiptAddress() {
		return receiptAddress;
	}

	public void setReceiptAddress(String receiptAddress) {
		this.receiptAddress = receiptAddress;
	}

	public String getSwiftMessage() {
		return swiftMessage;
	}

	public void setSwiftMessage(String swiftMessage) {
		this.swiftMessage = swiftMessage;
	}
}
