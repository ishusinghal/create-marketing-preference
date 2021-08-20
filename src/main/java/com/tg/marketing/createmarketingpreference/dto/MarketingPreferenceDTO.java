package com.tg.marketing.createmarketingpreference.dto;

import java.io.Serializable;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Entity
@Data
public class MarketingPreferenceDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long custId;
	
	private String to;

	private String message;

	private String subject;
	
	

}
