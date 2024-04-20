package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;

public class WorkoutPlanApp {
    public static void main(String[] args) {
        // Create a WorkoutPlanBuilder instance
        WorkoutPlanBuilder builder = new ConcreteWorkoutPlanBuilder();

        // Set up the Chain of Responsibility
        SetCountHandler setCountHandler = new SetCountHandler(builder);
        DurationHandler durationHandler = new DurationHandler(builder);
        RepCountHandler repCountHandler = new RepCountHandler(builder);
        ExerciseHandler exerciseHandler = new ExerciseHandler(builder, new ExerciseAPI());

        setCountHandler.SetNext(durationHandler)
                .SetNext(repCountHandler)
                .SetNext(exerciseHandler);

        // Create CustomizationRequest objects based on user input
        List<CustomizationRequest> requests = new ArrayList<>();
        requests.add(new CustomizationRequest(CustomizationType.SetCount, 3));
        requests.add(new CustomizationRequest(CustomizationType.Duration, 45));
        requests.add(new CustomizationRequest(CustomizationType.RepCount, 10));
        requests.add(new CustomizationRequest(CustomizationType.FetchExercises, null));

        // Pass requests through the chain
        for (CustomizationRequest request : requests) {
            setCountHandler.HandleRequest(request);
        }

        // Build the WorkoutPlan
        WorkoutPlan plan = builder.build();

        // Access the exercises in the final WorkoutPlan
        List<Exercise> exercises = plan.getExercises();
        // ... do something with the exercises ...
    }
}