package edu.bu.met.cs665;
import java.util.Collections;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ExerciseAPI {
    private static final Logger logger = LogManager.getLogger(ExerciseAPI.class);
    private static final String API_URL = "https://api.api-ninjas.com/v1/exercises"; // Updated API URL

    public List<Exercise> getExercises() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("X-Api-Key", "QNzzbTuv5/Zdq6dgHtyHGQ==szKtxfSLU25z0bQG") // my api key
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonObject = new JSONObject(response.body());
            JSONArray results = jsonObject.getJSONArray("results");

            List<Exercise> exercises = new ArrayList<>();
            for (int i = 0; i < results.length(); i++) {
                JSONObject jsonExercise = results.getJSONObject(i);
                Exercise exercise = new Exercise();
                exercise.setName(jsonExercise.getString("name"));
                exercise.setType(jsonExercise.getString("type"));
                exercise.setMuscle(jsonExercise.getString("muscle"));
                exercise.setEquipment(jsonExercise.getString("equipment"));
                exercise.setDifficulty(jsonExercise.getString("difficulty")); // Added this line
                exercise.setInstructions(jsonExercise.getString("instructions")); // Added this line
                exercises.add(exercise);

                // Print the details of each exercise to the console
                System.out.println("Name: " + exercise.getName());
                System.out.println("Type: " + exercise.getType());
                System.out.println("Muscle: " + exercise.getMuscle());
                System.out.println("Equipment: " + exercise.getEquipment());
                System.out.println("Difficulty: " + exercise.getDifficulty());
                System.out.println("Instructions: " + exercise.getInstructions());
                System.out.println("--------------------");
            }

            return exercises;
        } catch (Exception e) {
            logger.error("Failed to fetch exercises", e);
            return Collections.emptyList();
        }
    }
}