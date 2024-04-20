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
            for (Exercise exercise : exercises) {
                builder.addExercise(exercise);
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