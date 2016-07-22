package me.roneythomas.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import me.roneythomas.habittracker.database.HabitCursorWrapper;
import me.roneythomas.habittracker.database.HabitDbHelper;
import me.roneythomas.habittracker.database.HabitSchema.HabitTable;

/**
 * Created by roneythomas on 2016-07-22.
 */
public class HabitLab {

    private static HabitLab mHabitLab;
    private SQLiteDatabase mDatabase;
    private Context mContext;

    private HabitLab(Context context) {
        mDatabase = new HabitDbHelper(context).getWritableDatabase();
        mContext = context;
    }

    public static HabitLab get(Context context) {
        if (mHabitLab == null) {
            return mHabitLab = new HabitLab(context);
        }
        return mHabitLab;
    }

    public void addHabit(Habit habit) {
        ContentValues values = getContentValues(habit);
        mDatabase.insert(HabitTable.NAME, null, values);
    }

    public Habit getHabit(String title) {
        HabitCursorWrapper cursor = queryHabit(HabitTable.Cols.TITLE + " = ?", new String[]{title});
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getHabit();
        } finally {
            cursor.close();
        }
    }

    public void updateHabit(Habit habit) {
        ContentValues values = getContentValues(habit);
        mDatabase.update(HabitTable.NAME, values, HabitTable.Cols.TITLE + " = ?", new String[]{habit.getTitle()});
    }

    public void deleteDatabase() {
        mDatabase.delete(HabitTable.NAME, null, null);
    }

    private ContentValues getContentValues(Habit habit) {
        ContentValues values = new ContentValues();
        values.put(HabitTable.Cols.TITLE, habit.getTitle());
        values.put(HabitTable.Cols.DURATION, habit.getDuration());
        return values;
    }

    private HabitCursorWrapper queryHabit(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                HabitTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
        return new HabitCursorWrapper(cursor);
    }
}
