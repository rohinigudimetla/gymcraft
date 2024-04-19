package edu.bu.met.cs665;

public interface ICustomizationHandler {
    void HandleRequest(CustomizationRequest request);
    ICustomizationHandler SetNext(ICustomizationHandler handler);
}