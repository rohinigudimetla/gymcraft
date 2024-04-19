package edu.bu.met.cs665;

public class WorkoutPlanDirector {
    private WorkoutPlanBuilder builder;

    public WorkoutPlanDirector(WorkoutPlanBuilder builder) {
        this.builder = builder;
    }

    public WorkoutPlan buildBackWorkout() {
        return builder.setFocusArea("Back")
                .addExercise("Lat Pulldowns")
                .addExercise("Seated Cable Rows")
                .addExercise("Dumbbell Rows")
                .setNumberOfSets(3)
                .setRepetitions(10)
                .setDuration(45)
                .build();
    }

    public WorkoutPlan buildAbsWorkout() {
        return builder.setFocusArea("Abs")
                .addExercise("Crunches")
                .addExercise("Leg Raises")
                .addExercise("Planks")
                .setNumberOfSets(3)
                .setRepetitions(15)
                .setDuration(30)
                .build();
    }

    // Add more methods for other workout types
}