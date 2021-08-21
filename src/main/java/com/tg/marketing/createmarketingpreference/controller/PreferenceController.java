package com.tg.marketing.createmarketingpreference.controller;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tg.marketing.createmarketingpreference.constants.UpdatePreferenceEnum;
import com.tg.marketing.createmarketingpreference.dto.MarketingPreferenceDTO;
import com.tg.marketing.createmarketingpreference.factory.PreferenceFactory;
import com.tg.marketing.createmarketingpreference.request.MarketingPreference;
import com.tg.marketing.createmarketingpreference.service.PreferenceServiceImpl;

@RestController
@RequestMapping(value = "/customers/{cif}/preferences", produces = { MediaType.APPLICATION_JSON_VALUE })
public class PreferenceController {

	@Autowired
	PreferenceServiceImpl preferenceServiceImpl;

	@Autowired
	PreferenceFactory preferenceFactory;

	@PostMapping()
	public ResponseEntity<?> postMarketingPreferences(@Validated @RequestBody MarketingPreference marketingPreference,
			@PathVariable("cif") String cif) {

		if (Objects.isNull(cif)) {
			return new ResponseEntity<String>("Customer Id should be given", HttpStatus.BAD_REQUEST);
		}

		MarketingPreferenceDTO marketingPreferenceDTO = new MarketingPreferenceDTO();
		BeanUtils.copyProperties(marketingPreference, marketingPreferenceDTO);
		Long response = null;
		
		marketingPreferenceDTO.setCif(cif);
		if(Objects.isNull(marketingPreference.getMarketingPreferenceType()) || marketingPreference.getMarketingPreferenceType().isBlank()) {
			return new ResponseEntity<String>("Preference Type Not Found", HttpStatus.NOT_FOUND);
		}
		
		preferenceServiceImpl.createPreferences(marketingPreferenceDTO);

		marketingPreferenceDTO.setCif(cif);
		return new ResponseEntity<Long>(response, HttpStatus.CREATED);
	}

	@PutMapping("/{prefId}")
	public ResponseEntity<?> updateMarketingPreferences(@Validated @RequestBody MarketingPreference marketingPreference,
			@PathVariable("cif") String cif, @PathVariable("prefId") String prefId) {

		if (Objects.isNull(cif)) {
			return new ResponseEntity<String>("Customer Id should be given", HttpStatus.BAD_REQUEST);
		}

		MarketingPreferenceDTO marketingPreferenceDTO = new MarketingPreferenceDTO();
		BeanUtils.copyProperties(marketingPreference, marketingPreferenceDTO);
		marketingPreferenceDTO.setCif(cif);
		marketingPreferenceDTO.setPrefId(Long.valueOf(prefId));
		
		UpdatePreferenceEnum result = null;
		preferenceServiceImpl.updatePreferences(marketingPreferenceDTO);

		marketingPreferenceDTO.setCif(cif);
		return new ResponseEntity<UpdatePreferenceEnum>(result, HttpStatus.OK);
	}
}