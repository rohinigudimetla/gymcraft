package edu.bu.met.cs665;

import java.util.List;

public class WorkoutPlanDirector {
    private WorkoutPlanBuilder builder;
    private ExerciseAPI exerciseAPI;

    public WorkoutPlanDirector(WorkoutPlanBuilder builder, ExerciseAPI exerciseAPI) {
        this.builder = builder;
        this.exerciseAPI = exerciseAPI;
    }

    public WorkoutPlan buildWorkout(String focusArea, List<Exercise> chosenExercises, int sets, int reps, int duration) {
        WorkoutPlan workoutPlan = builder.setFocusArea(focusArea).build();

        for (Exercise exercise : chosenExercises) {
            if (exercise.getCategory().contains(focusArea.toLowerCase())) {
                builder.addExercise(exercise);
                builder.setExerciseDetails(exercise, sets, reps, duration);
            }
        }

        workoutPlan.setExercises(builder.getExercises());
        return workoutPlan;
    }
}