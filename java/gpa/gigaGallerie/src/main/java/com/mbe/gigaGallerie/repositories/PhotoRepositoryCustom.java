package com.mbe.gigaGallerie.repositories;

import java.io.File;
import java.util.Optional;

import com.mbe.gigaGallerie.metier.Photo;
import com.mbe.gigaGallerie.metier.Tag;

// cette interface contiendra des methodes de mon repository
// non généré par Spring data
public interface PhotoRepositoryCustom {
	boolean saveImageFile(int id, File f);
	Optional<File> getImageFile(int id);
	
	Tag addTagToPhoto(int photoId, int tagId);
	Tag removeTagFromPhoto(int photoId, int tagId);
	Iterable<Photo> findPhotoByTags(Iterable<Integer> tagids);
}
