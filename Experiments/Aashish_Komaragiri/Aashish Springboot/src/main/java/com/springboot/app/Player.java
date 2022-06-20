package com.springboot.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Class to setup a sports player information

@Entity
@Table(name="playerDataBase")
public class Player {
	
	// primary key id 
	@Id
    @Column(name="id")
    private int id;
	
	// Player team name 
    @Column(name="team")
	private String teamName;
    
    // Player name
    @Column(name="name")
	private String playerName;
    
    //Player jersey number
    @Column(name="number")
	private int playerNumber;
    
    public Player() {}

	public Player(Integer id, String team, String name, int number) 
	{
		this.id = id;
		teamName = team;
		playerName = name;
		playerNumber = number;
	}
	
	public void setId(Integer sportId)
	{
		id = sportId;
	}
	
	public int getId()
	{
		return id;
	}
	// set team name
	public void setTeamName(String team)
	{
		teamName = team;
	}
	
	//return team name
	public String getTeamName()
	{
		return teamName;
	}
	
	// set player name
	public void setName(String name)
	{
		playerName = name;
	}
	
	// return player name
	public String getName()
	{
		return playerName;
	}
	
	// set player number
	public void setPlayerNumber(int number)
	{
		playerNumber = number;
	}
	
	// return player number
	public int getPlayerNumber()
	{
		return playerNumber;
	}
	
	
	
	

}
