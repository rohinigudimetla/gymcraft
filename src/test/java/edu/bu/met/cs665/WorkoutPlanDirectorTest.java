//package edu.bu.met.cs665;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Mockito.*;
//import org.mockito.ArgumentCaptor;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class WorkoutPlanDirectorTest {
//
//    @Test
//    public void testConstructWorkoutPlan() {
//        // Arrange
//        WorkoutPlanBuilder mockBuilder = mock(WorkoutPlanBuilder.class);
//        ExerciseAPI mockExerciseAPI = mock(ExerciseAPI.class);
//        WorkoutPlanDirector director = new WorkoutPlanDirector(mockBuilder, mockExerciseAPI);
//
//        Exercise exercise1 = new Exercise();
//        exercise1.setId("1");
//        exercise1.setName("Single-Leg Press");
//        exercise1.setPrimaryMuscles("quadriceps, glutes");
//        exercise1.setSecondaryMuscles("calves");
//
//        Exercise exercise2 = new Exercise();
//        exercise2.setId("2");
//        exercise2.setName("Bicep Curl");
//        exercise2.setPrimaryMuscles("biceps");
//        exercise2.setSecondaryMuscles("forearms");
//
//        List<Exercise> exercises = Arrays.asList(exercise1, exercise2);
//        when(mockExerciseAPI.getExercises()).thenReturn(exercises);
//
//        when(mockBuilder.setFocusArea(anyString())).thenReturn(mockBuilder);
//        when(mockBuilder.build()).thenReturn(new WorkoutPlan());
//
//        // Act
//        WorkoutPlan result = director.constructWorkoutPlan("focusArea", 3, 10, 30);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals("focusArea", result.getFocusArea());
//        assertEquals(2, result.getExercises().size());
//
//        List<Exercise> addedExercises = result.getExercises();
//        assertEquals("Single-Leg Press", addedExercises.get(0).getName());
//        assertEquals("quadriceps, glutes", addedExercises.get(0).getPrimaryMuscles());
//        assertEquals("calves", addedExercises.get(0).getSecondaryMuscles());
//        assertEquals("Bicep Curl", addedExercises.get(1).getName());
//        assertEquals("biceps", addedExercises.get(1).getPrimaryMuscles());
//        assertEquals("forearms", addedExercises.get(1).getSecondaryMuscles());
//
//        // Print the output
//        System.out.println("Constructed Workout Plan:");
//        for (Exercise exercise : addedExercises) {
//            System.out.println("ID: " + exercise.getId());
//            System.out.println("Name: " + exercise.getName());
//            System.out.println("Primary Muscles: " + exercise.getPrimaryMuscles());
//            System.out.println("Secondary Muscles: " + exercise.getSecondaryMuscles());
//            System.out.println("Sets: " + 3);
//            System.out.println("Reps: " + 10);
//            System.out.println("Duration: " + 30);
//            System.out.println();
//        }
//    }
//}