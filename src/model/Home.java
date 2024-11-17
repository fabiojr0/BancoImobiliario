package model;

import java.awt.Color;
import java.util.ArrayList;

public class Home extends Property {

	private Double valueToBuild;
	private ArrayList<Double> costToStay;
	private Integer numberOfBuildings;
	private Family family;

	public enum Family {
		Red, Green, Blue, Purple, Orange, Pink, Yellow, Marine, Magenta
	}

	public Home(String name, String desc, Color color, Family Family, Double value,
			Double valueToBuild, ArrayList<Double> costToStay) {
		super(name,desc,  color, value);
		setFamily(Family);
		setValueToBuild(valueToBuild);
		setNumberOfBuildings(0);
		setCostToStay(costToStay);
	}

	public Double getValueToBuild() {
		return valueToBuild;
	}

	public void setValueToBuild(Double valueToBuild) {
		this.valueToBuild = valueToBuild;
	}

	public ArrayList<Double> getCostToStay() {
		return costToStay;
	}

	public void setCostToStay(ArrayList<Double> costToStay) {
		this.costToStay = costToStay;
	}

	public Integer getNumberOfBuildings() {
		return numberOfBuildings;
	}

	public void setNumberOfBuildings(Integer numberOfBuildings) {
		this.numberOfBuildings = numberOfBuildings;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

}
