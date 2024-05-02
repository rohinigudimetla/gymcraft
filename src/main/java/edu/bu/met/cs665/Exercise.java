/**
 * Name: ROHINI GUDIMETLA
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/02/2024
 * File Name: Exercise.java
 * Description: The Exercise class is responsible for storing the details of an exercise.
 */

package edu.bu.met.cs665;

import java.util.List;
import java.util.ArrayList;

public class Exercise {
    private String name;
    private String force;
    private String level;
    private String mechanic;
    private String equipment;
    private String primaryMuscles;
    private String secondaryMuscles;
    private List<String> instructions;
    private String category;
    private String id;

    public Exercise() {
        instructions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForce() {
        return force;
    }

    public void setForce(String force) {
        this.force = force;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMechanic() {
        return mechanic;
    }

    public void setMechanic(String mechanic) {
        this.mechanic = mechanic;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getPrimaryMuscles() {
        return primaryMuscles;
    }

    public void setPrimaryMuscles(String primaryMuscles) {
        this.primaryMuscles = primaryMuscles;
    }

    public String getSecondaryMuscles() {
        return secondaryMuscles;
    }

    public void setSecondaryMuscles(String secondaryMuscles) {
        this.secondaryMuscles = secondaryMuscles;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructionsString) {
        String[] instructionsArray = instructionsString.split("\\\\\\\\n");
        instructions.clear();
        for (String instruction : instructionsArray) {
            instructions.add(instruction);
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    using a method to see if the exercise data is retrieved correctly. DELETE THIS LATER
    public static void main(String[] args) {
        // Create an Exercise object
        Exercise exercise = new Exercise();
        exercise.setName("Push-Up");
        exercise.setForce("push");
        exercise.setLevel("beginner");
        exercise.setMechanic("compound");
        exercise.setEquipment("body only");
        exercise.setPrimaryMuscles("chest, shoulders, triceps");
        exercise.setSecondaryMuscles("abdominals");
        exercise.setInstructions("Lie prone on the floor...");
        exercise.setCategory("chest, shoulders, triceps");
        exercise.setId("push_up");

        // Call the method you want to run
        printExerciseDetails(exercise);
    }

    public static void printExerciseDetails(Exercise exercise) {
        System.out.println("Exercise Name: " + exercise.getName());
        System.out.println("Force: " + exercise.getForce());
        System.out.println("Level: " + exercise.getLevel());
        System.out.println("Mechanic: " + exercise.getMechanic());
        System.out.println("Equipment: " + exercise.getEquipment());
        System.out.println("Primary Muscles: " + exercise.getPrimaryMuscles());
        System.out.println("Secondary Muscles: " + exercise.getSecondaryMuscles());
        System.out.println("Instructions: " + exercise.getInstructions());
        System.out.println("Category: " + exercise.getCategory());
        System.out.println("ID: " + exercise.getId());
    }
}