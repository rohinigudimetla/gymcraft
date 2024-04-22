package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkoutPlan {
    private String focusArea;
    private List<Exercise> exercises;
    private Map<Exercise, ExerciseDetails> exerciseDetailsMap;

    public WorkoutPlan() {
        exercises = new ArrayList<>();
        exerciseDetailsMap = new HashMap<>();
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
        this.exercises = exercises;
    }

    public void setExerciseDetails(Exercise exercise, int sets, int reps, int duration) {
        ExerciseDetails details = new ExerciseDetails(sets, reps, duration);
        exerciseDetailsMap.put(exercise, details);
    }

    public ExerciseDetails getExerciseDetails(Exercise exercise) {
        return exerciseDetailsMap.get(exercise);
    }
}