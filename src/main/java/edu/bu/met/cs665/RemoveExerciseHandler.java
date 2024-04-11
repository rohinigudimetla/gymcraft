package edu.bu.met.cs665;

public class RemoveExerciseHandler implements Handler {
    private Handler successor;

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    @Override
    public void handleRequest(WorkoutPlan workoutPlan, Exercise exercise) {
        workoutPlan.removeExercise(exercise);
        if (successor != null) {
            successor.handleRequest(workoutPlan, exercise);
        }
    }
}