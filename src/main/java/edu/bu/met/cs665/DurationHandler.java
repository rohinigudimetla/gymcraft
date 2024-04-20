package edu.bu.met.cs665;

public class DurationHandler implements ICustomizationHandler {
    private ICustomizationHandler nextHandler;
    private WorkoutPlanBuilder builder;

    public DurationHandler(WorkoutPlanBuilder builder) {
        this.builder = builder;
    }

    @Override
    public void HandleRequest(CustomizationRequest request) {
        if (request.getType() == CustomizationType.Duration) {
            int duration = (int) request.getValue();
            builder.setDuration(duration);
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