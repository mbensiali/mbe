package com.mbe.spring_produit.repository;

import java.io.File;
import java.util.List;

import com.mbe.spring_produit.metier.Illustration;

public interface IIllustrationDAO {
	Illustration save(Illustration i, File f);
	List<Illustration> findAll();
	Illustration findByID(int id);
	File getIllustrationFile(Illustration a);	

}

