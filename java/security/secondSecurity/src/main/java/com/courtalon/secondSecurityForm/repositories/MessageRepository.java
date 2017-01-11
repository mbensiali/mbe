package com.mbe.secondSecurity.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mbe.secondSecurity.metier.Message;



public interface MessageRepository 
		extends PagingAndSortingRepository<Message, Integer>, MessageRepositoryCustom {

	Page<Message> findByTitreContaining(String titre, Pageable p);
}
