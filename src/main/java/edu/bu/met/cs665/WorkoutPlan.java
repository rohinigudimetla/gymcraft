package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;

public class WorkoutPlan {
    private List<Exercise> exercises = new ArrayList<>();

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    public void removeExercise(Exercise exercise) {
        exercises.remove(exercise);
    }

    public void execute() {
        for (Exercise exercise : exercises) {
            System.out.println("Performing exercise: " + exercise.getName());
        }
    }

    // other methods will be added later
}
