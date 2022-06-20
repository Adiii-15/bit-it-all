package com.springboot.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportsPlayerDatabase {
	
	//class to build the sports database
	
	ArrayList<Player> playerList = new ArrayList<>();
	static int counter;
	
	@Autowired
	private SportsRepository data;
	
	// initialize existing players
	public SportsPlayerDatabase() 
	{
		playerList.add(new Player(1, "Vikings", "Dalvin Cook", 33));
		playerList.add(new Player(2, "Bears", "Khalil Mack", 55));
		playerList.add(new Player(3, "Patriots", "Tom Brady", 12));
		counter = 4;
	}
	public List<Player> getPlayerList() 
	{
		return playerList;
	}
	
	public void initialize()
	{
		for(int i = 0; i < playerList.size(); i++)
		{
			data.save(playerList.get(i)); 
		}
	}
	
	// add new player to database
	public void addPlayer(Player toAdd) 
	{
		toAdd.setId(counter);
		playerList.add(toAdd);
		counter++;
		data.save(toAdd);
	}
	
	// delete player from database
	public boolean cutPlayer(String playerName) 
	{
		for(int i = 0; i < playerList.size(); i++) {
			if(playerList.get(i).getName().equals(playerName)) {
				data.delete(playerList.get(i));
				playerList.remove(i);
				return true;
			}
		}
		return false;
	}
	// update player from database
	public boolean updatePlayer(Player player, String name)
	{
		if(player == null || name == null)
		{
			return false;
		}
		for(int i = 0; i < playerList.size(); i++) {
			if(playerList.get(i).getName().equals(player.getName())) {
				playerList.get(i).setName(name);
				data.save(playerList.get(i));
				return true;
			}
		}
		return false;
	}
	
}
