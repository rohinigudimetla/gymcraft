package edu.bu.met.cs665;

public interface Handler {
    void setSuccessor(Handler successor);
    void handleRequest(WorkoutPlan workoutPlan, Exercise exercise);
}