package edu.bu.met.cs665;

public class RepCountHandler implements ICustomizationHandler {
    private ICustomizationHandler nextHandler;
    private WorkoutPlanBuilder builder;

    public RepCountHandler(WorkoutPlanBuilder builder) {
        this.builder = builder;
    }

    @Override
    public void HandleRequest(CustomizationRequest request) {
        if (request.getType() == CustomizationType.RepCount) {
            int repetitions = (int) request.getValue();
            builder.setRepetitions(repetitions);
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