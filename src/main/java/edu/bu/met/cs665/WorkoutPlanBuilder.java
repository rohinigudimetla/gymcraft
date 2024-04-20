package edu.bu.met.cs665;

import java.util.List;

public interface WorkoutPlanBuilder {
    WorkoutPlanBuilder setFocusArea(String focusArea);
    WorkoutPlanBuilder setDuration(int duration);
    WorkoutPlanBuilder setNumberOfSets(int numberOfSets);
    WorkoutPlanBuilder setRepetitions(int repetitions);
    WorkoutPlanBuilder addExercise(Exercise exercise);
    WorkoutPlan build();
}