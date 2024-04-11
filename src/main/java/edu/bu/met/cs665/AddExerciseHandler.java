package edu.bu.met.cs665;

public class AddExerciseHandler implements Handler {
    private Handler successor;

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    @Override
    public void handleRequest(WorkoutPlan workoutPlan, Exercise exercise) {
        workoutPlan.addExercise(exercise);
        if (successor != null) {
            successor.handleRequest(workoutPlan, exercise);
        }
    }
}