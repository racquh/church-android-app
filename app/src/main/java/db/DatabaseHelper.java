package db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import db.ChurchContract.BibleBookEntry;
import db.ChurchContract.BibleChapterEntry;
import db.ChurchContract.BibleVerseEntry;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "churchapp.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_BIBLE_BOOK_CREATE=
            "CREATE TABLE " + BibleBookEntry.TABLE_NAME + " (" +
                    BibleBookEntry._ID + " INTEGER PRIMARY KEY, " +
                    BibleBookEntry.COLUMN_BIBLE_BOOK_VERSION + " TEXT, " +
                    BibleBookEntry.COLUMN_BIBLE_BOOK_CODE + " TEXT, " +
                    BibleBookEntry.COLUMN_BIBLE_BOOK_NUMBER + " TEXT, " +
                    BibleBookEntry.COLUMN_BIBLE_BOOK_NAME + " TEXT " +
                    ")";

    private static final String TABLE_BIBLE_CHAPTER_CREATE=
            "CREATE TABLE " + BibleChapterEntry.TABLE_NAME + " (" +
                    BibleChapterEntry._ID + " INTEGER PRIMARY KEY, " +
                    BibleChapterEntry.COLUMN_CHAPTER_NUMBER + " TEXT, " +
                    BibleChapterEntry.COLUMN_CHAPTER_BOOK_CODE + " TEXT, " +
                    BibleChapterEntry.COLUMN_CHAPTER_CODE + " TEXT " +
                    ")";

    private static final String TABLE_BIBLE_VERSE_CREATE=
            "CREATE TABLE " + BibleVerseEntry.TABLE_NAME + " (" +
                    BibleVerseEntry._ID + " INTEGER PRIMARY KEY, " +
                    BibleVerseEntry.COLUMN_VERSE_NUMBER + " TEXT, " +
                    BibleVerseEntry.COLUMN_VERSE_CHAPTER_CODE + " TEXT, " +
                    BibleVerseEntry.COLUMN_VERSE + " TEXT " +
                    ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_BIBLE_BOOK_CREATE);
        db.execSQL(TABLE_BIBLE_CHAPTER_CREATE);
        db.execSQL(TABLE_BIBLE_VERSE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BibleBookEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + BibleChapterEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + BibleVerseEntry.TABLE_NAME);
    }
}
