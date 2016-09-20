package com.mbe.spring_academy.beans;

import java.util.List;
import java.util.Random;

public class InstrumentBuilder {
	
	List<String> instruments;

	public List<String> getInstruments() {
		return instruments;
	}

	public void setInstruments(List<String> instruments) {
		this.instruments = instruments;
	}
	
	public Instrument fournirInstrument(){
		Random rd = new Random();
		Instrument Ins = new Instrument();
		Ins.setNom(instruments.get(rd.nextInt(instruments.size())));
		System.out.println("Le fabricant d'instrument fournit " + Ins.getNom());
		return Ins;
	}

}
