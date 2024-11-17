package model;

import java.awt.Color;

public class Company extends Property {

	private Double multiplier;

	public Company(String name, String desc, Color color, Double value, Double multiplier) {
		super(name, desc, color, value);
		setMultiplier(multiplier);
	}

	public Double getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(Double multiplier) {
		this.multiplier = multiplier;
	}

}
