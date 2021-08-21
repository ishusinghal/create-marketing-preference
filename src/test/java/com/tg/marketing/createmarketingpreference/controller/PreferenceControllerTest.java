package com.tg.marketing.createmarketingpreference.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.tg.marketing.createmarketingpreference.service.PreferenceServiceImpl;

@SpringBootTest
public class PreferenceControllerTest {
	
	@Mock
	PreferenceController preferenceController;
	
	@InjectMocks
	PreferenceServiceImpl preferenceServiceImpl;

	
	
	@Test
	public void testCreatePreference() {
		
	}
}


