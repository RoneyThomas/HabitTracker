package me.roneythomas.habittracker;

/**
 * Created by roneythomas on 2016-07-22.
 */
public class Habit {

    private String title;
    private int duration;

    public Habit(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
