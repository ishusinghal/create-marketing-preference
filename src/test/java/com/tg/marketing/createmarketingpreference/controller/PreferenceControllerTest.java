package com.tg.marketing.createmarketingpreference.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.tg.marketing.createmarketingpreference.dto.MarketingPreferenceDTO;
import com.tg.marketing.createmarketingpreference.repo.PreferenceRepository;
import com.tg.marketing.createmarketingpreference.service.PreferenceServiceImpl;


@RunWith(SpringRunner.class)
@WebMvcTest(value = PreferenceController.class)
@WithMockUser
public class PreferenceControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PreferenceServiceImpl preferenceServiceImpl;

	@Autowired
	private TestEntityManager entityManagerFactory;

	@Autowired
	private PreferenceRepository preferenceRepository;

	MarketingPreferenceDTO mockMarketingPreference = new MarketingPreferenceDTO(1L, "abcd@gmail.com", "danny Test",
			"Marketing Campaign", "123", "EMAIL");
	String exampleJson= "{ \"to\": \"abcd@gmail.com\", \"message\": \"Hi I amasdsa John\", \"subject\": \"Marketing Campaign\", \"marketingPreferenceType\": \"EMAIL\" }";
	
	
	@Test
	public void postMarketingPreferences() throws Exception {

		Mockito.when(
				preferenceServiceImpl.createPreferences(Mockito.any(MarketingPreferenceDTO.class)))
		.thenReturn(1L);

		// Send course as body to /students/Student1/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/customers/123/preferences")
				.accept(MediaType.APPLICATION_JSON).content(exampleJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

//		assertEquals("http://localhost/students/Student1/courses/1",
//				response.getHeader(HttpHeaders.LOCATION));

	}

}
