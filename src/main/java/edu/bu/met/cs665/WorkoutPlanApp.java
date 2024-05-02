//package edu.bu.met.cs665;
//
//public class WorkoutPlanApp {
//    public static void main(String[] args) {
//        if (args.length < 4) {
//            System.out.println("Usage: WorkoutPlanApp <focusArea> <sets> <reps> <duration> [filePath]");
//            return;
//        }
//
//        String focusArea = args[0].toLowerCase();
//        int sets = Integer.parseInt(args[1]);
//        int reps = Integer.parseInt(args[2]);
//        int duration = Integer.parseInt(args[3]);
//        String filePath = args.length > 4 ? args[4] : "workout_plan.txt";
//
//        // Create a WorkoutPlanBuilder instance
//        WorkoutPlanBuilder builder = new ConcreteWorkoutPlanBuilder();
//
//        // Create an ExerciseAPI instance
//        ExerciseAPI exerciseAPI = new ExerciseAPI();
//
//        // Create a WorkoutPlanDirector instance
//        WorkoutPlanDirector director = new WorkoutPlanDirector(builder, exerciseAPI);
//
//        // Build the WorkoutPlan
//        WorkoutPlan plan = director.constructWorkoutPlan(focusArea, sets, reps, duration);
//
//        // Save the WorkoutPlan to a file
//        WorkoutPlanWriter writer = new WorkoutPlanWriter();
//        writer.saveToFile(plan, filePath);
//
//        System.out.println("Workout plan saved to " + filePath);
//    }
//}