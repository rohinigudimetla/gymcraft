/**package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcreteWorkoutPlanBuilder implements WorkoutPlanBuilder {
    private WorkoutPlan workoutPlan;
    private List<Exercise> exercises;
    private Map<Exercise, ExerciseDetails> exerciseDetailsMap;
    private Map<Exercise, List<String>> exerciseInstructionsMap;
    private Map<Exercise, String> exercisePrimaryMusclesMap;
    private Map<Exercise, String> exerciseSecondaryMusclesMap;
    private Map<Exercise, String> exerciseIdMap;

    public ConcreteWorkoutPlanBuilder() {
        workoutPlan = new WorkoutPlan();
        exercises = new ArrayList<>();
        exerciseDetailsMap = new HashMap<>();
        exerciseInstructionsMap = new HashMap<>();
        exercisePrimaryMusclesMap = new HashMap<>();
        exerciseSecondaryMusclesMap = new HashMap<>();
        exerciseIdMap = new HashMap<>();
    }

    // @Override
    public WorkoutPlanBuilder setFocusArea(String focusArea) {
        workoutPlan.setFocusArea(focusArea);
        return this;
    }

    // @Override
    public WorkoutPlanBuilder addExercise(Exercise exercise) {
        exercises.add(exercise);
        return this;
    }

    // @Override
    public WorkoutPlanBuilder setExerciseDetails(Exercise exercise, int sets, int reps, int duration) {
        ExerciseDetails details = new ExerciseDetails(sets, reps, duration);
        exerciseDetailsMap.put(exercise, details);
        return this;
    }

    // @Override
    public WorkoutPlanBuilder setExerciseInstructions(Exercise exercise, List<String> instructions) {
        exerciseInstructionsMap.put(exercise, instructions);
        return this;
    }

    // @Override
    public WorkoutPlanBuilder setExercisePrimaryMuscles(Exercise exercise, String primaryMuscles) {
        exercisePrimaryMusclesMap.put(exercise, primaryMuscles);
        return this;
    }

    // @Override
    public WorkoutPlanBuilder setExerciseSecondaryMuscles(Exercise exercise, String secondaryMuscles) {
        exerciseSecondaryMusclesMap.put(exercise, secondaryMuscles);
        return this;
    }

    // @Override
    public WorkoutPlanBuilder setExerciseId(Exercise exercise, String id) {
        exerciseIdMap.put(exercise, id);
        return this;
    }

    // @Override
    public WorkoutPlanBuilder removeExercise(Exercise exercise) {
        exercises.remove(exercise);
        exerciseDetailsMap.remove(exercise);
        exerciseInstructionsMap.remove(exercise);
        exercisePrimaryMusclesMap.remove(exercise);
        exerciseSecondaryMusclesMap.remove(exercise);
        exerciseIdMap.remove(exercise);
        return this;
    }

    // @Override
    public WorkoutPlan build() {
        workoutPlan.setExercises(exercises);
        for (Exercise exercise : exercises) {
            workoutPlan.setExerciseDetails(exercise, exerciseDetailsMap.get(exercise));
            workoutPlan.setExerciseInstructions(exercise, exerciseInstructionsMap.get(exercise));
            workoutPlan.setExercisePrimaryMuscles(exercise, exercisePrimaryMusclesMap.get(exercise));
            workoutPlan.setExerciseSecondaryMuscles(exercise, exerciseSecondaryMusclesMap.get(exercise));
            workoutPlan.setExerciseId(exercise, exerciseIdMap.get(exercise));
        }
        return workoutPlan;
    }

    // @Override
    public List<Exercise> getExercises() {
        return exercises;
    }
}*/

package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ConcreteWorkoutPlanBuilder {
    private ExerciseFilter exerciseFilter;
    private List<WorkoutPlan> workoutPlans;

    public ConcreteWorkoutPlanBuilder() {
        this.exerciseFilter = new ExerciseFilter();
        this.workoutPlans = new ArrayList<>();
    }

    // set the exercises, sets, reps, and duration, and add them to the workout plan based on the focus area
    public void setSRD(String focusArea, List<Integer> exerciseIndices, List<List<Integer>> exerciseSRD) {
         List<Exercise> exercises = exerciseFilter.getFilteredExercises(focusArea, exerciseIndices);

//         exerciseFilter.getFilteredExercises(focusArea, exerciseIndices);
         List<List<Object>> combined = combineExercisesAndSRD(exercises, exerciseSRD);
//           combineExercisesAndSRD(exercises, exerciseSRD);
//         System.out.println("filteredList: " + exercises);

         for (List<Object> row : combined) {
             Exercise exercise = (Exercise) row.get(0);
             Integer sets = (Integer) row.get(1);
             Integer reps = (Integer) row.get(2);
             Integer duration = (Integer) row.get(3);

//             Exercise exercise = new Exercise();
             WorkoutPlan workoutPlanchunk = new WorkoutPlan(exercise);
            
             workoutPlanchunk.setSets(sets);
             workoutPlanchunk.setReps(reps);
             workoutPlanchunk.setDuration(duration);

             workoutPlans.add(workoutPlanchunk);  // this is the final list of exercises with details
//             System.out.println("workoutplanfinallist: " + workoutPlans);
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

//        System.out.println(combined);

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