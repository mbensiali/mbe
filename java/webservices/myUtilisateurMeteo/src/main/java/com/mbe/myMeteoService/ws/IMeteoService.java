package com.mbe.myMeteoService.ws;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.DOCUMENT)
public interface IMeteoService {
	
	@WebMethod
	public String getWeatherAt(String lieu, String date);

}
