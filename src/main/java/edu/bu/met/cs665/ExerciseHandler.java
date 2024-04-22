package edu.bu.met.cs665;

import java.util.List;

public class ExerciseHandler implements ICustomizationHandler {
    private ICustomizationHandler nextHandler;
    private WorkoutPlanBuilder builder;
    private ExerciseAPI exerciseAPI;

    public ExerciseHandler(WorkoutPlanBuilder builder, ExerciseAPI exerciseAPI) {
        this.builder = builder;
        this.exerciseAPI = exerciseAPI;
    }

    @Override
    public void HandleRequest(CustomizationRequest request) {
        if (request.getType() == CustomizationType.FetchExercises) {
            List<Exercise> exercises = exerciseAPI.getExercises();
            Object value = request.getValue();
            String requestedCategory;

            if (value instanceof String) {
                requestedCategory = (String) value;
            } else {
                // Handle the case where the value is not a String
                // You can throw an exception, log an error, or provide a default value
                requestedCategory = "default";
            }

            for (Exercise exercise : exercises) {
                List<String> categories = exercise.getCategory();
                if (categories != null && categories.contains(requestedCategory.toLowerCase())) {
                    builder.addExercise(exercise);
                }
            }
        } else if (nextHandler != null) {
            nextHandler.HandleRequest(request);
        }
    }

    @Override
    public ICustomizationHandler SetNext(ICustomizationHandler handler) {
        this.nextHandler = handler;
        return handler;
    }
}