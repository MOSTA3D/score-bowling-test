package com.bowling.demo.controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bowling.demo.dtos.Player;

@RestController
@RequestMapping("/game")
public class Controller {
	
	@PostMapping(
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE}
			
			)
	public ResponseEntity<Player[]> getPlayersRanks(@RequestBody Map<String, byte[]> playersScores) throws NullPointerException{
		playersScores.forEach((k, v)->{
			if(k.isBlank()) throw new NullPointerException("why to pass an empty key");
		});
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
