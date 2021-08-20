package com.tg.marketing.createmarketingpreference.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tg.marketing.createmarketingpreference.dto.MarketingPreferenceDTO;

@Repository
public interface PreferenceRepository extends CrudRepository<MarketingPreferenceDTO, Long>{

	
	
}
