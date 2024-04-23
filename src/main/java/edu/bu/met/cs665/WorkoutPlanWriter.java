package edu.bu.met.cs665;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WorkoutPlanWriter {
    public void saveToFile(WorkoutPlan plan, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Workout Plan Details:\n");
            writer.write("Focus Area: " + plan.getFocusArea() + "\n");
            writer.write("Exercises:\n");

            Map<Exercise, ExerciseDetails> exerciseDetailsMap = plan.getExerciseDetailsMap();
            for (Exercise exercise : plan.getExercises()) {
                writer.write("- " + exercise.getName() + "\n");
                ExerciseDetails details = exerciseDetailsMap.get(exercise);
                if (details != null) {
                    writer.write("  Sets: " + details.getSets() + "\n");
                    writer.write("  Reps: " + details.getReps() + "\n");
                    writer.write("  Duration: " + details.getDuration() + " minutes\n");
                } else {
                    writer.write("  Sets: 0\n");
                    writer.write("  Reps: 0\n");
                    writer.write("  Duration: 0 minutes\n");
                }
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + filePath);
            e.printStackTrace();
        }
    }
}