package model;

import java.util.ArrayList;

public class Game {

//	private ArrayList<Player> order;
	private ArrayList<House> houses;
	private ArrayList<Player> players = new ArrayList<>();
	
	public Game(ArrayList<House> houses, ArrayList<Player> players) {
		super();
//		this.order = order;
		this.houses = houses;
		this.players = players;
	}
	
	public ArrayList<House> getHouses() {
		return houses;
	}
	public void setHouses(ArrayList<House> houses) {
		this.houses = houses;
	}
	public ArrayList<Player> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	
	
}
