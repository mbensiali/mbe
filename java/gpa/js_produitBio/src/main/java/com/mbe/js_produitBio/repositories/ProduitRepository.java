package com.mbe.js_produitBio.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mbe.js_produitBio.metier.Produit;

public interface ProduitRepository extends PagingAndSortingRepository<Produit, Integer> {
	Iterable<Produit> findByNomContaining(String name);
	Iterable<Produit> findByNomIgnoreCaseContaining(String name);
//	Iterable<Produit> findByNomAndByStock(String name, int stock);

}
