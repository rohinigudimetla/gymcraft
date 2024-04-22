package edu.bu.met.cs665;

import java.util.List;

public interface WorkoutPlanBuilder {
    WorkoutPlanBuilder setFocusArea(String focusArea);
    WorkoutPlanBuilder addExercise(Exercise exercise);
    WorkoutPlanBuilder setExerciseDetails(Exercise exercise, int sets, int reps, int duration);
    WorkoutPlan build(List<Exercise> chosenExercises, int sets, int reps);
}
