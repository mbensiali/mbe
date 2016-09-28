package com.mbe.myFirstService.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.DOCUMENT)
public interface ISimpleService {
	
	@WebMethod
	String getSalutation(String name );
	
	@WebMethod
	Tache getTache(int id);
	
	@WebMethod
	public Tache[] getTaches();
	

}
