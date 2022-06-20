package com.springboot.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestMappingExample1 {
	
	// Class replicates a sports database where users can view and update
	// players to the sports database
	
	@Autowired
	private SportsPlayerDatabase players;
	
	//example of a get request to view the list of players on the database
	@RequestMapping("/playerList")
	public List<Player> playerList() {
		players.initialize();
		return players.getPlayerList();
	}
	
	//example of a post request to add a player to the database
	@PostMapping("/addPlayer")
	public void addPlayerToDatabase(@RequestBody Player p) {
		players.addPlayer(p);
		System.out.println("Updated player database");
	}
	
	//example of a delete request to delete a player from database
	@DeleteMapping("/deletePlayer")
	public void deletePlayer(@RequestParam(value = "playerName") String p) {
		System.out.println(p);
		if(p == null) 
		{
			System.out.println("Unable to delete player");
			return;
		}
		if(players.cutPlayer(p))
		{	
		System.out.println("Deleted Player: " + p + " from database");
		}
		else
		{
			System.out.println("Unable to process request to delete player (" + p + ") due to name not found in records.");
		}
	}
	
	//example of a put request to update player name
	@PutMapping("/updatePlayerName")
	public void updatePlayer(@RequestParam(value = "playerName") String p, @RequestBody Player player) 
	{
		if(players.updatePlayer(player, p))
		{
			System.out.println("Player name switched to (" + p + ").");
		}
		else
		{
			System.out.println("Unable to update player due to player not found in database");
		}
	}

	
	

}
