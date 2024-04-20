package edu.bu.met.cs665;

public class CustomizationRequest {
    private CustomizationType type;
    private Object value;

    public CustomizationRequest(CustomizationType type, Object value) {
        this.type = type;
        this.value = value;
    }

    public CustomizationType getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }
}