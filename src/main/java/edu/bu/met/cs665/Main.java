/**
 * Name: ROHINI GUDIMETLA
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/02/2024
 * File Name: Main.java
 * Description: The Main class serves as the entry point for the application.
 * It initializes necessary components and starts the application's logic.
 */

package edu.bu.met.cs665;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Instantiate the director and builder
    WorkoutPlanDirector director = new WorkoutPlanDirector();
    ConcreteWorkoutPlanBuilder builder = new ConcreteWorkoutPlanBuilder();

    // Create the variables
    
    // CHOOSE A FOCUS AREA
    String fa = "biceps";

    // CHOOSE EXERCISE INDICES
    List<Integer> exInd = Arrays.asList(15, 8);

    // CHOOSE EXERCISE SETS, REPS, AND DURATION
    List<List<Integer>> exDt = Arrays.asList(Arrays.asList(3, 8, 0), Arrays.asList(4, 10, 5));

    // Call the constructWorkoutPlan method
    director.constructWorkoutPlan(builder, fa, exInd, exDt);
  }
}