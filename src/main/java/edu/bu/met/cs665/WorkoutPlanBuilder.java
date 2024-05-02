package edu.bu.met.cs665;

import java.util.List;

public interface WorkoutPlanBuilder {
    WorkoutPlanBuilder setFocusArea(String focusArea);
    WorkoutPlanBuilder addExercise(Exercise exercise);
    WorkoutPlanBuilder setExerciseDetails(Exercise exercise, int sets, int reps, int duration);
    WorkoutPlanBuilder setExerciseInstructions(Exercise exercise, List<String> instructions);
    WorkoutPlanBuilder setExercisePrimaryMuscles(Exercise exercise, String primaryMuscles);
    WorkoutPlanBuilder setExerciseSecondaryMuscles(Exercise exercise, String secondaryMuscles);
    WorkoutPlanBuilder setExerciseId(Exercise exercise, String id);
    WorkoutPlanBuilder removeExercise(Exercise exercise);
    WorkoutPlan build();
    List<Exercise> getExercises();
}