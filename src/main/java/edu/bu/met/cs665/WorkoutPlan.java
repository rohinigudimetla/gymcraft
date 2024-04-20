package edu.bu.met.cs665;

import java.util.List;

public class WorkoutPlan {
    private String focusArea;
    private int duration;
    private int numberOfSets;
    private int repetitions;
    private List<Exercise> exercises;

    // Getters
    public String getFocusArea() {
        return focusArea;
    }

    public int getDuration() {
        return duration;
    }

    public int getNumberOfSets() {
        return numberOfSets;
    }

    public int getRepetitions() {
        return repetitions;
    }



    // Setters
    public void setFocusArea(String focusArea) {
        this.focusArea = focusArea;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setNumberOfSets(int numberOfSets) {
        this.numberOfSets = numberOfSets;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }
    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }
}