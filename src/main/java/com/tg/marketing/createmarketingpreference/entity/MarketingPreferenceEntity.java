package com.tg.marketing.createmarketingpreference.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.GenerationType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TBL_MARKETINGPREFERENCE")
@Getter
@Setter
public class MarketingPreferenceEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long prefId;

	@Column(name = "to")
	private String to;

	@Column(name = "message")
	private String message;

	@Column(name = "subject")
	private String subject;

	@Column(name = "cif")
	private String cif;
	
	@Column(name = "prefType")
	private String marketingPreferenceType;

	@Override
	public String toString() {
		return "MarketingPreferenceEntity [prefId=" + prefId + ", to=" + to + ", message=" + message + ", subject="
				+ subject + ", cif=" + cif + ", marketingPreferenceType=" + marketingPreferenceType + "]";
	}

}
