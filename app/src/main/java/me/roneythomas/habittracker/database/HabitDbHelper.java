package me.roneythomas.habittracker.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import me.roneythomas.habittracker.database.HabitSchema.HabitTable;

/**
 * Created by roneythomas on 2016-07-22.
 */
public class HabitDbHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "habit.db";
    private static int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + HabitTable.NAME + "(" +
                "id integer primary key autoincrement, " +
                HabitTable.Cols.TITLE + ", " +
                HabitTable.Cols.DURATION + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + HabitTable.NAME);
        onCreate(db);
    }
}
