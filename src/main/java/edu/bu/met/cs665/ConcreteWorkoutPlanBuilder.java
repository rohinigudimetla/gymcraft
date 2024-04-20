package edu.bu.met.cs665;

import java.util.List;

public class ConcreteWorkoutPlanBuilder implements WorkoutPlanBuilder {
    private WorkoutPlan workoutPlan;
    private List<Exercise> exercises;

    public ConcreteWorkoutPlanBuilder() {
        workoutPlan = new WorkoutPlan();
    }

    @Override
    public WorkoutPlanBuilder setFocusArea(String focusArea) {
        workoutPlan.setFocusArea(focusArea);
        return this;
    }

    @Override
    public WorkoutPlanBuilder setDuration(int duration) {
        workoutPlan.setDuration(duration);
        return this;
    }

    @Override
    public WorkoutPlanBuilder setNumberOfSets(int numberOfSets) {
        workoutPlan.setNumberOfSets(numberOfSets);
        return this;
    }

    @Override
    public WorkoutPlanBuilder setRepetitions(int repetitions) {
        workoutPlan.setRepetitions(repetitions);
        return this;
    }

    @Override
    public WorkoutPlanBuilder addExercise(Exercise exercise) {
        exercises.add(exercise);
        return this;
    }

    @Override
    public WorkoutPlan build() {
        workoutPlan.setExercises(exercises);
        return workoutPlan;
    }
}