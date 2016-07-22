package me.roneythomas.habittracker.database;

/**
 * Created by roneythomas on 2016-07-22.
 */
public class HabitSchema {

    public static final class HabitTable {
        // Table Name
        public static final String NAME = "habits";

        // Columns
        public static final class Cols {
            public static final String TITLE = "title";
            public static final String DURATION = "duration";
        }
    }
}
