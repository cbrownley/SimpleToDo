package com.clinton.simpletodo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class TaskDAO {

    private SQLiteDatabase db;
    private TaskDbHelper dbHelper;

    public TaskDAO(Context context) {
        dbHelper = new TaskDbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    // Close the db
    public void close() {
        db.close();
    }

    /**
     * Create new task object
     * @param taskText
     */
    public void createTask(String taskText) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("task", taskText);
        // Insert into DB
        db.insert("tasks", null, contentValues);
    }

    /**
     * Delete task object
     * @param taskId
     */
    public void deleteTask(int taskId) {
        // Delete from DB where id match
        db.delete("tasks", "_id = " + taskId, null);
    }

    /**
     * Get all Tasks.
     * @return
     */
    public List getTasks() {
        List taskList = new ArrayList();

        // Name of the columns we want to select
        String[] tableColumns = new String[] {"_id","task"};

        // Query the database
        Cursor cursor = db.query("tasks", tableColumns, null, null, null, null, null);
        cursor.moveToFirst();

        // Iterate the results
        while (!cursor.isAfterLast()) {
            Task task = new Task();
            // Take values from the DB
            task.setId(cursor.getInt(0));
            task.setText(cursor.getString(1));

            // Add to the DB
            taskList.add(task);

            // Move to the next result
            cursor.moveToNext();
        }

        return taskList;
    }

}