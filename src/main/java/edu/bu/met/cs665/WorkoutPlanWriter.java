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
            for (Exercise exercise : plan.getExercises()) {
                writer.write("- " + exercise.getName() + "\n");
                ExerciseDetails details = plan.getExerciseDetails(exercise);
                if (details != null) {
                    writer.write("  Sets: " + details.getSets() + "\n");
                    writer.write("  Reps: " + details.getReps() + "\n");
                    writer.write("  Duration: " + details.getDuration() + " minutes\n");
                }
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + filePath);
            e.printStackTrace();
        }
    }
}