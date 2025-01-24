/**
This is a Java file that contains the instance fields and methods required to represent a single Activity item.
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

public class Activity {
	private String activityName;
	private double activityCalories;
	
	// @param n: the name of the activity
    // @param c: the calorie value of the activity
    
	public Activity (String n,double c) {
		activityName = n; 
		activityCalories = c; 
	} 
	
	public String getActivityName() {
		return activityName;
	}
	
	public double getActivityCalories() {
		return activityCalories; 
	}
	
	public void updateCalories(double c) {
		activityCalories = c; 
	}

}
