package com.tg.marketing.createmarketingpreference.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tg.marketing.createmarketingpreference.constants.UpdatePreferenceEnum;
import com.tg.marketing.createmarketingpreference.dao.PreferenceRepository;
import com.tg.marketing.createmarketingpreference.dto.MarketingPreferenceDTO;

@Service
@Qualifier("emailPreferenceServiceImpl2")
public class EmailPreferenceServiceImpl implements Preference{
	
	@Autowired(required=false)
	PreferenceRepository preferenceRepository;
	
	@Autowired(required = false)
	MarketingPreferenceDTO marketingPreferenceDTO;
	
	@Override
	public Long createPreferences(MarketingPreferenceDTO preference) {
		marketingPreferenceDTO = preferenceRepository.save(preference);
		return marketingPreferenceDTO.getCustId();
	}

	@Override
	public UpdatePreferenceEnum updatePreferences(MarketingPreferenceDTO preference) {
		Optional<MarketingPreferenceDTO> prefObj  = preferenceRepository.findById(preference.getCustId());
		
		if(prefObj.isPresent()) {
			marketingPreferenceDTO = prefObj.get();
			marketingPreferenceDTO.setMessage(preference.getMessage());
			marketingPreferenceDTO.setSubject(preference.getSubject());
			marketingPreferenceDTO.setTo(preference.getTo());
			return UpdatePreferenceEnum.SUCCESS;
		}
		return UpdatePreferenceEnum.FAILED;
	}
}
