/**
 * Name: ROHINI GUDIMETLA
 * Course: CS-665 Software Designs & Patterns
 * Date: 05/02/2024
 * File Name: WorkoutPlan.java
 * Description: The WorkoutPlan class is responsible for storing the details of a workout plan.
 */

package edu.bu.met.cs665;


import java.util.*;

public class WorkoutPlan {
//    private Exercise exercise;
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
    private Integer sets;
    private Integer reps;
    private Integer duration;

    public WorkoutPlan(Exercise exercise) {
//        this.exercise = exercise;
        this.name = exercise.getName();
        this.force = exercise.getForce();
        this.level = exercise.getLevel();
        this.mechanic = exercise.getMechanic();
        this.equipment = exercise.getEquipment();
        this.primaryMuscles = exercise.getPrimaryMuscles();
        this.secondaryMuscles = exercise.getSecondaryMuscles();
        this.instructions = exercise.getInstructions();
        this.category = exercise.getCategory();
        this.id = exercise.getId();
        
    }

    // Getter methods...

    public String getName() {
        return name;
    }

    public String getForce() {
        return force;
    }

    public String getLevel() {
        return level;
    }

    public String getMechanic() {
        return mechanic;
    }

    public String getEquipment() {
        return equipment;
    }

    public String getPrimaryMuscles() {
        return primaryMuscles;
    }

    public String getSecondaryMuscles() {
        return secondaryMuscles;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public String getCategory() {
        return category;
    }

    public String getId() {
        return id;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getSets() {
        return sets;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getReps() {
        return reps;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    // Rest of your class...
}