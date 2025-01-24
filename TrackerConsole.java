/**
This is a Java file that repeatedly asks for input and performs the necessary mutator/accessor methods based on commandType (Report, Current, Edit, Delete, Food, Activity, Eat, Perform). Edit and Delete accept additional input. 
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

import java.util.Scanner;
public class TrackerConsole {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        LifestyleTracker newUser = new LifestyleTracker();
        System.out.println("Welcome to " + args[0] + "\'s Lifestyle Tracker!");
        	
        
		int i = 0;
		do {
			String commandType = in.next();
			
			if(commandType.equals("Report")) {
				newUser.report(); // Calls report method 
				break;
			
			} else if(commandType.equals("Current")) {
				newUser.recordsSoFar(); // Calls recordsSoFar to display food eaten and activities performed so far
				continue;
			
			} else if(commandType.equals("Edit")) { // Accepts additional input 
				System.out.println("To edit, follow the format [indexNumber] [name] [updatedValue]:");
				int indexInput = in.nextInt(); // Index number
				String formInput = in.next(); // Name of Food or Activity
				double updatedInput = in.nextDouble(); // Updated value of servings or hours 
				newUser.edit(indexInput, formInput, updatedInput);
				continue;
			
			} else if(commandType.equals("Delete")) { // Accepts additional input
				System.out.println("To delete, follow the format [indexNumber] [name]:");
				int indexInput = in.nextInt(); // Index Number
				String formInput = in.next(); // Name of Food or Activity 
				newUser.delete(indexInput, formInput);
				continue;
			}
			
			String nameInput = in.next();
			double numbersInput = in.nextDouble();
			
			if(commandType.equals("Food")) {
				newUser.addFood(nameInput, numbersInput); // Calls addFood method
				
			} else if(commandType.equals("Activity")) {
				newUser.addActivity(nameInput, numbersInput); // Calls addActivity method
			
			} else if(commandType.equals("Eat")) {
				newUser.eat(nameInput, numbersInput); // Calls eat method
			
			} else if(commandType.equals("Perform")) {
				newUser.perform(nameInput, numbersInput); // Calls perform method 
			
			} 

		} while (i != 1);
    }
}