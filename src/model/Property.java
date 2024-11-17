package model;

import java.awt.Color;

public class Property extends House {

	private Double value;
	private Player host;

	public Property(String name, String desc, Color color, Double value) {
		super(name,desc ,color);
		setHost(null);
		setValue(value);
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Player getHost() {
		return host;
	}

	public void setHost(Player host) {
		this.host = host;
	}

}
