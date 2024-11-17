package model;

import java.awt.Color;
import java.util.ArrayList;

public class House {
	private String name;
	private String desc;
	private Color color;
	private ArrayList<Player> players;

	public House(String name, String desc, Color color) {
		setName(name);
		setColor(color);
		setDesc(desc);
		setPlayers(new ArrayList<Player>());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
