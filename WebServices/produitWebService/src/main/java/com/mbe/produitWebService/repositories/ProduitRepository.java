package com.mbe.produitWebService.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mbe.produitWebService.metier.Produit;

public interface ProduitRepository extends PagingAndSortingRepository<Produit, Integer> {
	
	Page<Produit> findByTitreContaining(String titre, Pageable p);

}
