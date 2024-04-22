package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkoutPlanApp {
    public static void main(String[] args) {
        // Create a WorkoutPlanBuilder instance
        WorkoutPlanBuilder builder = new ConcreteWorkoutPlanBuilder();

        // Create an ExerciseAPI instance
        ExerciseAPI exerciseAPI = new ExerciseAPI();

        // Get user input for focus area and chosen exercises
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the focus area (e.g., legs, arms, chest): ");
        String focusArea = scanner.nextLine().toLowerCase();

        List<Exercise> allExercises = exerciseAPI.getExercises();
        List<Exercise> chosenExercises = new ArrayList<>();

        System.out.println("Available exercises for " + focusArea + ":");
        for (Exercise exercise : allExercises) {
            if (exercise.getCategory().contains(focusArea)) {
                System.out.println("- " + exercise.getName());
            }
        }

        System.out.print("Enter the names of the exercises you want to include (separated by commas): ");
        String exerciseNames = scanner.nextLine();
        String[] names = exerciseNames.split(",");
        for (String name : names) {
            for (Exercise exercise : allExercises) {
                if (exercise.getName().equalsIgnoreCase(name.trim())) {
                    chosenExercises.add(exercise);
                }
            }
        }

        System.out.print("Enter the number of sets: ");
        int sets = scanner.nextInt();

        System.out.print("Enter the number of reps: ");
        int reps = scanner.nextInt();

        // Build the WorkoutPlan
        WorkoutPlan plan = builder.setFocusArea(focusArea)
                .build(chosenExercises, sets, reps);

        // Save the WorkoutPlan to a file
        WorkoutPlanWriter writer = new WorkoutPlanWriter();
        writer.saveToFile(plan, "workout_plan.txt");

        System.out.println("Workout plan saved to workout_plan.txt");
    }
}