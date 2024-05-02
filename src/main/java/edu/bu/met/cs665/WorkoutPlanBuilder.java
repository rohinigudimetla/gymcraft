/**
 * Name: ROHINI GUDIMETLA
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/02/2024
 * File Name: WorkoutPlanBuilder.java
 * Description: The WorkoutPlanBuilder interface is responsible for defining the methods that a concrete builder class must implement.
 */

package edu.bu.met.cs665;

import java.util.List;

public interface WorkoutPlanBuilder {
    void setSRD(String focusArea, List<Integer> exerciseIndices, List<List<Integer>> exerciseSRD);
    List<List<Object>> combineExercisesAndSRD(List<Exercise> exercises, List<List<Integer>> exerciseSRD);
    void saveWorkoutPlan();
}