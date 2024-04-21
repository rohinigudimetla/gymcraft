package edu.bu.met.cs665;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;

public class ExerciseHandlerTest {

    @Test
    public void testHandleFetchExercisesRequest() {
        // Arrange
        WorkoutPlanBuilder mockBuilder = mock(WorkoutPlanBuilder.class);
        ExerciseAPI mockExerciseAPI = mock(ExerciseAPI.class);
        ExerciseHandler handler = new ExerciseHandler(mockBuilder, mockExerciseAPI);

        // Create a list of sample exercises based on the API response
        Exercise exercise1 = new Exercise();
        exercise1.setName("Rickshaw Carry");
        exercise1.setType("strongman");
        exercise1.setMuscle("forearms");
        exercise1.setEquipment("other");
        exercise1.setDifficulty("beginner");
        exercise1.setInstructions("Position the frame at the starting point, and load with the appropriate weight...");

        Exercise exercise2 = new Exercise();
        exercise2.setName("Single-Leg Press");
        exercise2.setType("strength");
        exercise2.setMuscle("quadriceps");
        exercise2.setEquipment("machine");
        exercise2.setDifficulty("intermediate");
        exercise2.setInstructions("Load the sled to an appropriate weight. Seat yourself on the machine, planting one foot on the platform in line with your hip...");

        List<Exercise> exercises = Arrays.asList(exercise1, exercise2);

        // Set up the mock behavior for the ExerciseAPI
        when(mockExerciseAPI.getExercises()).thenReturn(exercises);

        // Act
        CustomizationRequest request = new CustomizationRequest(CustomizationType.FetchExercises, null);
        handler.HandleRequest(request);

        // Assert
        // Verify that the getExercises method is called on the ExerciseAPI
        verify(mockExerciseAPI).getExercises();

        // Verify that the addExercise method is called on the WorkoutPlanBuilder for each exercise
        exercises.forEach(exercise -> verify(mockBuilder).addExercise(exercise));

        // Verify the order of method calls
        InOrder inOrder = inOrder(mockExerciseAPI, mockBuilder);
        inOrder.verify(mockExerciseAPI).getExercises();
        exercises.forEach(exercise -> inOrder.verify(mockBuilder).addExercise(exercise));

        // Verify that the addExercise method is called the correct number of times
        verify(mockBuilder, times(exercises.size())).addExercise(any(Exercise.class));

        // Verify that the addExercise method is called with a specific exercise
        Exercise expectedExercise = new Exercise();
        expectedExercise.setName("Single-Leg Press");
        expectedExercise.setType("strength");
        expectedExercise.setMuscle("quadriceps");
        expectedExercise.setEquipment("machine");
        expectedExercise.setDifficulty("intermediate");
        expectedExercise.setInstructions("Load the sled to an appropriate weight. Seat yourself on the machine, planting one foot on the platform in line with your hip...");
        verify(mockBuilder).addExercise(eq(expectedExercise));

        // Capture the Exercise objects passed to the addExercise method
        ArgumentCaptor<Exercise> exerciseCaptor = ArgumentCaptor.forClass(Exercise.class);
        verify(mockBuilder, times(2)).addExercise(exerciseCaptor.capture());

// Get the captured Exercise objects
        List<Exercise> capturedExercises = exerciseCaptor.getAllValues();

// Verify that the captured exercises match the expected exercises
        assertEquals(exercises.get(0), capturedExercises.get(0));
        assertEquals(exercises.get(1), capturedExercises.get(1));
    }
}