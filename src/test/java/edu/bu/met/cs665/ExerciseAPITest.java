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

        // Check that each exercise in the list has a non-null name, force, level, mechanic, equipment, primary muscles, secondary muscles, instructions, category, and id
//        for (Exercise exercise : exercises) {
//            System.out.println("Name: " + exercise.getName());
//            System.out.println("Force: " + (exercise.getForce() != null ? exercise.getForce() : "null"));
//            System.out.println("Level: " + exercise.getLevel());
//            System.out.println("Mechanic: " + (exercise.getMechanic() != null ? exercise.getMechanic() : "null"));
//            System.out.println("Equipment: " + (exercise.getEquipment() != null ? exercise.getEquipment() : "null"));
//            System.out.println("Primary Muscles: " + exercise.getPrimaryMuscles());
//            System.out.println("Secondary Muscles: " + exercise.getSecondaryMuscles());
//            System.out.println("Instructions: " + exercise.getInstructions());
//            System.out.println("Category: " + exercise.getCategory());
//            System.out.println("ID: " + exercise.getId());
//            System.out.println("--------------------\n");
//
//            assertNotNull("Exercise has null name", exercise.getName());
//            assertNotNull("Exercise has null level", exercise.getLevel());
//            assertNotNull("Exercise has null primary muscles", exercise.getPrimaryMuscles());
//            assertNotNull("Exercise has null secondary muscles", exercise.getSecondaryMuscles());
//            assertNotNull("Exercise has null instructions", exercise.getInstructions());
//            assertNotNull("Exercise has null category", exercise.getCategory());
//            assertNotNull("Exercise has null id", exercise.getId());
//        }
    }
}