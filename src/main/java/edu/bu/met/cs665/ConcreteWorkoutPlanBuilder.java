package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcreteWorkoutPlanBuilder implements WorkoutPlanBuilder {
    private WorkoutPlan workoutPlan;
    private List<Exercise> exercises;
    private Map<Exercise, ExerciseDetails> exerciseDetailsMap;

    public ConcreteWorkoutPlanBuilder() {
        workoutPlan = new WorkoutPlan();
        exercises = new ArrayList<>();
        exerciseDetailsMap = new HashMap<>();
    }

    @Override
    public WorkoutPlanBuilder setFocusArea(String focusArea) {
        workoutPlan.setFocusArea(focusArea);
        return this;
    }

    @Override
    public WorkoutPlanBuilder addExercise(Exercise exercise) {
        exercises.add(exercise);
        return this;
    }

    @Override
    public WorkoutPlanBuilder setExerciseDetails(Exercise exercise, int sets, int reps, int duration) {
        ExerciseDetails details = new ExerciseDetails(sets, reps, duration);
        exerciseDetailsMap.put(exercise, details);
        return this;
    }

    @Override
    public WorkoutPlan build() {
        workoutPlan.setExercises(exercises);
        for (Exercise exercise : exercises) {
            workoutPlan.setExerciseDetails(exercise, exerciseDetailsMap.get(exercise));
        }
        return workoutPlan;
    }

    @Override
    public List<Exercise> getExercises() {
        return exercises;
    }
}