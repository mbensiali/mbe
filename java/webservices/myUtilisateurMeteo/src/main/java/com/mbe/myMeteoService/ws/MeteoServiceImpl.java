package com.mbe.myMeteoService.ws;

import java.util.Random;

import javax.jws.WebService;

@WebService(endpointInterface="com.mbe.myMeteoService.ws.IMeteoService")
public class MeteoServiceImpl implements IMeteoService {

	private String WEATHER [] = {"Pluvieux", "Ensoleillé", "Nuageux", "Enneigeux"};
	
	Random r = new Random();
	
	@Override
	public String getWeatherAt(String lieu, String date) {
		String theWeather = null;
		theWeather = "the weather at " + lieu + " on " + date + " is: " + WEATHER [r.nextInt(4)];
		return theWeather;
	}

}
