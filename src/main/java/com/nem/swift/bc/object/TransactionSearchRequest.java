package com.nem.swift.bc.object;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionSearchRequest {
	
	@JsonProperty("addressId")
	private String addressId;

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	
	
}
