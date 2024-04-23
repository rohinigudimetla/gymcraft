package edu.bu.met.cs665;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.mockito.ArgumentCaptor;

public class ExerciseHandlerTest {

    @Test
    public void testHandleFetchExercisesWithCategory() {
        // Arrange
        WorkoutPlanBuilder mockBuilder = mock(WorkoutPlanBuilder.class);
        ExerciseAPI mockExerciseAPI = mock(ExerciseAPI.class);
        ExerciseHandler handler = new ExerciseHandler(mockBuilder, mockExerciseAPI);

        // Create a list of Exercise objects with different categories
        Exercise exercise1 = new Exercise();
        exercise1.setName("Single-Leg Press");
        exercise1.setType("strength");
        exercise1.setMuscle("quadriceps");
        exercise1.setEquipment("machine");
        exercise1.setDifficulty("intermediate");
        exercise1.setInstructions("Load the sled to an appropriate weight...");
        List<String> categories1 = Arrays.asList("legs");
        exercise1.setCategory(categories1);

        Exercise exercise2 = new Exercise();
        exercise2.setName("Bicep Curl");
        exercise2.setType("strength");
        exercise2.setMuscle("biceps");
        exercise2.setEquipment("dumbbell");
        exercise2.setDifficulty("beginner");
        exercise2.setInstructions("Stand holding a dumbbell in each hand...");
        List<String> categories2 = Arrays.asList("arms");
        exercise2.setCategory(categories2);

        List<Exercise> exercises = Arrays.asList(exercise1, exercise2);

        // Set up the mock behavior for the ExerciseAPI
        when(mockExerciseAPI.getExercises()).thenReturn(exercises);

        // Act
        String category = "legs";
        CustomizationRequest request = new CustomizationRequest(CustomizationType.FetchExercises, category);
        handler.HandleRequest(request);

        // Assert
        // Capture the Exercise objects passed to the addExercise method
        ArgumentCaptor<Exercise> exerciseCaptor = ArgumentCaptor.forClass(Exercise.class);
        verify(mockBuilder, times(1)).addExercise(exerciseCaptor.capture());

        // Get the captured Exercise object
        List<Exercise> capturedExercises = exerciseCaptor.getAllValues();

        // Verify that only the exercise with the "legs" category was added
        assertEquals(1, capturedExercises.size());
        assertEquals("Single-Leg Press", capturedExercises.get(0).getName());

        // Print the captured exercises
        System.out.println("Captured Exercises:");
        for (Exercise exercise : capturedExercises) {
            System.out.println("Name: " + exercise.getName());
            System.out.println("Category: " + exercise.getCategory());
            System.out.println();
        }
    }
}