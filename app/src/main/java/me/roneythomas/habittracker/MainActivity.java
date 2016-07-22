package me.roneythomas.habittracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitLab habitLab = HabitLab.get(getApplicationContext());
        // New Habit
        Habit habit = new Habit("Running", 20);
        // Add Habit to db
        habitLab.addHabit(habit);
        // Get the Habit
        Habit running = habitLab.getHabit("Running");
        // Update the habit
        running.setDuration(45);
        habitLab.updateHabit(running);
        // Delete the habit
        habitLab.deleteDatabase();
    }
}
