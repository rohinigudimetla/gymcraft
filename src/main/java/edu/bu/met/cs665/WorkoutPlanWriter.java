// package edu.bu.met.cs665;

// import java.io.BufferedWriter;
// import java.io.FileWriter;
// import java.io.IOException;

// public class WorkoutPlanWriter {
//     public void saveToFile(WorkoutPlan plan, String filePath) {
//         try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
//             writer.write("Workout Plan Details:\\n");
//             writer.write("Focus Area: " + plan.getFocusArea() + "\\n");
//             writer.write("Exercises:\\n");

//             for (Exercise exercise : plan.getExercises()) {
//                 writer.write("- " + exercise.getName() + "\\n");
//                 ExerciseDetails details = plan.getExerciseDetails(exercise);
//                 writer.write("  Sets: " + details.getSets() + "\\n");
//                 writer.write("  Reps: " + details.getReps() + "\\n");
//                 writer.write("  Duration: " + details.getDuration() + " minutes\\n");
//                 writer.write("  Instructions:\\n");
//                 for (String instruction : plan.getExerciseInstructions(exercise)) {
//                     writer.write("    - " + instruction + "\\n");
//                 }
//                 writer.write("  Primary Muscles: " + plan.getExercisePrimaryMuscles(exercise) + "\\n");
//                 writer.write("  Secondary Muscles: " + plan.getExerciseSecondaryMuscles(exercise) + "\\n");
//                 writer.write("  ID: " + plan.getExerciseId(exercise) + "\\n\\n");
//             }
//         } catch (IOException e) {
//             System.err.println("Error writing to file: " + filePath);
//             e.printStackTrace();
//         }
//     }
// }
