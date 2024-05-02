package edu.bu.met.cs665;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExerciseAPI {
    private static final String EXERCISES_JSON_PATH = "data/exercises.json";

    public List<Exercise> getExercises() {
        try {
            String exercisesJson = Files.readString(Paths.get(EXERCISES_JSON_PATH));
            JSONArray jsonArray = new JSONArray(exercisesJson);
            List<Exercise> exercises = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Exercise exercise = new Exercise();
                exercise.setName(jsonObject.getString("name"));
            
                // Handle null force value
                if (!jsonObject.isNull("force")) {
                    exercise.setForce(jsonObject.getString("force"));
                } else {
                    exercise.setForce(null);
                }
            
                exercise.setLevel(jsonObject.getString("level"));
            
                // Handle null mechanic value
                if (!jsonObject.isNull("mechanic")) {
                    exercise.setMechanic(jsonObject.getString("mechanic"));
                } else {
                    exercise.setMechanic(null);
                }
            
                // Handle null equipment value
                if (!jsonObject.isNull("equipment")) {
                    exercise.setEquipment(jsonObject.getString("equipment"));
                } else {
                    exercise.setEquipment(null);
                }
            
                exercise.setPrimaryMuscles(jsonObject.getJSONArray("primaryMuscles").join(",").toLowerCase());
                exercise.setSecondaryMuscles(jsonObject.getJSONArray("secondaryMuscles").join(",").toLowerCase());
                exercise.setInstructions(jsonObject.getJSONArray("instructions").join("\\n"));
                exercise.setCategory(jsonObject.getString("category"));
                exercise.setId(jsonObject.getString("id"));
                exercises.add(exercise);
            }

            return exercises;
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}