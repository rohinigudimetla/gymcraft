package edu.bu.met.cs665;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ExerciseAPITest {
    private ExerciseAPI api;

    @Before
    public void setUp() {
        api = new ExerciseAPI();
    }

    @Test
    public void testGetExercises() {
        List<Exercise> exercises = api.getExercises();

        // Check that the getExercises method does not return null
        assertNotNull("getExercises returned null", exercises);

        // Check that the getExercises method returns a non-empty list
        assertFalse("getExercises returned an empty list", exercises.isEmpty());

        // Check that each exercise in the list has a non-null name, type, muscle, equipment, difficulty, and instructions
        for (Exercise exercise : exercises) {
            assertNotNull("Exercise has null name", exercise.getName());
            assertNotNull("Exercise has null type", exercise.getType());
            assertNotNull("Exercise has null muscle", exercise.getMuscle());
            assertNotNull("Exercise has null equipment", exercise.getEquipment());
            assertNotNull("Exercise has null difficulty", exercise.getDifficulty());
            assertNotNull("Exercise has null instructions", exercise.getInstructions());

            // Print the details of each exercise to the console
            System.out.println("Name: " + exercise.getName());
            System.out.println("Type: " + exercise.getType());
            System.out.println("Muscle: " + exercise.getMuscle());
            System.out.println("Equipment: " + exercise.getEquipment());
            System.out.println("Difficulty: " + exercise.getDifficulty());
            System.out.println("Instructions: " + exercise.getInstructions());
            System.out.println("--------------------");
        }
    }
}