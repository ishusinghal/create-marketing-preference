package com.tg.marketing.createmarketingpreference.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tg.marketing.createmarketingpreference.entity.MarketingPreferenceEntity;

@Repository
public interface PreferenceRepository extends JpaRepository<MarketingPreferenceEntity, Long>{

	
	
}
