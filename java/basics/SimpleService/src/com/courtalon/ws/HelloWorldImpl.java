package com.courtalon.ws;

import java.util.Date;

import javax.jws.WebService;

@WebService(endpointInterface="com.courtalon.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String getHelloWorldAsString(String name) {
		return "[" + new Date() + "] Hello form jax-ws, " + name;
	}

}
