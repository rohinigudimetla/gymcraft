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
            String requestedCategory = (String) request.getValue();
            int sets = request.getSets();
            int reps = request.getReps();
            int duration = request.getDuration();

            for (Exercise exercise : exercises) {
                List<String> categories = exercise.getCategory();
                if (categories != null && categories.contains(requestedCategory.toLowerCase())) {
                    builder.addExercise(exercise);
                    builder.setExerciseDetails(exercise, sets, reps, duration);
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