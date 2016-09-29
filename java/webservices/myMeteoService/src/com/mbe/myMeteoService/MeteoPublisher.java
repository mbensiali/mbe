package com.mbe.myMeteoService;

import javax.xml.ws.Endpoint;

import com.mbe.myMeteoService.ws.MeteoServiceImpl;

public class MeteoPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8282/IMeteoService", new MeteoServiceImpl());
		System.out.println("service meteo démarré...");

	}

}
