/**
 * Name: ROHINI GUDIMETLA
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/02/2024
 * File Name: ConcreteWorkoutPlanBuilder.java
 * Description: The ConcreteWorkoutPlanBuilder class is responsible for building the workout plan.
 * There are methods to filter exercises, set the exercises, sets, reps, and duration, and save the workout plan to a file.
 */
package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ConcreteWorkoutPlanBuilder implements WorkoutPlanBuilder{
    private ExerciseFilter exerciseFilter;
    private List<WorkoutPlan> workoutPlans;

    public ConcreteWorkoutPlanBuilder() {
        this.exerciseFilter = new ExerciseFilter();
        this.workoutPlans = new ArrayList<>();
    }

    @Override
    // set the exercises, sets, reps, and duration, and add them to the workout plan based on the focus area
    public void setSRD(String focusArea, List<Integer> exerciseIndices, List<List<Integer>> exerciseSRD) {
         List<Exercise> exercises = exerciseFilter.getFilteredExercises(focusArea, exerciseIndices);


         List<List<Object>> combined = combineExercisesAndSRD(exercises, exerciseSRD);


         for (List<Object> row : combined) {
             Exercise exercise = (Exercise) row.get(0);
             Integer sets = (Integer) row.get(1);
             Integer reps = (Integer) row.get(2);
             Integer duration = (Integer) row.get(3);


             WorkoutPlan workoutPlanchunk = new WorkoutPlan(exercise);
            
             workoutPlanchunk.setSets(sets);
             workoutPlanchunk.setReps(reps);
             workoutPlanchunk.setDuration(duration);

             workoutPlans.add(workoutPlanchunk);  // this is the final list of exercises with details

         }
    }
    // combine exercises, sets, reps, and duration into one list of lists
    public List<List<Object>> combineExercisesAndSRD(List<Exercise> exercises, List<List<Integer>> exerciseSRD) {
        List<List<Object>> combined = new ArrayList<>();

        for (int i = 0; i < exercises.size(); i++) {
            List<Object> row = new ArrayList<>();
            row.add(exercises.get(i));
            row.addAll(exerciseSRD.get(i));
            combined.add(row);
        }



        return combined;
    }

//     // save the workout plan to a file   
     public void saveWorkoutPlan() {
         try (BufferedWriter writer = new BufferedWriter(new FileWriter("workoutPlan.txt"))) {
             for (WorkoutPlan workoutPlan : workoutPlans) {
                 writer.write("Name: " + workoutPlan.getName());
                 writer.newLine();
                 writer.write("Force: " + workoutPlan.getForce());
                 writer.newLine();
                 writer.write("Level: " + workoutPlan.getLevel());
                 writer.newLine();
                 writer.write("Mechanic: " + workoutPlan.getMechanic());
                 writer.newLine();
                 writer.write("Equipment: " + workoutPlan.getEquipment());
                 writer.newLine();
                 writer.write("Primary Muscles: " + workoutPlan.getPrimaryMuscles());
                 writer.newLine();
                 writer.write("Secondary Muscles: " + workoutPlan.getSecondaryMuscles());
                 writer.newLine();
                 writer.write("Instructions: " + workoutPlan.getInstructions());
                 writer.newLine();
                 writer.write("Category: " + workoutPlan.getCategory());
                 writer.newLine();
                 writer.write("ID: " + workoutPlan.getId());
                 writer.newLine();
                 writer.write("Sets: " + workoutPlan.getSets());
                 writer.newLine();
                 writer.write("Reps: " + workoutPlan.getReps());
                 writer.newLine();
                 writer.write("Duration: " + workoutPlan.getDuration());
                 writer.newLine();
                 writer.write("--------------------------------------------------");
                 writer.newLine();
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
}