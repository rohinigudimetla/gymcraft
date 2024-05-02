/**
 * Name: ROHINI GUDIMETLA
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/02/2024
 * File Name: ExerciseFilter.java
 * Description: The ExerciseFilter class is responsible for filtering exercises based on the focus area and exercise indices.
 */
package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;

public class ExerciseFilter {
    private ExerciseAPI exerciseAPI;

    public ExerciseFilter() {
        this.exerciseAPI = new ExerciseAPI();
    }

    public List<Exercise> getFilteredExercises(String focusArea, List<Integer> exerciseIntegers) {
        List<Exercise> filteredExercisesList = new ArrayList<>();
        List<Exercise> chosenExercisesList = new ArrayList<>();
        List<Exercise> allExercises = exerciseAPI.getExercises();

         if (focusArea == null || focusArea.isEmpty()) {
             return allExercises;
         }

        for (Exercise exercise : allExercises) {
            String primaryMuscles = exercise.getPrimaryMuscles();
            String secondaryMuscles = exercise.getSecondaryMuscles();
//             System.out.println("primaryMuscles: "+ primaryMuscles);

            if ((primaryMuscles != null && primaryMuscles.toLowerCase().contains(focusArea.toLowerCase())) ||
                    (secondaryMuscles != null && secondaryMuscles.toLowerCase().contains(focusArea.toLowerCase()))) {
//                add to the list of relevant exercises
                 filteredExercisesList.add(exercise);
//                System.out.println(exercise.getName());

            }
        }
        for (int index : exerciseIntegers) {
            if (index >= 0 && index < filteredExercisesList.size()) {
//                System.out.println("Fruit at index " + index + ": " + fruits.get(index));
//                add to the list of chosen exercises
                chosenExercisesList.add(filteredExercisesList.get(index));
//                System.out.println(filteredExercisesList.get(index).getName());
            } else {
//                System.out.println("Index " + index + " is out of bounds.");
                return chosenExercisesList;
            }
        }

//        System.out.println("chosen:"+ chosenExercisesList);

         return chosenExercisesList;
    }
}