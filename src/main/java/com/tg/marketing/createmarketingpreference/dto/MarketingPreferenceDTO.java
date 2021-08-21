package com.tg.marketing.createmarketingpreference.dto;

import lombok.Data;

@Data
public class MarketingPreferenceDTO {
	
	private Long prefId;
	
	private String to;

	private String message;

	private String subject;
	
	private String cif;

	private String marketingPreferenceType;

}
