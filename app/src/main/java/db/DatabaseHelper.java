package db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import db.ChurchContract.SermonEntry;
import db.ChurchContract.EventCategoryEntry;
import db.ChurchContract.EventsEntry;
import db.ChurchContract.SchedulesEntry;
import db.ChurchContract.SchedulePagesEntry;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "churchapp.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_SERMON_CREATE=
            "CREATE TABLE " + SermonEntry.TABLE_NAME + " (" +
                    SermonEntry._ID + " INTEGER PRIMARY KEY, " +
                    SermonEntry.COLUMN_SERMON_ID + " TEXT, " +
                    SermonEntry.COLUMN_SERMON_TITLE + " TEXT, " +
                    SermonEntry.COLUMN_SERMON_IMAGE_URL + " TEXT, " +
                    SermonEntry.COLUMN_SERMON_BRIEF_DESCRIPTION + " TEXT, " +
                    SermonEntry.COLUMN_SERMON_AUDIO_URL + " TEXT, " +
                    SermonEntry.COLUMN_SERMON_VIDEO_URL + " TEXT, " +
                    SermonEntry.COLUMN_SERMON_PDF_URL + " TEXT, " +
                    SermonEntry.COLUMN_SERMON_DATE + " TEXT, " +
                    SermonEntry.COLUMN_SERMON_VISIBLE + " TEXT, " +
                    SermonEntry.COLUMN_SERMON_CREATED_AT + " TEXT, " +
                    SermonEntry.COLUMN_SERMON_UPDATED_AT + " TEXT " +
                    ")";

    private static final String TABLE_EVENTCATEGORY_CREATE=
            "CREATE TABLE " + EventCategoryEntry.TABLE_NAME + " (" +
                    EventCategoryEntry._ID + " INTEGER PRIMARY KEY, " +
                    EventCategoryEntry.COLUMN_EVENT_CATEGORY_ID + " TEXT, " +
                    EventCategoryEntry.COLUMN__TITLE + " TEXT, " +
                    EventCategoryEntry.COLUMN_URL_KEY + " TEXT, " +
                    EventCategoryEntry.COLUMN_DESCRIPTION + " TEXT, " +
                    EventCategoryEntry.COLUMN_VISIBLE + " TEXT, " +
                    EventCategoryEntry.COLUMN_CREATED_AT + " TEXT, " +
                    EventCategoryEntry.COLUMN_UPDATED_AT + " TEXT " +
                    ")";

    private static final String TABLE_EVENT_CREATE=
            "CREATE TABLE " + EventsEntry.TABLE_NAME + " (" +
                    EventsEntry._ID + " INTEGER PRIMARY KEY, " +
                    EventsEntry.COLUMN_EVENT_ID + " TEXT, " +
                    EventsEntry.COLUMN_TITLE + " TEXT, " +
                    EventsEntry.COLUMN_IMAGE_URL + " TEXT, " +
                    EventsEntry.COLUMN_BRIEF_DESCRIPTION + " TEXT, " +
                    EventsEntry.COLUMN_CONTENT + " TEXT, " +
                    EventsEntry.COLUMN_EVENT_DATE + " TEXT, " +
                    EventsEntry.COLUMN_EVENT_LOCATION + " TEXT, " +
                    EventsEntry.COLUMN_EVENT_CATEGORY_ID + " TEXT, " +
                    EventsEntry.COLUMN_VISIBLE + " TEXT, " +
                    EventsEntry.COLUMN_CREATED_AT + " TEXT, " +
                    EventsEntry.COLUMN_UPDATED_AT + " TEXT " +
                    ")";

    private static final String TABLE_SCHEDULE_CREATE=
            "CREATE TABLE " + SchedulesEntry.TABLE_NAME + " (" +
                    SchedulesEntry._ID + " INTEGER PRIMARY KEY, " +
                    SchedulesEntry.COLUMN_SCHEDULE_ID + " TEXT, " +
                    SchedulesEntry.COLUMN_THEME_TITLE + " TEXT, " +
                    SchedulesEntry.COLUMN_THEME_DESCRIPTION + " TEXT, " +
                    SchedulesEntry.COLUMN_SUNDAY_DATE + " TEXT, " +
                    SchedulesEntry.COLUMN_COLUMN_COUNT + " TEXT, " +
                    SchedulesEntry.COLUMN_VISIBLE + " TEXT, " +
                    SchedulesEntry.COLUMN_CREATED_AT + " TEXT, " +
                    SchedulesEntry.COLUMN_UPDATED_AT + " TEXT " +
                    ")";

    private static final String TABLE_SCHEDULEPAGES_CREATE=
            "CREATE TABLE " + SchedulePagesEntry.TABLE_NAME + " (" +
                    SchedulePagesEntry._ID + " INTEGER PRIMARY KEY, " +
                    SchedulePagesEntry.COLUMN_SCHEDULE_PAGES_ID + " TEXT, " +
                    SchedulePagesEntry.COLUMN_PAGE_CONTENT + " TEXT, " +
                    SchedulePagesEntry.COLUMN_SUNDAY_SCHEDULE_ID + " TEXT, " +
                    SchedulePagesEntry.COLUMN_PAGE_ORDER + " TEXT, " +
                    SchedulePagesEntry.COLUMN_VISIBLE + " TEXT, " +
                    SchedulePagesEntry.COLUMN_CREATED_AT + " TEXT, " +
                    SchedulePagesEntry.COLUMN_UPDATED_AT + " TEXT " +
                    ")";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_SERMON_CREATE);
        db.execSQL(TABLE_EVENTCATEGORY_CREATE);
        db.execSQL(TABLE_EVENT_CREATE);
        db.execSQL(TABLE_SCHEDULE_CREATE);
        db.execSQL(TABLE_SCHEDULEPAGES_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SermonEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + EventCategoryEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + EventsEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SchedulesEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SchedulePagesEntry.TABLE_NAME);
    }
}
