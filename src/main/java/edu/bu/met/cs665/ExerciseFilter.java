/**package edu.bu.met.cs665;

import java.util.List;

public class ExerciseFilter {
    private WorkoutPlanBuilder builder;
    private ExerciseAPI exerciseAPI;

    public ExerciseFilter(WorkoutPlanBuilder builder, ExerciseAPI exerciseAPI) {
        this.builder = builder;
        this.exerciseAPI = exerciseAPI;
    }

    public void CustomizeWorkoutPlan(String requestedPrimaryMuscle, int sets, int reps, int duration) {
        List<Exercise> exercises = exerciseAPI.getExercises();

        for (Exercise exercise : exercises) {
            String primaryMuscles = exercise.getPrimaryMuscles();
            if (primaryMuscles != null && primaryMuscles.toLowerCase().contains(requestedPrimaryMuscle.toLowerCase())) {
                builder.addExercise(exercise);
                builder.setExerciseDetails(exercise, sets, reps, duration);
                builder.setExerciseInstructions(exercise, exercise.getInstructions());
                builder.setExercisePrimaryMuscles(exercise, exercise.getPrimaryMuscles());
                builder.setExerciseSecondaryMuscles(exercise, exercise.getSecondaryMuscles());
                builder.setExerciseId(exercise, exercise.getId());
            }
        }
    }
} 
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