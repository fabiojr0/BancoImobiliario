package model;

import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import controller.CtrlStarter;

public class Player {

	private String name;
	private Double money;
	private Locked turnsLocked;
	private ArrayList<Property> properties;
	private HousePanel currentHouse;
	private ImageIcon icon;
	final private Double starterMoney = 2558.00;

	enum Locked {
		NOT_LOCKED, ONE_TURNS, TWO_TURNS, THREE_TURNS, CAN_GO
	}

	public Player(String name) {
		setName(name);

		String imagePath = "/images/" + name + ".png";

		URL imageURL = CtrlStarter.class.getResource(imagePath);

		setIcon(new ImageIcon(imageURL));
		setMoney(starterMoney);
		setTurnsLocked(Locked.NOT_LOCKED);
		setProperties(new ArrayList<Property>());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Locked getTurnsLocked() {
		return turnsLocked;
	}

	public void setTurnsLocked(Locked turnsLocked) {
		this.turnsLocked = turnsLocked;
	}

	public ArrayList<Property> getProperties() {
		return properties;
	}

	public void setProperties(ArrayList<Property> properties) {
		this.properties = properties;
	}

	public HousePanel getCurrentHouse() {
		return currentHouse;
	}

	public void setCurrentHouse(HousePanel currentHouse) {
		this.currentHouse = currentHouse;
	}

}
