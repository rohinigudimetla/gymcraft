package edu.bu.met.cs665;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class WorkoutPlanAppTest {
    private static final String TEST_FILE_PATH = "test_workout_plan.txt";

    @Before
    public void setUp() {
        // Clean up the test file before each test
        try {
            java.nio.file.Files.deleteIfExists(java.nio.file.Paths.get(TEST_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        // Clean up the test file after each test
        try {
            java.nio.file.Files.deleteIfExists(java.nio.file.Paths.get(TEST_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWorkoutPlanApp() {
        // Arrange
        String focusArea = "legs";
        List<String> chosenExerciseNames = new ArrayList<>();
        chosenExerciseNames.add("Single-Leg Press");
        chosenExerciseNames.add("Squats");
        int sets = 3;
        int reps = 10;
        int duration = 30;

        // Act
        WorkoutPlanApp.main(new String[]{focusArea, String.join(",", chosenExerciseNames), String.valueOf(sets), String.valueOf(reps), String.valueOf(duration), TEST_FILE_PATH});

        // Assert
        try (BufferedReader reader = new BufferedReader(new FileReader(TEST_FILE_PATH))) {
            String line;
            boolean foundFocusArea = false;
            boolean foundChosenExercises = false;
            boolean foundSetsAndReps = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("Focus Area: " + focusArea)) {
                    foundFocusArea = true;
                }

                for (String exerciseName : chosenExerciseNames) {
                    if (line.contains("- " + exerciseName)) {
                        foundChosenExercises = true;
                        break;
                    }
                }

                if (line.contains("Sets: " + sets) && line.contains("Reps: " + reps) && line.contains("Duration: " + duration)) {
                    foundSetsAndReps = true;
                }
            }

            assertTrue("Focus area not found in the file", foundFocusArea);
            assertTrue("Chosen exercises not found in the file", foundChosenExercises);
            assertTrue("Sets, reps, and duration not found in the file", foundSetsAndReps);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}