package dev.hust.funnyfarm.entities.creatures;

public class FoodType {

	private String type;
	public FoodType(String type) {
		this.type = type;
	}
	public String getName() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
