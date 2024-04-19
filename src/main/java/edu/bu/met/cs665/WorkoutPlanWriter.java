package edu.bu.met.cs665;

public class WorkoutPlanWriter {
    public void saveToFile(WorkoutPlan plan, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Workout Plan Details:\\n");
            writer.write("Focus Area: " + plan.getFocusArea() + "\\n");
            writer.write("Duration: " + plan.getDuration() + " minutes\\n");
            writer.write("Number of Sets: " + plan.getNumberOfSets() + "\\n");
            writer.write("Repetitions: " + plan.getRepetitions() + "\\n");
            writer.write("Exercises:\\n");
            for (String exercise : plan.getExercises()) {
                writer.write("- " + exercise + "\\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}