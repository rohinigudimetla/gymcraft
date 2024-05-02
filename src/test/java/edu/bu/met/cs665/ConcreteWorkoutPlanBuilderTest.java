/**
 * Name: ROHINI GUDIMETLA
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/02/2024
 * File Name: ConcreteWorkoutPlanBuilderTest.java
 * Description: The ConcreteWorkoutPlanBuilderTest class tests the ConcreteWorkoutPlanBuilder class. 
 */

package edu.bu.met.cs665;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class ConcreteWorkoutPlanBuilderTest {
    private ConcreteWorkoutPlanBuilder builder;
    private ExerciseFilter exerciseFilter;

    @Before
    public void setUp() {
        exerciseFilter = new ExerciseFilter();
        builder = new ConcreteWorkoutPlanBuilder();
    }
// In this test case, we create a ConcreteWorkoutPlanBuilder and an 
// ExerciseFilter, prepare the exercises and exerciseSRD data, calling combineExercisesAndSRD with this data, 
// and checking that the result is not null, 
// has the same size as exercises, and each row in the result contains the correct exercise and SRD.
    @Test
    public void testCombineExercisesAndSRD() {
        // Prepare the data
        List<Exercise> exercises = Arrays.asList(new Exercise(), new Exercise());
        List<List<Integer>> exerciseSRD = Arrays.asList(Arrays.asList(3, 8, 0), Arrays.asList(4, 10, 2));

        // Call the method to test
        List<List<Object>> result = builder.combineExercisesAndSRD(exercises, exerciseSRD);

        // Check the result
        assertNotNull(result);
        assertEquals(exercises.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            List<Object> row = result.get(i);
            assertEquals(exercises.get(i), row.get(0));
            assertEquals(exerciseSRD.get(i), row.subList(1, row.size()));
        }
    }
}