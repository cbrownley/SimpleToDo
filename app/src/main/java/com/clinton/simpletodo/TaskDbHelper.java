package com.clinton.simpletodo;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class TaskDbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "com.clinton.simpletodo.db";
    public static final int DB_VERSION = 1;

    private static final String TEXT_TYPE = " TEXT";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TaskContract.TaskEntry.TABLE_NAME + " (" +
                    TaskContract.TaskEntry._ID + " INTEGER PRIMARY KEY," +
                    TaskContract.TaskEntry.COLUMN_NAME_TITLE + TEXT_TYPE + " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TaskContract.TaskEntry.TABLE_NAME;

    public TaskDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        //String createTable = "CREATE TABLE " + TaskContract.TaskEntry.TABLE + " ( " +
        //        TaskContract.TaskEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
        //        TaskContract.TaskEntry.COL_TASK_TITLE + " TEXT NOT NULL);";
        //
        //db.execSQL(createTable);
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS " + TaskContract.TaskEntry.TABLE);
        //onCreate(db);
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}