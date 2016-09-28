package com.mbe.myFirstService;

import javax.xml.ws.Endpoint;

import com.mbe.myFirstService.ws.SimpleServiceImpl;

public class ServicePublisher {

	public static void main(String[] args) {
		System.out.println("lancement service...");
		Endpoint.publish("http://localhost:8181/ws/simple", new SimpleServiceImpl());
		System.out.println("service lancé....");

	}

}
