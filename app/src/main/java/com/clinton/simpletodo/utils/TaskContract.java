package com.clinton.simpletodo.utils;


import android.provider.BaseColumns;

public final class TaskContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private TaskContract() {}

    /* Inner class that defines the table contents */
    public static class TaskEntry implements BaseColumns {
        public static final String TABLE_NAME = "tasks";
        public static final String COLUMN_NAME_TITLE = "task_text";
    }
}
