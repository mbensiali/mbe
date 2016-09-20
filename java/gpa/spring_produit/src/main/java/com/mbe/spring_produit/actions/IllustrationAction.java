package com.mbe.spring_produit.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mbe.spring_produit.metier.Illustration;
import com.mbe.spring_produit.repository.IIllustrationDAO;
import com.opensymphony.xwork2.ActionSupport;



public class IllustrationAction extends ActionSupport{
	
	private static Logger log = LogManager.getLogger(IllustrationAction.class); 
	
	
	private IIllustrationDAO illustrationDAO;
	public void setAvatarDAO(IIllustrationDAO illustrationDAO) {
		this.illustrationDAO = illustrationDAO;
	}

	private int illustrationID;
	public int getIllustrationID() {return illustrationID;}
	public void setIllustrationID(int illustrationID) {this.illustrationID = illustrationID;}
	
	private InputStream imageStream;
	public InputStream getImageStream() {
		return imageStream;
	}
	
	private File image;
	private String imageContentType;
	private String imageFileName;
	private String imageDescription;
	
	public void setImage(File image) {this.image = image;}
	public void setImageContentType(String imageContentType) {this.imageContentType = imageContentType;}
	public void setImageFileName(String imageFileName) {this.imageFileName = imageFileName;}
	public String getImageContentType() {return imageContentType;}
	public String getImageFileName() {return imageFileName;}
	public String getImageDescription() {
		return imageDescription;
	}
	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}

	private List<Illustration> illustrations;
	public List<Illustration> getIllustration() {return illustrations;}
	
	public String index() {
		illustrations = illustrationDAO.findAll();
		return SUCCESS;
	}
	
	public String affiche() {
		Illustration a = illustrationDAO.findByID(getIllustrationID());
		File f = illustrationDAO.getIllustrationFile(a);
		setImageContentType(a.getContentType());
		setImageFileName(a.getFileName());
		try {
			imageStream = new FileInputStream(f);
			return SUCCESS;
		} catch (FileNotFoundException e) {log.error(e);}
		return "error";
	}
	public String edit() {
		return SUCCESS;
	}	
	
	public String save() {
		log.info("nom image uploadée = " + imageFileName);
		log.info("content type image uploadée = " + imageContentType);
		log.info("chemin du fichier temporaire uplaodé = " + image.getAbsolutePath()
		+ " " + image.getName());
		illustrationDAO.save(new Illustration(0,imageDescription, imageFileName, imageContentType), image);
		return SUCCESS;
	}
	

}
