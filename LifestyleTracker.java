/**
This is a Java file that contains the public and private methods to keep track of food added, food eaten, activity added, activity performed, and report. Additionally, it contains helper methods to find the name and index of the food or activity. Add-Ons 1 (Edit) and 2 (Delete) were implemented with their own helper methods (findFoodEatenName, findFoodEatenIndex, findActivityPerformedName, findActivityPerformedIndex) and public methods (recordsSoFar(), edit, and delete). 
@author Patricia Angeline G. Tan (226189)
@version December 5, 2022
**/ 

/*
I have not discussed the Java language code in my program 
with anyone other than my instructor or the teaching assistants 
assigned to this course.

I have not used Java language code obtained from another student, 
or any other unauthorized source, either modified or unmodified.

If any Java language code or documentation used in my program 
was obtained from another source, such as a textbook or website, 
that has been clearly noted with a proper citation in the comments 
of my program.
*/

import java.util.*;
import java.lang.Math.*;

public class LifestyleTracker {
    private double caloriesConsumed; 
	private double caloriesBurned; 
	private double netCalories; 
	
	private ArrayList<Food> foodAdded;
	private ArrayList<String> foodEatenName;
	private ArrayList<String> foodEatenServings; 
	private ArrayList<String> foodEatenKcal; 

	private ArrayList<Activity> activityAdded;
	private ArrayList<String> activityPerformedName;
	private ArrayList<String> activityPerformedServings;
	private ArrayList<String> activityPerformedKcal;
	
	private double kcal; 
	private double weekCalculation;
	private double monthCalculation;
	private double threeMonthCalculation;
	private double sixMonthCalculation;
    
    public LifestyleTracker() {
        caloriesConsumed = 0; 
		caloriesBurned = 0;
		netCalories = 0;
		
		foodAdded = new ArrayList<Food>();
		foodEatenName = new ArrayList<String>();
		foodEatenServings = new ArrayList<String>();
		foodEatenKcal = new ArrayList<String>();
		
		activityAdded = new ArrayList<Activity>();
		activityPerformedName = new ArrayList<String>();
		activityPerformedServings = new ArrayList<String>();
		activityPerformedKcal = new ArrayList<String>();
		
		kcal = 0.00012959782;
		weekCalculation = 0;
		monthCalculation = 0;
		threeMonthCalculation = 0;
		sixMonthCalculation = 0;
    }
    
// START OF HELPER METHODS --------------
    
// Helper Methods for Food
        
        // Method #1: Returns true if the inputted food name is in the ArrayList foodAdded, false otherwise
            // @param name: the name of food inputted 
    private boolean findFoodName (String name) {
		for(int i = 0; i < foodAdded.size(); i++) {
			String temporaryFood = foodAdded.get(i).getFoodName();
			if(temporaryFood.equals(name)) {
				return true; 
			} 
		}
		return false; 
	}
	
    // Method #2: Returns i or the index of the food if the inputted food name is in the ArrayList foodAdded, -1 otherwise 
        // @param name: the name of the food inputted 
	private int findFoodIndex(String name) {
		for(int i = 0; i < foodAdded.size(); i++) {
			String foodName = foodAdded.get(i).getFoodName();
			if(name.equals(foodName)) {
				return i;
			}
		}
		return -1; 
	}
	
// Helper Methods for Activity
        
        // Method #1: Returns true if the inputted activity name is in the ArrayList activityAdded, false otherwise
            // @param name: the name of activity inputted 
	private boolean findActivityName (String name) {
		for(int i = 0; i < activityAdded.size(); i++) {
			String temporaryActivity = activityAdded.get(i).getActivityName();
			if(temporaryActivity.equals(name)) {
				return true; 
			} 
		}
		return false; 
	}
	
    // Method #2: Returns i or the index of the activity if the inputted activity name is in the ArrayList activityAdded, -1 otherwise 
        // @param name: the name of the activity inputted
	private int findActivityIndex(String name) {
		for(int i = 0; i < activityAdded.size(); i++) {
			String accountName = activityAdded.get(i).getActivityName();
			if(name.equals(accountName)) {
				return i;
			}
		}
		return -1; 
	}
	
// Helper Methods for Add-ons 1 and 2 
    
        // Method #1: Returns true if the inputted food name is in the ArrayList foodEatenName, false otherwise
            // @param name: the name of the food inputted
    private boolean findFoodEatenName(String name) {
		for(int i = 0; i < foodEatenName.size(); i++) {
			String temporaryFood = foodEatenName.get(i);
			if(temporaryFood.equals(name)) {
				return true; 
			} 
		}
		return false; 
	} 
	
    //Method #2: Returns true if the inputted number is in the ArrayList findFoodEatenIndex, false otherwise 
        // @param num: the inputted index the user wishes to edit/delete
	private boolean findFoodEatenIndex(int num) {
		for(int i = 0; i < foodEatenName.size(); i++) {
			if(num == i) {
				return true;
			}
		}
		return false;
	} 
	
    // Method #3: Returns true if the inputted activity name is in the ArrayList findActivityPerformedName, false otherwise 
        // @param name: the name of the food inputted 
	private boolean findActivityPerformedName(String name) {
		for(int i = 0; i < activityPerformedName.size(); i++) {
			String temporaryActivity = activityPerformedName.get(i);
			if(temporaryActivity.equals(name)) {
				return true; 
			} 
		}
		return false; 
	}
	
    //Method #4: Returns true if the inputted number is in the ArrayList findActivityPerformedIndex, false otherwise 
        // @param num: the inputted index the user wishes to edit/delete
	private boolean findActivityPerformedIndex(int num) {
		for(int i = 0; i < activityPerformedName.size(); i++) {
			if(num == i) {
				return true;
			}
		}
		return false;
	}

// END OF HELPER METHODS --------------
    
    // @param n: the name of the food
    // @param c: the calorie value of the food 
    
	public String addFood(String n, double c) { 
        Food currentFood = new Food(n, c); // Create a new instance of Food 
		boolean findFood = findFoodName(n); 
		
		if(findFood == true) { // If n is already found in the ArrayList
			int findIndex = findFoodIndex(n); 
            foodAdded.get(findIndex).updateCalories(c);
			System.out.printf("Updated Food %s with %.2f kcal \n", n, currentFood.getFoodCalories());
		
		} else if(findFood == false) { // If n is not found in the ArrayList 
			foodAdded.add(new Food(n, c));
			System.out.printf("Added Food %s with %.2f kcal \n", n, c);
		} 
			return null; 
	}
	
    // @param n: the name of the activity
    // @param c: the calorie value of the food 
    
	public String addActivity(String n,double c) {
		Activity currentActivity = new Activity(n, c); // Create a new instance of Activity 
		boolean findActivity = findActivityName(n); 
		
		if(findActivity == true) { // If n is already found in the ArrayList
			int findIndex = findActivityIndex(n);
            activityAdded.get(findIndex).updateCalories(c);
			System.out.printf("Updated Activity %s with %.2f kcal \n", n, currentActivity.getActivityCalories());
		
		} else if(findActivity == false) { // If n is not found in the ArrayList  
			activityAdded.add(new Activity(n, c));
			System.out.printf("Added Activity %s with %.2f kcal \n", n, c);
		} 
			return null; 
	}
	
    // @param foodName: the name of the food
    // @param servings: the number of servings eaten
    
	public String eat (String foodName, double servings) {
		boolean findFood = findFoodName(foodName);
		
		if(servings < 0) { // If inputted servings are negative
			System.out.println("Number of servings cannot be negative.");
		
		} else if(findFood == true) { // If foodName is already found in the ArrayList 
            int findIndex = findFoodIndex(foodName); 
            
            double caloricValue = servings * foodAdded.get(findIndex).getFoodCalories(); // Get the registered food calories at the index 
			
            // Necessary to make String as the ArrayList are of type String
            String makeCaloriesString = Double.toString(caloricValue); 
			String makeServingsString = Double.toString(servings);  
			
            // Add String elements into respective ArrayLists 
			foodEatenName.add(foodName);
			foodEatenServings.add(makeServingsString);
            foodEatenKcal.add(makeCaloriesString);
			
            // Update caloriesConsumed
			caloriesConsumed += caloricValue;
			System.out.printf("Ate %.2f serving(s) of %s, %.2f kcal \n", servings, foodName, caloricValue);
			
		} else if(findFood == false) { // If foodName is not found in the ArrayList
			System.out.println("The specified food does not exist.");
		}

		return null; 
	}
	
    // @param actName: the name of the activity
    // @param hours: the number of hours that the activity was performed 
    
	public String perform(String actName, double hours) {
		boolean findActivity = findActivityName(actName);
		
		if(hours < 0) { // If inputted hours are negative
			System.out.println("Number of servings cannot be negative.");
		
		} else if(findActivity == true) {  // If actName is already found in the ArrayList 
            int findIndex = findActivityIndex(actName);
			
            double caloricValue = hours * activityAdded.get(findIndex).getActivityCalories(); // Get the registered activity calories at the index
            
            // Necessary to make String as the ArrayList are of type String
			String makeCaloriesString = Double.toString(caloricValue);
            String makeHoursString = Double.toString(hours);
			
            // Add String elements into respective ArrayLists 
			activityPerformedName.add(actName);
			activityPerformedServings.add(makeHoursString);
			activityPerformedKcal.add(makeCaloriesString);
			
            // Update caloriesBurned
            caloriesBurned += caloricValue;
			System.out.printf("Performed %.2f hour(s) of %s, %.2f kcal\n", hours, actName, caloricValue);
		
		} else if(findActivity == false) { // If actName is not found in the ArrayList
			System.out.println("The specified activity does not exist.");
		}
        
		return null;
	}
    
// Public Methods for Add-Ons 1 and 2 
    
    // Method #1: Allows the user to periodically view all food eaten and activities performed so far with corresponding record numbers
    public String recordsSoFar() { 
		System.out.println("----------------");
        System.out.println("CURRENT REPORT");
        System.out.println("----------------");
		System.out.println("Food Consumed So Far: ");
		
		for(int i = 0; i < foodEatenName.size(); i++) {
			String foodInfoName = foodEatenName.get(i);
			String foodInfoServings = foodEatenServings.get(i);
			double makeServingsDouble = Double.parseDouble(foodInfoServings);
			
			System.out.printf("| Index  %d | %-4s %.2f \n", i, foodInfoName, makeServingsDouble);
		}
        
		System.out.println("----------------");
		System.out.println("Activities Performed So Far: ");
		
        for(int j = 0; j < activityPerformedName.size(); j++) {
			String activityInfoName = activityPerformedName.get(j);
			String activityInfoHours = activityPerformedServings.get(j);
			double makeHoursDouble = Double.parseDouble(activityInfoHours);
			
			System.out.printf("| Index  %d | %-4s %.2f \n", j, activityInfoName, makeHoursDouble);
		}
		System.out.println("----------------");
		
		return null; 
	}

	// Method #2: Allows the user to select a record number and edit the servings of either food or activity 
        // @param recordNumber: inputted index that the user wishes to edit
        // @param name: inputted name of the food/activity that the user wishes to edit
        // @param num: new version of servings
    
	public String edit(int recordNumber, String name, double num) {
		boolean findFoodName = findFoodEatenName(name);
		
		if(findFoodName == true) { // If name is found in ArrayList foodEatenName
			boolean findchosenFoodIndex = findFoodEatenIndex(recordNumber);
			
			if(findchosenFoodIndex == true) { // If the index of name was found 

				// Update caloriesConsumed 
				String originalCaloricValue = foodEatenKcal.get(recordNumber);
				Double makeOriginalDouble = Double.parseDouble(originalCaloricValue);
				caloriesConsumed -= makeOriginalDouble;

				// Update foodEatenKcal by multiplying new servings(num) with foodCalories 
				int findIndex = findFoodIndex(name); // Use findFoodIndex method to ensure that the right index is being updated
                
                double updatedCaloricValue = num*foodAdded.get(findIndex).getFoodCalories();
				caloriesConsumed += updatedCaloricValue; // update caloriesConsumed with new value of foodEatenKcal
				
				// Use set method to update values
				String makeServingsString = Double.toString(num); // Made string because foodEatenServings can only accept String elements
				String makeUpdateString = Double.toString(updatedCaloricValue);
				foodEatenKcal.set(recordNumber, makeUpdateString);
				foodEatenServings.set(recordNumber, makeServingsString);
			
				System.out.printf("Edited Index %d, %s now has %s serving(s) \n", recordNumber, name, makeServingsString);
				
			}
			
		} else if(findFoodName == false) { // If name is not found in ArrayList foodEatenName, proceed to activityPerformedName
			boolean findActivityName = findActivityPerformedName(name);
			
            if(findActivityName == true) { // If the name is found in activityPerformedName
				boolean findchosenActivityIndex = findActivityPerformedIndex(recordNumber);
				
				if(findchosenActivityIndex == true) { // If the index of name was found
                    
                    // Update caloriesBurned
					String originalCaloricValue = activityPerformedKcal.get(recordNumber);
					Double makeOriginalDouble = Double.parseDouble(originalCaloricValue);
					caloriesBurned -= makeOriginalDouble;
					
                    // Update activityPerformedKcal by multiplying new servings(num) with activityCalories
					int findIndex = findActivityIndex(name);  // Use findActivityIndex method to ensure that the right index is being updated
                    
                    double updatedCaloricValue = activityAdded.get(findIndex).getActivityCalories();
					caloriesBurned += updatedCaloricValue; // Update caloriesBurned with new value of activityPerformedKcal
					
                    // Use set method to update values 
					String makeHoursString = Double.toString(num);
					String makeUpdateString = Double.toString(updatedCaloricValue);
					activityPerformedKcal.set(recordNumber, makeUpdateString);
					activityPerformedServings.set(recordNumber, makeHoursString);
					
					System.out.printf("Edited Index %d, %s now has %s hour(s) \n", recordNumber, name, makeHoursString);
					
				} 
				
			} else if(findActivityName == false) {
				System.out.println("Your input can not be found in either Food Consumed So Far or Activities Performed So Far");
			}
		}
		
		return null;
	}
	
    // Method #3: Allows the user to select a record number and delete the food eaten or activity performed entry 
        // @param recordNumber: inputted index that the user wishes to edit
        // @param name: inputted name of the food/activity that the user wishes to edit
    
	public String delete(int recordNumber, String name) { 
		boolean findFoodName = findFoodEatenName(name);
        
		if(findFoodName == true) { // If name is found in ArrayList foodEatenName
			boolean findchosenFoodIndex = findFoodEatenIndex(recordNumber);
			
			if(findchosenFoodIndex == true) { // If the index of name was found 
                
                // Update caloriesConsumed
				String originalCaloricValue = foodEatenKcal.get(recordNumber);
				Double makeOriginalDouble = Double.parseDouble(originalCaloricValue);
				caloriesConsumed -= makeOriginalDouble;
				
                // Use remove method to update values 
				foodEatenName.remove(recordNumber);
				foodEatenServings.remove(recordNumber);
				foodEatenKcal.remove(recordNumber);
				
				System.out.printf("Deleted entry %d: %s from Food Consumed So Far \n", recordNumber, name);
			
			} 
			
		} else if(findFoodName == false) { // If name is not found in ArrayList foodEatenName, proceed to activityPerformedName
			boolean findActivityName = findActivityPerformedName(name);
			
			if(findActivityName == true) { // If the name is found in activityPerformedName
				boolean findchosenActivityIndex = findActivityPerformedIndex(recordNumber);
				
				if(findchosenActivityIndex == true) { // If the index of the name is found 
					
					// Update caloriesBurned 
					String originalCaloricValue = activityPerformedKcal.get(recordNumber);
					Double makeOriginalDouble = Double.parseDouble(originalCaloricValue);
					caloriesBurned -= makeOriginalDouble;
					
                    // Use remove method to update values 
					activityPerformedName.remove(recordNumber);
					activityPerformedServings.remove(recordNumber);
					activityPerformedKcal.remove(recordNumber);
					
					System.out.printf("Deleted entry %d: %s from Activities Performed So Far \n", recordNumber, name);
				
				} 
			
			} else if(findActivityName == false) {
				System.out.println("Your input can not be found in either Food Consumed So Far or Activities Performed So Far");
			}
		}

		return null;
	}
    
 // End of Public Methods for Add-Ons 1 and 2
    
    public String report() { 
		System.out.println("----------------");
		System.out.println("LIFESTYLE REPORT");
		System.out.println("----------------");
		System.out.println("Food Consumed:");
		
		// For loop through foodEatenName
		for(int i = 0; i < foodEatenName.size(); i++) {
			String foodInfoName = foodEatenName.get(i);
			String foodInfoServings = foodEatenServings.get(i);
			double makeServingsDouble = Double.parseDouble(foodInfoServings);
			String foodInfoKcal = foodEatenKcal.get(i);
			double makeKcalDouble = Double.parseDouble(foodInfoKcal);
			
			System.out.printf("%.2f serving(s) of %s, %.2f kcal \n", makeServingsDouble, foodInfoName, makeKcalDouble);
		}

		System.out.println("----------------");
		System.out.printf("Total Calories Consumed: %6.2f \n", caloriesConsumed);
		System.out.println("----------------");
		
		System.out.println("Activities Performed:");
		
		// For loop through activityPerformedName
		for(int i = 0; i < activityPerformedName.size(); i++) {
			String activityInfoName = activityPerformedName.get(i);
			String activityInfoHours = activityPerformedServings.get(i);
			double makeHoursDouble = Double.parseDouble(activityInfoHours);
			String activityInfoKcal = activityPerformedKcal.get(i);
			double makeKcalDouble = Double.parseDouble(activityInfoKcal);
			
			System.out.printf("%.2f hour(s) of %s, %.2f kcal \n", makeHoursDouble, activityInfoName, makeKcalDouble);
		}
		
		System.out.println("----------------");
		System.out.printf("Total Calories Burned: %6.2f \n", caloriesBurned);
		System.out.println("----------------");
		
        // Computations for netCalories and calculations depending on time period 
		netCalories = caloriesConsumed - caloriesBurned;
		weekCalculation = (Math.abs(netCalories)*kcal)*7;
		monthCalculation = (Math.abs(netCalories)*kcal)*30;
		threeMonthCalculation = (Math.abs(netCalories)*kcal)*90;
		sixMonthCalculation = (Math.abs(netCalories)*kcal)*180;
		
		System.out.printf("Net Calories for the Day: %6.2f kcal \n", netCalories);
		System.out.println("If you keep up this lifestyle...");
		System.out.printf("In a week, you will lose %.2f kilograms \n", weekCalculation);
		System.out.printf("In a month, you will lose %.2f kilograms \n", monthCalculation);
		System.out.printf("In 3 months, you will lose %.2f kilograms \n", threeMonthCalculation);
		System.out.printf("In 6 months, you will lose %.2f kilograms \n", sixMonthCalculation);
		System.out.println("----------------"); 

		return null;
	}
}