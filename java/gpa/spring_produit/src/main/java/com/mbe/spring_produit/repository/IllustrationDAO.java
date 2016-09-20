package com.mbe.spring_produit.repository;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.mbe.spring_produit.metier.Illustration;
import com.mbe.spring_produit.utils.FileStorageManager;

public class IllustrationDAO implements IIllustrationDAO {

	@PersistenceContext
	private EntityManager em;
	public EntityManager getEm() {return em;}
	public void setEm(EntityManager em) {this.em = em;}
	
	private FileStorageManager fileStorageManager;
	public FileStorageManager getFileStorageManager() {return fileStorageManager;}
	public void setFileStorageManager(FileStorageManager fileStorageManager) {this.fileStorageManager = fileStorageManager;}
	@Override
	@Transactional
	public Illustration save(Illustration a, File f) {
		Illustration existing = em.find(Illustration.class, a.getId());
		if (existing == null) {
			em.persist(a);
			// stockage effectif du fichier
			fileStorageManager.saveFile("Avatar", a.getId(), f);
			return a;
		}
		else {
			existing = em.merge(a);
			fileStorageManager.saveFile("Avatar", existing.getId(), f);
			return existing;
		}

	}
	
	@Override
	@Transactional
	public Illustration findByID(int id) {
		return em.find(Illustration.class, id);
	}
	@Override
	public File getIllustrationFile(Illustration a) {
		Optional<File> f = fileStorageManager.getFile("Avatar", a.getId());
		if( f.isPresent())
			return f.get();
		else
			return null;
	}
	
	@Override
	@Transactional
	public List<Illustration> findAll() {
		return em.createQuery("from Avatar", Illustration.class).getResultList();
	}

	
	

}
