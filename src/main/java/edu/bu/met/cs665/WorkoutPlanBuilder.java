package edu.bu.met.cs665;

public interface WorkoutPlanBuilder {
    WorkoutPlanBuilder1 setFocusArea(String focusArea);
    WorkoutPlanBuilder1 setDuration(int duration);
    WorkoutPlanBuilder1 setNumberOfSets(int numberOfSets);
    WorkoutPlanBuilder1 setRepetitions(int repetitions);
    WorkoutPlanBuilder1 addExercise(String exercise);
    WorkoutPlan build();
}