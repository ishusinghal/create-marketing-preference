package com.tg.marketing.createmarketingpreference.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarketingPreferenceDTO {
	
	private Long prefId;
	
	private String to;

	private String message;

	private String subject;
	
	private String cif;

	private String marketingPreferenceType;

}
