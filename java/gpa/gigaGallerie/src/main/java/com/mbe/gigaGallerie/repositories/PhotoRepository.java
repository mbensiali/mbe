package com.mbe.gigaGallerie.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mbe.gigaGallerie.metier.Photo;

public interface PhotoRepository 
		extends PagingAndSortingRepository<Photo, Integer>, PhotoRepositoryCustom
{
	
}
