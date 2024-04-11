package edu.bu.met.cs665;

public interface Builder {
    Builder addExercise(Exercise exercise);
    WorkoutPlan build();
}