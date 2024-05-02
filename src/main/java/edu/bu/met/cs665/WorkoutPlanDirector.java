/**package edu.bu.met.cs665;

import java.util.List;

public class WorkoutPlanDirector {
    private WorkoutPlanBuilder builder;
    private ExerciseAPI exerciseAPI;

    public WorkoutPlanDirector(WorkoutPlanBuilder builder, ExerciseAPI exerciseAPI) {
        this.builder = builder;
        this.exerciseAPI = exerciseAPI;
    }

    public WorkoutPlan constructWorkoutPlan(String focusArea, int sets, int reps, int duration) {
        WorkoutPlan workoutPlan = builder.setFocusArea(focusArea).build();
        List<Exercise> exercises = exerciseAPI.getExercises();

        for (Exercise exercise : exercises) {
            builder.addExercise(exercise);
            builder.setExerciseDetails(exercise, sets, reps, duration);
            builder.setExerciseInstructions(exercise, exercise.getInstructions());
            builder.setExercisePrimaryMuscles(exercise, exercise.getPrimaryMuscles());
            builder.setExerciseSecondaryMuscles(exercise, exercise.getSecondaryMuscles());
            builder.setExerciseId(exercise, exercise.getId());
        }

        workoutPlan.setExercises(builder.getExercises());
        workoutPlan.setFocusArea(focusArea);
        List<Exercise> filteredExercises = workoutPlan.getFilteredExercises(focusArea);
        workoutPlan.setExercises(filteredExercises);
        return workoutPlan;
    }
}*/


package edu.bu.met.cs665;

import java.util.List;

public class WorkoutPlanDirector {
    public void constructWorkoutPlan(ConcreteWorkoutPlanBuilder builder, String focusArea, List<Integer> exerciseIndices, List<List<Integer>> exerciseSRD) {
        // builder.setExercises(focusArea, exerciseIndices);
        builder.setSRD(focusArea, exerciseIndices, exerciseSRD);
        builder.saveWorkoutPlan();
    }
}