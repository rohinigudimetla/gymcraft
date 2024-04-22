package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;

public class WorkoutPlanDirector {
    private WorkoutPlanBuilder builder;
    private ExerciseAPI exerciseAPI;

    public WorkoutPlanDirector(WorkoutPlanBuilder builder, ExerciseAPI exerciseAPI) {
        this.builder = builder;
        this.exerciseAPI = exerciseAPI;
    }

    public WorkoutPlan buildWorkout(String focusArea, List<Exercise> chosenExercises, int sets, int reps) {
        List<Exercise> exercises = exerciseAPI.getExercises();
        builder.setFocusArea(focusArea);

        List<Exercise> filteredExercises = new ArrayList<>();

        for (Exercise exercise : chosenExercises) {
            if (exercise.getCategory().contains(focusArea.toLowerCase())) {
                filteredExercises.add(exercise);
                builder.addExercise(exercise);
                builder.setExerciseDetails(exercise, sets, reps, 0); // Set duration to 0 for now
            }
        }

        return builder.build(filteredExercises, sets, reps);
    }
}