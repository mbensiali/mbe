package com.mbe.siteApi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mbe.siteApi.metier.Site;

public interface SiteRepository extends CrudRepository<Site, Integer> {

}
