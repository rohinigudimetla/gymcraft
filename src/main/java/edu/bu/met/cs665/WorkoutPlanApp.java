package edu.bu.met.cs665;

public class WorkoutPlanApp {
    public static void main(String[] args) {
        // Set up the Chain of Responsibility
        SetCountHandler setCountHandler = new SetCountHandler();
        DurationHandler durationHandler = new DurationHandler();
        RepCountHandler repCountHandler = new RepCountHandler();
        ExerciseHandler exerciseHandler = new ExerciseHandler();

        setCountHandler.SetNext(durationHandler)
                .SetNext(repCountHandler)
                .SetNext(exerciseHandler);

        // Create CustomizationRequest objects based on user input
        List<CustomizationRequest> requests = new ArrayList<>();
        // ... add requests to the list ...

        // Pass requests through the chain
        WorkoutPlanBuilder builder = new WorkoutPlanBuilder();
        for (CustomizationRequest request : requests) {
            setCountHandler.HandleRequest(builder, request);
        }

        // Build the WorkoutPlan
        WorkoutPlan plan = builder.build();

        // Save the WorkoutPlan to a text file
        WorkoutPlanWriter writer = new WorkoutPlanWriter();
        writer.saveToFile(plan, "workout_plan.txt");
    }
}