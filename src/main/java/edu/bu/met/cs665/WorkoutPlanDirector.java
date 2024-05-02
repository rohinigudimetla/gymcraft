/**
 * Name: ROHINI GUDIMETLA
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/02/2024
 * File Name: WorkoutPlanDirector.java
 * Description: The WorkoutPlanDirector class is responsible for constructing the workout plan. 
 * It uses the ConcreteWorkoutPlanBuilder to set the exercises, sets, reps, and duration, and save the workout plan.
 
 */
package edu.bu.met.cs665;

import java.util.List;

public class WorkoutPlanDirector {
    public void constructWorkoutPlan(ConcreteWorkoutPlanBuilder builder, String focusArea, List<Integer> exerciseIndices, List<List<Integer>> exerciseSRD) {
        // builder.setExercises(focusArea, exerciseIndices);
        builder.setSRD(focusArea, exerciseIndices, exerciseSRD);
        builder.saveWorkoutPlan();
    }
}