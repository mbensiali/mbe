package com.courtalon.endpoint;

import javax.xml.ws.Endpoint;

import com.courtalon.ws.HelloWorldImpl;

public class HelloWorldPublisher {

	public static void main(String[] args) {
		
		Endpoint.publish("http://localhost:8235/ws/hello",
				new HelloWorldImpl());
		System.out.println("serveur démarré");
	}

}
