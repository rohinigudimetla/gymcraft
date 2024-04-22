package edu.bu.met.cs665;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

public class WorkoutPlanDirectorTest {

    @Test
    public void testBuildWorkoutWithChosenExercises() {
        // Arrange
        WorkoutPlanBuilder mockBuilder = mock(WorkoutPlanBuilder.class);
        ExerciseAPI mockExerciseAPI = mock(ExerciseAPI.class);
        WorkoutPlanDirector director = new WorkoutPlanDirector(mockBuilder, mockExerciseAPI);

        Exercise exercise1 = new Exercise();
        exercise1.setName("Single-Leg Press");
        exercise1.setCategory(Arrays.asList("legs"));

        Exercise exercise2 = new Exercise();
        exercise2.setName("Bicep Curl");
        exercise2.setCategory(Arrays.asList("arms"));

        Exercise exercise3 = new Exercise();
        exercise3.setName("Squats");
        exercise3.setCategory(Arrays.asList("legs"));

        List<Exercise> allExercises = Arrays.asList(exercise1, exercise2, exercise3);
        when(mockExerciseAPI.getExercises()).thenReturn(allExercises);

        List<Exercise> chosenExercises = Arrays.asList(exercise1, exercise3);
        String focusArea = "legs";
        int sets = 3;
        int reps = 10;

        // Act
        WorkoutPlan workoutPlan = director.buildWorkout(focusArea, chosenExercises, sets, reps);

        // Assert
        verify(mockBuilder).setFocusArea(focusArea);
        verify(mockBuilder).addExercise(exercise1);
        verify(mockBuilder).setExerciseDetails(exercise1, sets, reps, 0);
        verify(mockBuilder).addExercise(exercise3);
        verify(mockBuilder).setExerciseDetails(exercise3, sets, reps, 0);
        verify(mockBuilder, never()).addExercise(exercise2);

        List<Exercise> addedExercises = workoutPlan.getExercises();
        assertEquals(2, addedExercises.size());
        assertEquals("Single-Leg Press", addedExercises.get(0).getName());
        assertEquals("Squats", addedExercises.get(1).getName());

        System.out.println("Chosen Exercises:");
        for (Exercise exercise : addedExercises) {
            System.out.println("Name: " + exercise.getName());
            System.out.println("Sets: " + sets);
            System.out.println("Reps: " + reps);
            System.out.println();
        }
    }
}