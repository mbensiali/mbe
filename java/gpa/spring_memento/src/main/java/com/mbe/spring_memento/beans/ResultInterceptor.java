package com.mbe.spring_memento.beans;

import java.util.HashMap;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class ResultInterceptor implements MethodInterceptor {
	
	HashMap<String,Double> map = new HashMap<String,Double>();
		 

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		Object[] arguments = mi.getArguments();
		Object returnValue;
		
		if (map.containsKey(arguments[0])) {
			System.out.println("on apelle pas l'original Factoriel, renvoie directment le resultat");
			return map.get(arguments[0]);
		}
		else {
			returnValue = mi.proceed();
			System.out.println("on a appele l'original, renvoie " + returnValue);
			map.put((String)arguments[0], (double)returnValue);
		}
			 
			
		if (map.containsKey(arguments[0])) {
			System.out.println("on apelle pas l'original Triple, renvoie directment le resultat");
			return map.get(arguments[0]);
		}
		else{
			returnValue = mi.proceed();
			System.out.println("on a appele l'original, renvoie " + returnValue);
			map.put((String)Integer.toString((Integer)arguments[0]),(double)returnValue);
			
		}
	
		return returnValue;
	}

}
