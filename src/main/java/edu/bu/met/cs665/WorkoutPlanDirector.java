package edu.bu.met.cs665;

import java.util.List;

public class WorkoutPlanDirector {
    private WorkoutPlanBuilder builder;
    private ExerciseAPI exerciseAPI;

    public WorkoutPlanDirector(WorkoutPlanBuilder builder, ExerciseAPI exerciseAPI) {
        this.builder = builder;
        this.exerciseAPI = exerciseAPI;
    }

    public WorkoutPlan buildWorkout(String focusArea) {
        List<Exercise> exercises = exerciseAPI.getExercises();
        builder.setFocusArea(focusArea);

        for (Exercise exercise : exercises) {
            if (exercise.getCategory().contains(focusArea.toLowerCase())) {
                builder.addExercise(exercise);
            }
        }

        return builder.setNumberOfSets(3)
                .setRepetitions(10)
                .setDuration(45)
                .build();
    }
}