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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.DTO.PokeTaskDTO;
import com.example.demo.data.model.PokeTasks;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts= {"classpath:test-schema.sql", "classpath: test-data.sql"})
public class PokeTasksControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc; // Adding this to ensure I can seen a http request to my web application.
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private PokeTasks pokeTasks = new PokeTasks(1, null, "PokeTask", "PokeDescription",
			 2, "Tuesday", true);
	private PokeTaskDTO pokeTaskDTO = new  PokeTaskDTO(1, "PokeTask", "PokeDescription",
			 2, "Tuesday", true);
	
	private List<PokeTasks> validPokeTasks = List.of(pokeTasks);
	private List<PokeTaskDTO> validPokeListDTO= List.of(pokeTaskDTO);
	
	@Disabled
	@Test
	public void createPokeListTest() throws Exception {
		
		
		PokeTasks pokeTasksToSave = new PokeTasks(2, null, "PokeTask1", "PokeDescription1",
				 3, "Tuesday1", false);
		PokeTaskDTO expectedPokeTaskDTO = new PokeTaskDTO(1, "PokeTask", "PokeDescription",
				 2, "Tuesday", true);
		
		MockHttpServletRequestBuilder mockRequest = 
				MockMvcRequestBuilders.request(HttpMethod.POST, "/poketask");
		
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(objectMapper.writeValueAsString(pokeTasksToSave)); 
		mockRequest.accept(MediaType.APPLICATION_JSON);
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isCreated();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content()
				.json(objectMapper.writeValueAsString(expectedPokeTaskDTO)); 
		
		ResultMatcher headerMatcher = MockMvcResultMatchers.header().string("Location", "2");
		
	
		mvc.perform(mockRequest)
		   .andExpect(statusMatcher)
		   .andExpect(contentMatcher)
		   .andExpect(headerMatcher);
	}
	
	@Disabled
	@Test
	public void getAllPokeListTest() throws Exception {
		MockHttpServletRequestBuilder mockRequest = 
				MockMvcRequestBuilders.request(HttpMethod.GET, "/poketask");
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
	public void getTaskByIdTest() throws Exception {
		MockHttpServletRequestBuilder mockRequest = 
				MockMvcRequestBuilders.request(HttpMethod.GET, "/taskId/1");
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
	public void getPokeTaskByNameTest() throws Exception {
		MockHttpServletRequestBuilder mockRequest = 
				MockMvcRequestBuilders.request(HttpMethod.GET, "/poketask/1");
		mockRequest.accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content()
				.json(objectMapper.writeValueAsString(validPokeTasks));
				
		mvc.perform(mockRequest)
		   .andExpect(statusMatcher)
		   .andExpect(contentMatcher);
	}
	
	@Disabled
	@Test
	public void updatePokeTaskTest() throws Exception {
		PokeTaskDTO expectedPokeList = new PokeTaskDTO(1, "PokeTask", "PokeDescription",
				 2, "Tuesday", true);
		
		MockHttpServletRequestBuilder mockRequest = 
				MockMvcRequestBuilders.request(HttpMethod.PUT, "/pokeTaskId/1");
		
		mockRequest.contentType(MediaType.APPLICATION_JSON); // Mime-Type
		mockRequest.content(objectMapper.writeValueAsString(pokeTaskDTO));
		
		
		mockRequest.accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
		
		ResultMatcher contentMatcher = MockMvcResultMatchers.content()
				.json(objectMapper.writeValueAsString(pokeTaskDTO)); 
				
		mvc.perform(mockRequest)
		   .andExpect(statusMatcher)
		   .andExpect(contentMatcher);
	}
	
	
	@Disabled
	@Test
	public void deletePokeTaskTest() throws Exception {
		MockHttpServletRequestBuilder mockRequest = 
				MockMvcRequestBuilders.request(HttpMethod.DELETE, "/pokeTaskID/1");
		mockRequest.accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content().string("true");
				
		mvc.perform(mockRequest)
		   .andExpect(statusMatcher)
		   .andExpect(contentMatcher);
	}
}

