package edu.bu.met.cs665;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class ExerciseFilterTest {
    private ExerciseFilter exerciseFilter;
    private ExerciseAPI exerciseAPI;

    @Before
    public void setUp() {
        exerciseFilter = new ExerciseFilter();
        exerciseAPI = new ExerciseAPI();
    }

    @Test
    public void testGetFilteredExercises() {
        // Prepare the data
        String focusArea = "glutes";
        List<Integer> exerciseIntegers = Arrays.asList(1, 2);

        // Call the method to test
        List<Exercise> result = exerciseFilter.getFilteredExercises(focusArea, exerciseIntegers);

        // Check the result
        assertNotNull(result);
        assertEquals(exerciseIntegers.size(), result.size());
        for (Exercise exercise : result) {
            String primaryMuscles = exercise.getPrimaryMuscles();
            String secondaryMuscles = exercise.getSecondaryMuscles();
            assertTrue(primaryMuscles.toLowerCase().contains(focusArea.toLowerCase()) ||
                       secondaryMuscles.toLowerCase().contains(focusArea.toLowerCase()));
        }
    }
}