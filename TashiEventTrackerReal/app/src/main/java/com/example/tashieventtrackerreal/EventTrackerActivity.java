package com.example.tashieventtrackerreal;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

// This class handles the database operations for events
//pain and misery



public class EventTrackerActivity {
    private static final String DATABASE_NAME = "events.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "events";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_EVENT_NAME = "event_name";
    private static final String COLUMN_EVENT_DATE = "event_date";
    private static final String COLUMN_EVENT_LOCATION = "event_location";

    private SQLiteDatabase database;
    private SQLiteOpenHelper dbHelper;

    public long EventTracker(Context context) {
        dbHelper = new SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
            @Override
            public void onCreate(SQLiteDatabase db) {
                String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_EVENT_NAME + " TEXT, " +
                        COLUMN_EVENT_DATE + " TEXT, " +
                        COLUMN_EVENT_LOCATION + " TEXT)";
                db.execSQL(createTableQuery);
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
                onCreate(db);
            }
        };
        database = dbHelper.getWritableDatabase();

        //add, update, delete, and retrieve events??
        
        long addReminder (long String eventName, String byte[] eventDate;
        eventDate, String eventLocation){
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMN_EVENT_NAME, eventName);
            contentValues.put(COLUMN_EVENT_DATE, eventDate);
            contentValues.put(COLUMN_EVENT_LOCATION, eventLocation);
            return database.insert(TABLE_NAME, null, contentValues);
        }
        void updateReminder ( long id;
        eventName, String eventDate, String eventLocation){
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMN_EVENT_NAME, eventName);
            contentValues.put(COLUMN_EVENT_DATE, eventDate);
            contentValues.put(COLUMN_EVENT_LOCATION, eventLocation);
            database.update(TABLE_NAME, contentValues, COLUMN_ID + "=?", new String[]{String.valueOf(id)});
        }
        void deleteReminder ( long id){
            database.delete(TABLE_NAME, COLUMN_ID + "=?", new String[]{String.valueOf(id)});
        }
        Cursor getAllEvents () {
            return database.query(TABLE_NAME, null, null, null, null, null, null);
        }

    }
}
