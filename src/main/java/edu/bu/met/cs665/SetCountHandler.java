package edu.bu.met.cs665;

public class SetCountHandler implements ICustomizationHandler {
    private ICustomizationHandler nextHandler;
    private WorkoutPlanBuilder builder;

    public SetCountHandler(WorkoutPlanBuilder builder) {
        this.builder = builder;
    }

    @Override
    public void HandleRequest(CustomizationRequest request) {
        if (request.getType() == CustomizationType.SetCount) {
            int numberOfSets = (int) request.getValue();
            builder.setNumberOfSets(numberOfSets);
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