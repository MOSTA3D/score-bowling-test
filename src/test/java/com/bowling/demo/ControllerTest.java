package com.bowling.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
//import org.junit.platform.
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.bowling.demo.controllers.BowlingController;
import com.bowling.demo.model.response.Player;
import com.bowling.demo.services.BowlingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Exception.BowlingException;

@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
public class ControllerTest {
	
	@InjectMocks
	private BowlingController bowlingController;
	
	@Mock
	private BowlingService service = new BowlingService();
	
	private List<Player> playerList;
	private Map<String, byte[]> playerMap;
	
	@BeforeEach
	public void setupBforeEach() {
		playerList = new ArrayList<>();
		playerList.add(new Player("mohamed", 23, false));
		playerList.add(new Player("mahmoud", 300, true));
		
		playerMap = new HashMap<>();
		byte[] scores = {1,2};		
		playerMap.put("sheka", scores);
	}
	
	@Test
	public void testControllerNormalBehavior() {
		// given
		when(service.getPlayerRanks(playerMap)).thenReturn(playerList);
		
		// when
		String name = (service).getPlayerRanks(playerMap).get(0).getName();
		
		// then
		assertEquals(name, playerList.get(0).getName());
	}
	
	@Test
	public void testControllerThrowBowlingExceptionWhileProvidingEmptyName() {
		// given
		playerMap.put("", new byte[3]);
		
		// when
		Executable exec = ()->{
			bowlingController.getPlayersRanks(playerMap);
		};
		
		// then
		assertThrows(BowlingException.class, exec);
	}
}
