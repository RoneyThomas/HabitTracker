package me.roneythomas.habittracker.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import me.roneythomas.habittracker.Habit;

/**
 * Created by roneythomas on 2016-07-22.
 */
public class HabitCursorWrapper extends CursorWrapper {

    public HabitCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Habit getHabit() {
        String title = getString(getColumnIndex(HabitSchema.HabitTable.Cols.TITLE));
        int duration = getInt(getColumnIndex(HabitSchema.HabitTable.Cols.DURATION));

        Habit habit = new Habit(title, duration);
        return habit;
    }
}
