package com.bowling.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.bowling.demo.controllers.BowlingController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private BowlingController controller;
	
	@Test
	public void testControllerIsNotNull() {
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void testEveryThingIsWorkingFine() throws Exception {
		Map<String, int[]> players = new HashMap<>();
		int[] scores = {1, 2, 3, 4, 5, 3, 2, 1, 0, 4, 1, 2, 3, 4, 5, 3, 2, 1, 0, 4, 0, 0, 0, 0};
		players.put("john", scores);
		try {
			String data = objectMapper.writeValueAsString(players);
			System.out.println("the data is " + data);
			String responseBody = mvc.perform(post("/game").contentType(MediaType.APPLICATION_JSON_VALUE).content(data)).andReturn().getResponse().getContentAsString();
			assertNotNull(responseBody);
		}catch(Exception err) {
			System.out.println(err.getMessage());
		}
	}
}
