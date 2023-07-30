package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	private int truckID;
	private String name;
	private String foodType;
	private int numericRating;

	@Override
	public String toString() {
		return "FoodTruck [truckID=" + truckID + ", name=" + name + ", foodType=" + foodType + ", numericRating="
				+ numericRating + "]";
	}

	private static int nextTruckID = 0;

	public int getTruckID() {
		return truckID;
	}

	public FoodTruck() {
		truckID = nextTruckID;
		nextTruckID++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getNumericRating() {
		return numericRating;
	}

	public void setNumericRating(int numericRating) {
		this.numericRating = numericRating;
	}

}
