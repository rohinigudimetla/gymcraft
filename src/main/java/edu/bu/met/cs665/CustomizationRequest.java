package edu.bu.met.cs665;

public class CustomizationRequest {
    private CustomizationType type;
    private Object value;
    private int sets;
    private int reps;
    private int duration;

    public CustomizationRequest(CustomizationType type, Object value) {
        this.type = type;
        this.value = value;
    }

    public CustomizationRequest(CustomizationType type, Object value, int sets, int reps, int duration) {
        this.type = type;
        this.value = value;
        this.sets = sets;
        this.reps = reps;
        this.duration = duration;
    }

    public CustomizationType getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public int getDuration() {
        return duration;
    }
}