package com.tg.marketing.createmarketingpreference.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.marketing.createmarketingpreference.constants.UpdatePreferenceEnum;
import com.tg.marketing.createmarketingpreference.dto.MarketingPreferenceDTO;
import com.tg.marketing.createmarketingpreference.entity.MarketingPreferenceEntity;
import com.tg.marketing.createmarketingpreference.repo.PreferenceRepository;

@Service
public class PreferenceServiceImpl implements Preference{
	
	@Autowired
	PreferenceRepository repository;
	
	@Autowired(required = false)
	MarketingPreferenceEntity entity;
	
	@Override
	public Long createPreferences(MarketingPreferenceDTO preference) {
		entity= new MarketingPreferenceEntity();
		BeanUtils.copyProperties(preference, entity);
		entity = repository.save(entity);
		return entity.getPrefId();
	}

	@Override
	public UpdatePreferenceEnum updatePreferences(MarketingPreferenceDTO preference) {
		entity= new MarketingPreferenceEntity();
		Optional<MarketingPreferenceEntity> prefObj  = repository.findById(Long.valueOf(preference.getPrefId()));
		
		if(prefObj.isPresent()) {
			entity = prefObj.get();
			entity.setMessage(preference.getMessage());
			entity.setSubject(preference.getSubject());
			entity.setTo(preference.getTo());
			
			repository.save(entity);
			return UpdatePreferenceEnum.SUCCESS;
		}
		return UpdatePreferenceEnum.FAILED;
	}

}