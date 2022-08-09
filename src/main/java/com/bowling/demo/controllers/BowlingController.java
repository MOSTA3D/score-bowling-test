package com.bowling.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bowling.demo.model.response.Player;
import com.bowling.demo.services.BowlingService;

import Exception.BowlingException;

@RestController
@RequestMapping("/game")
public class BowlingController {
	@Autowired
	private BowlingService service;
	
	@PostMapping(
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE}
			)
	public ResponseEntity<List<Player>> getPlayersRanks(@RequestBody Map<String, byte[]> playersScores) throws Exception{
		// throw null pointer exception if key is empty
		playersScores.forEach((k, v)->{
			if(k.isBlank()){
				// your exception type
				throw new BowlingException("empty player name");
			}
			
			if(v.length > 22) {
				// your exception type
				throw new BowlingException("lskdjf");
			}
		});
		
		List<Player> players = service.getPlayerRanks(playersScores);
		
		return new ResponseEntity<>(players, HttpStatus.OK);
	}
}
