package com.example.tashieventtrackerreal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

// This class handles the database operations for user login and registration
public class LoginActivity {
    private static final String DATABASE_NAME = "login.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "login";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

    private SQLiteDatabase database;
    private SQLiteOpenHelper dbHelper;

    public LoginActivity(Context context) {
        dbHelper = new SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
            @Override
            public void onCreate(SQLiteDatabase db) {
                String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_USERNAME + " TEXT, " +
                        COLUMN_PASSWORD + " TEXT)";
                db.execSQL(createTableQuery);
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
                onCreate(db);
            }
        };
        database = dbHelper.getWritableDatabase();
    }

    public boolean insertData(String username, String password) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERNAME, username);
        contentValues.put(COLUMN_PASSWORD, password);
        long result = database.insert(TABLE_NAME, null, contentValues);
        return result != -1; // Returns true if insertion was successful
    }

    public boolean checkUsername(String username) {
        Cursor cursor = database.query(TABLE_NAME,
                new String[]{COLUMN_USERNAME},
                COLUMN_USERNAME + "=?",
                new String[]{username},
                null, null, null);
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }

    public boolean checkLogin(String username, String password) {
        Cursor cursor = database.query(TABLE_NAME,
                new String[]{COLUMN_USERNAME},
                COLUMN_USERNAME + "=? AND " + COLUMN_PASSWORD + "=?",
                new String[]{username, password},
                null, null, null);
        boolean validLogin = cursor.getCount() > 0;
        cursor.close();
        return validLogin;
    }

    public void close() {
        if (database != null && database.isOpen()) {
            database.close();
        }
        if (dbHelper != null) {
            dbHelper.close();
        }
    }
    public void deleteUser(String username) {
        int rowsAffected = database.delete(TABLE_NAME, COLUMN_USERNAME + "=?", new String[]{username});
        if (rowsAffected > 0) {
            Log.d("logindatabase", "User deleted successfully");
        } else {
            Log.d("logindatabase", "No user found with the given username");
        }
    }



}
