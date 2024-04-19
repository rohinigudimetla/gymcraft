package edu.bu.met.cs665;
import java.io.IOException;
import java.util.Collections;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.HashMap;
import java.util.Map;
public class ExerciseAPI {
    private static final Logger logger = LogManager.getLogger(ExerciseAPI.class);
    private static final String API_URL = "https://api.api-ninjas.com/v1/exercises"; 

    public List<Exercise> getExercises() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("X-Api-Key", "QNzzbTuv5/Zdq6dgHtyHGQ==szKtxfSLU25z0bQG") // my api key
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
            // Print the response body
            System.out.println(response.body());
        
            JSONArray jsonArray = new JSONArray(response.body());
        
            Map<String, String> muscleGroupMapping = new HashMap<>();
            muscleGroupMapping.put("quadriceps", "legs");
            muscleGroupMapping.put("hamstrings", "legs");
            muscleGroupMapping.put("calves", "legs");
            muscleGroupMapping.put("biceps", "arms");
            muscleGroupMapping.put("triceps", "arms");
            muscleGroupMapping.put("forearms", "arms");
            muscleGroupMapping.put("chest", "chest");
            muscleGroupMapping.put("upper_back", "back");
            muscleGroupMapping.put("lower_back", "back");
            muscleGroupMapping.put("shoulders", "shoulders");
            muscleGroupMapping.put("abdominals", "abs");
            muscleGroupMapping.put("glutes", "glutes");
        
            List<Exercise> exercises = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Exercise exercise = new Exercise();
                exercise.setName(jsonObject.getString("name"));
                exercise.setType(jsonObject.getString("type"));
                exercise.setMuscle(jsonObject.getString("muscle"));
                exercise.setEquipment(jsonObject.getString("equipment"));
                exercise.setDifficulty(jsonObject.getString("difficulty"));
                exercise.setInstructions(jsonObject.getString("instructions"));
        
                // Set the category field based on the muscle group mapping
                String muscleGroup = jsonObject.getString("muscle");
                String category = muscleGroupMapping.get(muscleGroup);
                if (category != null) {
                    List<String> categories = new ArrayList<>();
                    categories.add(category);
                    exercise.setCategory(categories);
                }
        
                exercises.add(exercise);
            }
        
            return exercises;
        } catch (IOException | InterruptedException | JSONException e) {
            logger.error("Failed to fetch exercises", e);
            return Collections.emptyList();
        } catch (Exception e) {
            logger.error("Failed to fetch exercises", e);
            return Collections.emptyList();
        }
}
}