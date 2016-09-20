package com.mbe.spring_memento.beans;

public class Factoriel implements IFactoriel {

	@Override
	public double calculFactorielDe(int nombre) {
		if(nombre <= 1)
			return 1;
		else
			return nombre * calculFactorielDe(nombre-1);
	}

	@Override
	public double calculLeTripleDe(int nombre) {
		return nombre * 3;
	}

}
