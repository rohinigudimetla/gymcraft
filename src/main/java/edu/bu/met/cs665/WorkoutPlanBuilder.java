package edu.bu.met.cs665;

public class WorkoutPlanBuilder implements Builder {
    private WorkoutPlan workoutPlan = new WorkoutPlan();

    @Override
    public Builder addExercise(Exercise exercise) {
        workoutPlan.addExercise(exercise);
        return this;
    }

    @Override
    public WorkoutPlan build() {
        return workoutPlan;
    }

    // other methods will be added later
}