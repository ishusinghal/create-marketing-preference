package com.tg.marketing.createmarketingpreference.controller;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tg.marketing.createmarketingpreference.constants.PreferenceTypeEnum;
import com.tg.marketing.createmarketingpreference.dto.MarketingPreferenceDTO;
import com.tg.marketing.createmarketingpreference.request.MarketingPreference;
import com.tg.marketing.createmarketingpreference.service.EmailPreferenceServiceImpl;
import com.tg.marketing.createmarketingpreference.service.PostPreferenceServiceImpl;
import com.tg.marketing.createmarketingpreference.service.SmsPreferenceServiceImpl;

@RestController
@RequestMapping(value = "customers/{cif}/preferences", produces = { MediaType.APPLICATION_JSON_VALUE })
public class EmailPreferenceController {

	@Autowired
	@Qualifier("emailPreferenceServiceImpl")
	EmailPreferenceServiceImpl emailPreferenceServiceImpl;

	@Autowired
	@Qualifier("smsPreferenceServiceImpl")
	SmsPreferenceServiceImpl smsPreferenceServiceImpl;
	
	@Autowired
	@Qualifier("postPreferenceServiceImpl")
	PostPreferenceServiceImpl postPreferenceServiceImpl;
	
//	@Autowired
//	PreferenceFactory preferenceFactory;
	
//	@Autowired(required = false)
//	Preference preference;

	@PostMapping()
	public ResponseEntity<?> postMarketingPreferences(@Validated @RequestBody MarketingPreference marketingPreference,
			@PathVariable("cif") String cif) {

		if (Objects.isNull(cif)) {
			return new ResponseEntity<String>("Customer Id should be given", HttpStatus.BAD_REQUEST);
		}

		MarketingPreferenceDTO marketingPreferenceDTO = new MarketingPreferenceDTO();
		BeanUtils.copyProperties(marketingPreference, marketingPreferenceDTO);
		Long response=null;
		if (marketingPreference.getMarketingPreferenceType().equalsIgnoreCase(PreferenceTypeEnum.EMAIL.name())) {
			response = emailPreferenceServiceImpl.createPreferences(marketingPreferenceDTO);
		} else if (marketingPreference.getMarketingPreferenceType().equalsIgnoreCase(PreferenceTypeEnum.SMS.name())) {
//			response = smsPreferenceServiceImpl.createPreferences(marketingPreferenceDTO);
		} else if (marketingPreference.getMarketingPreferenceType().equalsIgnoreCase(PreferenceTypeEnum.POST.name())) {
//			response = postPreferenceServiceImpl.createPreferences(marketingPreferenceDTO);
		}
		
		marketingPreferenceDTO.setCustId(Long.valueOf(cif));
		return new ResponseEntity<Long>(response, HttpStatus.CREATED);
	}

//	@PutMapping()
//	public ResponseEntity<?> updateMarketingPreferences(@Validated @RequestBody MarketingPreference marketingPreference,
//			@PathVariable("cif") String cif) {
//
//		if (Objects.isNull(cif)) {
//			return new ResponseEntity<String>("Customer Id should be given", HttpStatus.BAD_REQUEST);
//		}
//
//		MarketingPreferenceDTO marketingPreferenceDTO = new MarketingPreferenceDTO();
//		BeanUtils.copyProperties(marketingPreference, marketingPreferenceDTO);
//		getPreferenceType(marketingPreference);
//		marketingPreferenceDTO.setCustId(Long.valueOf(cif));
//		
//		return new ResponseEntity<UpdatePreferenceEnum>(preference.updatePreferences(marketingPreferenceDTO), HttpStatus.OK);
//	}
//
//	private void getPreferenceType(MarketingPreference marketingPreference) {
//		if (marketingPreference.getMarketingPreferenceType().equalsIgnoreCase(PreferenceTypeEnum.EMAIL.name())) {
//			preference = emailPreferenceServiceImpl;
//		} else if (marketingPreference.getMarketingPreferenceType().equalsIgnoreCase(PreferenceTypeEnum.SMS.name())) {
//			preference = smsPreferenceServiceImpl;
//		} else if (marketingPreference.getMarketingPreferenceType().equalsIgnoreCase(PreferenceTypeEnum.POST.name())) {
//			preference = postPreferenceServiceImpl;
//		}
//	}

}