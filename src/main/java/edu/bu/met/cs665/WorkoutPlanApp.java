package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;

public class WorkoutPlanApp {
    public static void main(String[] args) {
        if (args.length < 5) {
            System.out.println("Usage: WorkoutPlanApp <focusArea> <chosenExerciseNames> <sets> <reps> <duration> [filePath]");
            return;
        }

        String focusArea = args[0].toLowerCase();
        String[] chosenExerciseNames = args[1].split(",");
        int sets = Integer.parseInt(args[2]);
        int reps = Integer.parseInt(args[3]);
        int duration = Integer.parseInt(args[4]);
        String filePath = args.length > 5 ? args[5] : "workout_plan.txt";

        // Create a WorkoutPlanBuilder instance
        WorkoutPlanBuilder builder = new ConcreteWorkoutPlanBuilder();

        // Create an ExerciseAPI instance
        ExerciseAPI exerciseAPI = new ExerciseAPI();

        // Create a WorkoutPlanDirector instance
        WorkoutPlanDirector director = new WorkoutPlanDirector(builder, exerciseAPI);

        List<Exercise> allExercises = exerciseAPI.getExercises();
        List<Exercise> chosenExercises = new ArrayList<>();

        for (String name : chosenExerciseNames) {
            for (Exercise exercise : allExercises) {
                if (exercise.getName().equalsIgnoreCase(name.trim())) {
                    chosenExercises.add(exercise);
                }
            }
        }

        // Build the WorkoutPlan
        WorkoutPlan plan = director.buildWorkout(focusArea, chosenExercises, sets, reps, duration);

        // Save the WorkoutPlan to a file
        WorkoutPlanWriter writer = new WorkoutPlanWriter();
        writer.saveToFile(plan, filePath);

        System.out.println("Workout plan saved to " + filePath);
    }
}