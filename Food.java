/**
This is a Java file that contains the instance fields and methods required to represent a single Food item.
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

public class Food {
    private String foodName; 
    private double foodCalories; 

   // @param f: the name of the food
   // @param c: the calorie value of the food 

    public Food(String f, double c) {
        foodName = f;
        foodCalories = c; 
    }
		
    public String getFoodName() {
        return foodName; 
    }	
		
    public double getFoodCalories() {
        return foodCalories; 
    }
		
    public void updateCalories(double c) {
        foodCalories = c; 
    }
}
 
