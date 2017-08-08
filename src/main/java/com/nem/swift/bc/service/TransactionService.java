package com.nem.swift.bc.service;

import java.io.IOException;

import org.apache.commons.codec.binary.Base32;
import org.nem.core.crypto.KeyPair;
import org.nem.core.crypto.PrivateKey;
import org.nem.core.crypto.PublicKey;
import org.nem.core.messages.SecureMessage;
import org.nem.core.model.Account;
import org.nem.core.model.Address;
import org.nem.core.serialization.AddressEncoding;
import org.nem.core.utils.Base32Encoder;
import org.nem.core.utils.HexEncoder;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.nem.swift.bc.object.Status;
import com.nem.swift.bc.object.TransactionDecodeResponse;
import com.nem.swift.bc.object.TransactionRequest;
import com.nem.swift.bc.object.TransactionResponse;
import com.nem.swift.bc.object.TransactionSearchRequest;
import com.prowidesoftware.swift.io.ConversionService;
import io.nem.builders.SwiftBlockchainTransactionBuilder;
import io.nem.factories.AttachmentFactory;
import io.nem.factories.EntityFactory;
import io.nem.swift.crypto.SecureMessageSwiftPayloadDecoder;
import io.nem.swift.crypto.SecureMessageSwiftPayloadEncoder;
import io.nem.util.GzipUtils;

@RestController
@RequestMapping("/transaction")
@EnableAsync
@CrossOrigin("http://localhost:4200")
public class TransactionService {

	@RequestMapping(method = RequestMethod.POST, path = "/send")
	public TransactionResponse sendTransaction(@RequestBody TransactionRequest request) {

		final Account senderAccount = new Account(new KeyPair(PrivateKey.fromHexString(request.getSenderAddress())));
		final Account recipientAccount = new Account(new KeyPair(PublicKey.fromHexString(request.getReceiptAddress())));

		SecureMessage message;
		try {

			message = SecureMessageSwiftPayloadEncoder.encodeAndGzipCompress(senderAccount, recipientAccount,
					request.getSwiftMessage());

			SwiftBlockchainTransactionBuilder.getInstance().setSender(senderAccount).setRecipient(recipientAccount)
					.setAttachment(AttachmentFactory.createTransferTransactionAttachment(message))
					.buildAndSendTransaction(); // build and send it!

		} catch (Exception e) {
			e.printStackTrace();
			return new TransactionResponse(request, Status.FAILED, e.getMessage());
		}
		return new TransactionResponse(request, Status.SUCCESS, "Transfer In Progress");
	}

	@RequestMapping(method = RequestMethod.POST, path = "/decode", produces = "application/json")
	public TransactionDecodeResponse getDecodedMessage(@RequestBody TransactionRequest request) {
		try {

			final KeyPair senderKeyPair = new KeyPair(PublicKey.fromHexString(request.getSenderAddress()));
			final KeyPair recipientKeyPair = new KeyPair(PrivateKey.fromHexString(request.getReceiptAddress()));

			String decode = SecureMessageSwiftPayloadDecoder.decodeAndGzipUncompress(senderKeyPair, recipientKeyPair,
					request.getSwiftMessage());
			
			return new TransactionDecodeResponse(decode);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
