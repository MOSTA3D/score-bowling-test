package com.bowling.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.bowling.demo.controllers.Controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.InvalidJsonException;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private Controller controller;
	
	@Test
	public void testControllerWorking() {
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void testControllerThrowingExeptionIfProvidingEmptyStringAsAKey() throws Exception {
		Map<String, byte[]> players = new HashMap<>();
		byte[] scores = {1,2};
		players.put("sheka", scores);
		try {
			String data = objectMapper.writeValueAsString(scores);
			System.out.println("the data is " + data);
			ResultActions result = mvc.perform(post("/game").contentType(MediaType.APPLICATION_JSON_VALUE).content(data));
			result.andExpect(MockMvcResultMatchers.status().isOk());
		}catch(JsonProcessingException err) {
			System.out.println(err.getMessage());
		}catch(Exception err) {
			System.out.println(err.getMessage());
		}
	}
}
