package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {
	private FoodTruck[] fleetOfFoodtrucks = new FoodTruck[5];
	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		FoodTruckApp app = new FoodTruckApp();
		app.userInput();
		app.menuUserSelection();
	}

	int i;

	public void userInput() {
		for (i = 0; i < 5; i++) {
			System.out.print("Enter the name of the food truck or enter quit when done: ");
			String truckName = kb.nextLine();
			if (truckName.equals("quit")) {
				break;
			} else {
				FoodTruck foodTruck = new FoodTruck();
				fleetOfFoodtrucks[i] = foodTruck;
				foodTruck.setName(truckName);
				System.out.print("Enter the type of food: ");
				String foodType = kb.nextLine();
				foodTruck.setFoodType(foodType);
				System.out.print("On a scale of 1 through 5, how would you rate your experience?: ");
				int numericRating = kb.nextInt();
				kb.nextLine();
				foodTruck.setNumericRating(numericRating);
			}
		}
	}

	public void menuUserSelection() {
		boolean keepGoing = true;
		while (keepGoing) {
			printMenu();
			System.out.println("Please make a selection");
			int numChoice = kb.nextInt();

			switch (numChoice) {
			case 1:
				displayTrucks();
				break;
			case 2:
				displayAverageRating();
				break;
			case 3:
				displayHighestRated();
				break;
			case 4:
				keepGoing = false;
				System.out.println("Have a great day!");
				break;
			default:
				System.out.println("Invalid selection");

			}
		}
	}

	public static void printMenu() {
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("============= Menu =============");
		System.out.println("|                              |");
		System.out.println("|1. Display Foodtrucks         |");
		System.out.println("|2. Display Average Rating     |");
		System.out.println("|3. Display Highest Rated Truck|");
		System.out.println("|4. Quit                       |");
		System.out.println("|                              |");
		System.out.println("================================");
	}

	public void displayTrucks() {
		for (int arrayLocation = 0; arrayLocation < i; arrayLocation++) {
			System.out.println(fleetOfFoodtrucks[arrayLocation]);
		}
	}

	public void displayAverageRating() {
		int average = 0;
		int sum = 0;
		for (int arrayLocation = 0; arrayLocation < i; arrayLocation++) {

			sum += fleetOfFoodtrucks[arrayLocation].getNumericRating();
		}
		average = sum / i;
		System.out.println("The average rating is " + average);
	}

	public void displayHighestRated() {
		int rating = 0;
		int highestRated = 0;
		int highestRatedArrayLocation = 0;
		for (int arrayLocation = 0; arrayLocation < i; arrayLocation++) {
			rating = fleetOfFoodtrucks[arrayLocation].getNumericRating();
			if (rating > highestRated) {
				highestRatedArrayLocation = arrayLocation;
			}
		}
		System.out.println("The highest rated food truck is " + fleetOfFoodtrucks[highestRatedArrayLocation]);
	}
}
