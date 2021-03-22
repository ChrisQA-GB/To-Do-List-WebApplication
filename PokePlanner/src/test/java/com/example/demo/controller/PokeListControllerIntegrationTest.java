package com.example.demo.controller;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.DTO.PokeListDTO;
import com.example.demo.data.model.PokeList;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // configures the MockMvc object (used to send requests to our API)
@Sql(scripts = { "classpath:test-schema.sql", "classpath:test-data.sql" },
	 executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class PokeListControllerIntegrationTest {

	@Autowired
	private MockMvc mvc; // Adding this to ensure I can seen a http request to my web application.

	@Autowired
	private ObjectMapper objectMapper;
	
	private PokeList validPokeList = new PokeList(1, "This is a PokeStringTest", null);
	private PokeListDTO pokeListDTO = new  PokeListDTO(1, "This is a PokeStringTest", null);
	
	private List<PokeList> validPokeLists = List.of(validPokeList);
	private List<PokeListDTO> validPokeListDTO = List.of(pokeListDTO);
	
	@Disabled
	@Test
	public void createPokeListTest() throws Exception {
		PokeList pokeListToSave = new PokeList("This is a PokeStringTest");
		PokeListDTO expectedPokeListDTO = new PokeListDTO("This is a PokeStringTest");
		
		// Created a mock request to send a POST request to /duck
		MockHttpServletRequestBuilder mockRequest = 
				MockMvcRequestBuilders.request(HttpMethod.POST, "/pokelist");
		
		// Specify the data to be sent & the type of the data
		mockRequest.contentType(MediaType.APPLICATION_JSON); // Mime-Type
		mockRequest.content(objectMapper.writeValueAsString(pokeListToSave)); // sending Duck in
		
		// Specify what data type we expect in response
		mockRequest.accept(MediaType.APPLICATION_JSON);
		
		// Setup ResultMatchers
		// - these are used to compare the result of the request with our own specified values
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isCreated();
		
		// Expecting the json returned in the response body to be equal to the json string specified
		ResultMatcher contentMatcher = MockMvcResultMatchers.content()
				.json(objectMapper.writeValueAsString(expectedPokeListDTO)); // expecting DuckDTO back
		
		ResultMatcher headerMatcher = MockMvcResultMatchers.header().string("Location", "2");
		
		// Send the request and assert the expected results from the result matchers
		mvc.perform(mockRequest)
		   .andExpect(statusMatcher)
		   .andExpect(contentMatcher)
		   .andExpect(headerMatcher);
	}
	@Disabled
	@Test
	public void getAllPokeListTest() throws Exception {
		MockHttpServletRequestBuilder mockRequest = 
				MockMvcRequestBuilders.request(HttpMethod.GET, "/pokelist");
		mockRequest.accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content()
				.json(objectMapper.writeValueAsString(validPokeListDTO));
				
		mvc.perform(mockRequest)
		   .andExpect(statusMatcher)
		   .andExpect(contentMatcher);
	}
	
	@Disabled
	@Test
	public void getDuckByIdTest() throws Exception {
		MockHttpServletRequestBuilder mockRequest = 
				MockMvcRequestBuilders.request(HttpMethod.GET, "/pokeListId/1");
		mockRequest.accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content()
				.json(objectMapper.writeValueAsString(pokeListDTO));
				
		mvc.perform(mockRequest)
		   .andExpect(statusMatcher)
		   .andExpect(contentMatcher);
	}
	
	@Disabled
	@Test
	public void getDuckByNameTest() throws Exception {
		MockHttpServletRequestBuilder mockRequest = 
				MockMvcRequestBuilders.request(HttpMethod.GET, "/pokelist/1");
		mockRequest.accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content()
				.json(objectMapper.writeValueAsString(pokeListDTO));
				
		mvc.perform(mockRequest)
		   .andExpect(statusMatcher)
		   .andExpect(contentMatcher);
	}
	
	@Disabled
	@Test
	public void updatePokeListTest() throws Exception {
		PokeListDTO expectedPokeListDTO = new PokeListDTO("This is a PokeStringTest");
		
		MockHttpServletRequestBuilder mockRequest = 
				MockMvcRequestBuilders.request(HttpMethod.PUT, "/pokeListId/1");
		
		mockRequest.contentType(MediaType.APPLICATION_JSON); // Mime-Type
		mockRequest.content(objectMapper.writeValueAsString(pokeListDTO)); // sending Duck in
		
		// Specify what data type we expect in response
		mockRequest.accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
		
		ResultMatcher contentMatcher = MockMvcResultMatchers.content()
				.json(objectMapper.writeValueAsString(expectedPokeListDTO)); // expecting DuckDTO back
				
		mvc.perform(mockRequest)
		   .andExpect(statusMatcher)
		   .andExpect(contentMatcher);
	}
	@Disabled
	@Test
	public void deletePokeListTest() throws Exception {
		MockHttpServletRequestBuilder mockRequest = 
				MockMvcRequestBuilders.request(HttpMethod.DELETE, "/pokeListId/1");
		mockRequest.accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content().string("true");
				
		mvc.perform(mockRequest)
		   .andExpect(statusMatcher)
		   .andExpect(contentMatcher);
	}
}
