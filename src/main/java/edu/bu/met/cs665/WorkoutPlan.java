package edu.bu.met.cs665;

/**import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkoutPlan {
    private String focusArea;
    private List<Exercise> exercises;
    private Map<Exercise, ExerciseDetails> exerciseDetailsMap;
    private Map<Exercise, List<String>> exerciseInstructionsMap;
    private Map<Exercise, String> exercisePrimaryMusclesMap;
    private Map<Exercise, String> exerciseSecondaryMusclesMap;
    private Map<Exercise, String> exerciseIdMap;

    public WorkoutPlan() {
        exercises = new ArrayList<>();
        exerciseDetailsMap = new HashMap<>();
        exerciseInstructionsMap = new HashMap<>();
        exercisePrimaryMusclesMap = new HashMap<>();
        exerciseSecondaryMusclesMap = new HashMap<>();
        exerciseIdMap = new HashMap<>();
    }

    public String getFocusArea() {
        return focusArea;
    }

    public void setFocusArea(String focusArea) {
        this.focusArea = focusArea;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = new ArrayList<>(exercises);
    }

    public void setExerciseDetails(Exercise exercise, ExerciseDetails details) {
        exerciseDetailsMap.put(exercise, details);
    }

    public ExerciseDetails getExerciseDetails(Exercise exercise) {
        return exerciseDetailsMap.get(exercise);
    }

    public Map<Exercise, ExerciseDetails> getExerciseDetailsMap() {
        return exerciseDetailsMap;
    }

    public void setExerciseInstructions(Exercise exercise, List<String> instructions) {
        exerciseInstructionsMap.put(exercise, instructions);
    }

    public List<String> getExerciseInstructions(Exercise exercise) {
        return exerciseInstructionsMap.get(exercise);
    }

    public void setExercisePrimaryMuscles(Exercise exercise, String primaryMuscles) {
        exercisePrimaryMusclesMap.put(exercise, primaryMuscles);
    }

    public String getExercisePrimaryMuscles(Exercise exercise) {
        return exercisePrimaryMusclesMap.get(exercise);
    }

    public void setExerciseSecondaryMuscles(Exercise exercise, String secondaryMuscles) {
        exerciseSecondaryMusclesMap.put(exercise, secondaryMuscles);
    }

    public String getExerciseSecondaryMuscles(Exercise exercise) {
        return exerciseSecondaryMusclesMap.get(exercise);
    }

    public void setExerciseId(Exercise exercise, String id) {
        exerciseIdMap.put(exercise, id);
    }

    public String getExerciseId(Exercise exercise) {
        return exerciseIdMap.get(exercise);
    }

    public List<Exercise> getFilteredExercises(String focusArea) {
        if (focusArea == null || focusArea.isEmpty()) {
            return new ArrayList<>(exercises);
        }

        List<Exercise> filteredExercises = new ArrayList<>();
        for (Exercise exercise : exercises) {
            String primaryMuscles = exercisePrimaryMusclesMap.get(exercise);
            String secondaryMuscles = exerciseSecondaryMusclesMap.get(exercise);
            if (primaryMuscles != null && primaryMuscles.contains(focusArea) ||
                    secondaryMuscles != null && secondaryMuscles.contains(focusArea)) {
                filteredExercises.add(exercise);
            }
        }
        return filteredExercises;
    }

    public void removeExercise(Exercise exercise) {
        exercises.remove(exercise);
        exerciseDetailsMap.remove(exercise);
        exerciseInstructionsMap.remove(exercise);
        exercisePrimaryMusclesMap.remove(exercise);
        exerciseSecondaryMusclesMap.remove(exercise);
        exerciseIdMap.remove(exercise);
    }


}*/

import java.util.*;

public class WorkoutPlan {
//    private Exercise exercise;
    private String name;
    private String force;
    private String level;
    private String mechanic;
    private String equipment;
    private String primaryMuscles;
    private String secondaryMuscles;
    private List<String> instructions;
    private String category;
    private String id;
    private Integer sets;
    private Integer reps;
    private Integer duration;

    public WorkoutPlan(Exercise exercise) {
//        this.exercise = exercise;
        this.name = exercise.getName();
        this.force = exercise.getForce();
        this.level = exercise.getLevel();
        this.mechanic = exercise.getMechanic();
        this.equipment = exercise.getEquipment();
        this.primaryMuscles = exercise.getPrimaryMuscles();
        this.secondaryMuscles = exercise.getSecondaryMuscles();
        this.instructions = exercise.getInstructions();
        this.category = exercise.getCategory();
        this.id = exercise.getId();
        
    }

    // Getter methods...

    public String getName() {
        return name;
    }

    public String getForce() {
        return force;
    }

    public String getLevel() {
        return level;
    }

    public String getMechanic() {
        return mechanic;
    }

    public String getEquipment() {
        return equipment;
    }

    public String getPrimaryMuscles() {
        return primaryMuscles;
    }

    public String getSecondaryMuscles() {
        return secondaryMuscles;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public String getCategory() {
        return category;
    }

    public String getId() {
        return id;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getSets() {
        return sets;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getReps() {
        return reps;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    // Rest of your class...
}