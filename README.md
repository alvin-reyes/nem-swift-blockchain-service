# Swift / Blockchain Library Web Service

A sample web service app written using Spring Boot to showcase sending a Swift Transaction and as well as decoding them. This project is used to show case the sending of Swift Transaction via a REST Web Service Post Call that then uses the nem-swift-blockchain-lib to send it to the blockchain

<h3>Usage</h3>

<h4>Decode message</h4>

	Endpoint: https://<host>/nemswiftsvc/transaction/decode
	//	prepare data and decode
	this.data = { 'sender': trans.signer.publicKey, 'receipt': this.privatekey, 'swift': payload };
	this.http.post('https://<host>/nemswiftsvc/transaction/decode', this.data).subscribe(data => {
        	this.decodedMessage = data['decodedMessage'];
      	});
	
<h4>Send</h4>

Endpoint: https://<host>/nemswiftsvc/transaction/send
	
	//    prepare data and send
	this.data = { 'sender': this.sender, 'receipt': this.recipientPublickKey, 'swift': this.swiftMessage };
	this.http.post('https://<host>/nemswiftsvc/transaction/send', this.data)
		.subscribe(transdata => {console.log(transdata);});


<h4>Live deployed endpoints for testing</h4>

	https://swift-nem-bc.herokuapp.com/nemswiftsvc/transaction/decode
	https://swift-nem-bc.herokuapp.com/nemswiftsvc/transaction/send

<h3>Testing</h3>

Run the JUnit Test cases using Maven or use it as a reference.

	mvn test

<h3>Build</h3>

Like any other maven project, just do the maven command below.

    mvn clean install

<h3>Technology Stack</h4>
Java 8 | Angular | Spring Boot | nemlibrary  
<sub>Copyright (c) 2017</sub>
