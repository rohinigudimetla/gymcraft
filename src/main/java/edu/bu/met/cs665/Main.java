/**
 * Name: FIRST_NAME LAST_NAME
 * Course: CS-665 Software Designs & Patterns
 * Date: MM/DD/YYYY
 * File Name: Main.java
 * Description: Write a description for this class
 */

package edu.bu.met.cs665;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Instantiate the director and builder
    WorkoutPlanDirector director = new WorkoutPlanDirector();
    ConcreteWorkoutPlanBuilder builder = new ConcreteWorkoutPlanBuilder();

    // Create the variables
    String fa = "biceps";
    List<Integer> exInd = Arrays.asList(15, 8);
    List<List<Integer>> exDt = Arrays.asList(Arrays.asList(3, 8, 0), Arrays.asList(4, 10, 5));

    // Call the constructWorkoutPlan method
    director.constructWorkoutPlan(builder, fa, exInd, exDt);
  }
}