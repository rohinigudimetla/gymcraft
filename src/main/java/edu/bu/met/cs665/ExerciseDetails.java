package edu.bu.met.cs665;



public class ExerciseDetails {
    private int sets;
    private int reps;
    private int duration;

    public ExerciseDetails(int sets, int reps, int duration) {
        this.sets = sets;
        this.reps = reps;
        this.duration = duration;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public int getDuration() {
        return duration;
    }
}
