package com.warda.anam.limkokreminder.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.warda.anam.limkokreminder.model.asm;
import com.warda.anam.limkokreminder.model.clas;
import com.warda.anam.limkokreminder.model.examsm;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
 
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "istudy3";
 
    // table name
    private static final String TABLE_EXAMS = "Test";
    private static final String TABLE_CLAS = "clas";
    private static final String TABLE_ASM = "homework";
 
    //Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_VENUE = "venue";
    private static final String KEY_DATE = "date";
    private static final String KEY_DAY = "day";
    private static final String KEY_TIME = "time";
    private static final String KEY_DD = "duedate";
    private static final String KEY_BO = "briefoverview";
    private static final String KEY_TITLE = "title";
    
    
 
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
       String CREATE_EXAMS_TABLE = "CREATE TABLE " + TABLE_EXAMS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_VENUE + " TEXT,"+ KEY_DATE + " TEXT,"+ KEY_TIME + " TEXT" + ")";
        db.execSQL(CREATE_EXAMS_TABLE);
        String CREATE_CLAS_TABLE = "CREATE TABLE " + TABLE_CLAS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_VENUE + " TEXT,"+ KEY_DAY + " TEXT,"+ KEY_TIME + " TEXT" + ")";
        db.execSQL(CREATE_CLAS_TABLE);
        String CREATE_ASM_TABLE = "CREATE TABLE " + TABLE_ASM + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_TITLE + " TEXT,"+ KEY_DD + " TEXT,"+ KEY_BO + " TEXT" + ")";
        db.execSQL(CREATE_ASM_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXAMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLAS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ASM);
 
        // Create tables again
        onCreate(db);
    }
 
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
 
    // Adding new
    public void addExam(examsm exam) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, exam.getName()); // Contact Name
        values.put(KEY_VENUE, exam.getVenue()); // Contact Phone
        values.put(KEY_DATE, exam.getDate()); // Contact Phone        
        values.put(KEY_TIME, exam.getTime()); // Contact Phone
        
 
        // Inserting Row
        
        db.insert(TABLE_EXAMS, null, values);
        db.close(); // Closing database connection
    }
    
    public void addClas(clas clas) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, clas.getName()); // Contact Name
        values.put(KEY_VENUE, clas.getVenue()); // Contact Phone
        values.put(KEY_DAY, clas.getDay()); // Contact Phone        
        values.put(KEY_TIME, clas.getTime()); // Contact Phone
        
 
        // Inserting Row
        
        db.insert(TABLE_CLAS, null, values);
        db.close(); // Closing database connection
    }
    
    public void addAsm(asm asm) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, asm.getName()); // Contact Name
        values.put(KEY_TITLE, asm.getTitle()); // Contact Phone
        values.put(KEY_DD, asm.getDd()); // Contact Phone        
        values.put(KEY_BO, asm.getBo()); // Contact Phone
        
 
        // Inserting Row
        
        db.insert(TABLE_ASM, null, values);
        db.close(); // Closing database connection
    }
 
 
    // Getting single 
    public examsm getExam(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_EXAMS, new String[] { KEY_ID,
                KEY_NAME, KEY_VENUE, KEY_DATE,KEY_TIME}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        examsm exam = new examsm(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        // return contact
        return exam;
    }
    
    public clas getClas(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_CLAS, new String[] { KEY_ID,
                KEY_NAME, KEY_VENUE, KEY_DAY,KEY_TIME}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        clas clas = new clas(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        // return contact
        return clas;
    }
    
    public asm getAsm(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_ASM, new String[] { KEY_ID,
                KEY_NAME, KEY_TITLE, KEY_DD,KEY_BO}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        asm asm = new asm(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        // return contact
        return asm;
    }
     
    // Getting All
    public List<examsm> getAllexams() {
        List<examsm> examslist = new ArrayList<examsm>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_EXAMS;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                examsm exam = new examsm();
                exam.setId(Integer.parseInt(cursor.getString(0)));
                exam.setName(cursor.getString(1));
                exam.setVenue(cursor.getString(2));
                exam.setDate(cursor.getString(3));
                exam.setTime(cursor.getString(4));
                // Adding contact to list
                examslist.add(exam);
            } while (cursor.moveToNext());
        }
 
        // return contact list
        return examslist;
    }
    
    
    public List<clas> getAllclas() {
        List<clas> claslist = new ArrayList<clas>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CLAS;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                clas clas = new clas();
                clas.setId(Integer.parseInt(cursor.getString(0)));
                clas.setName(cursor.getString(1));
                clas.setVenue(cursor.getString(2));
                clas.setDay(cursor.getString(3));
                clas.setTime(cursor.getString(4));
                // Adding contact to list
                claslist.add(clas);
            } while (cursor.moveToNext());
        }
 
        // return contact list
        return claslist;
    }
    
    public List<asm> getAllasm() {
        List<asm> asmlist = new ArrayList<asm>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ASM;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                asm asm = new asm();
                asm.setId(Integer.parseInt(cursor.getString(0)));
                asm.setName(cursor.getString(1));
                asm.setTitle(cursor.getString(2));
                asm.setDd(cursor.getString(3));
                asm.setBo(cursor.getString(4));
                // Adding contact to list
                asmlist.add(asm);
            } while (cursor.moveToNext());
        }
 
        // return contact list
        return asmlist;
    }
    
    // Updating single 
    public int updateExam(examsm exam) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, exam.getName()); // Contact Name
        values.put(KEY_VENUE, exam.getVenue()); // Contact Phone
        values.put(KEY_DATE, exam.getDate()); // Contact Phone        
        values.put(KEY_TIME, exam.getTime()); // Contact Phone
 
        // updating row
        return db.update(TABLE_EXAMS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(exam.getId()) });
    }
    
    public int updateClas(clas clas) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, clas.getName()); // Contact Name
        values.put(KEY_VENUE, clas.getVenue()); // Contact Phone
        values.put(KEY_DAY, clas.getDay()); // Contact Phone        
        values.put(KEY_TIME, clas.getTime()); // Contact Phone
 
        // updating row
        return db.update(TABLE_CLAS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(clas.getId()) });
    }
    
    public int updateAsm(asm asm) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, asm.getName()); // Contact Name
        values.put(KEY_TITLE, asm.getTitle()); // Contact Phone
        values.put(KEY_DD, asm.getDd()); // Contact Phone        
        values.put(KEY_BO, asm.getBo()); // Contact Phone
 
        // updating row
        return db.update(TABLE_ASM, values, KEY_ID + " = ?",
                new String[] { String.valueOf(asm.getId()) });
    }
 
    // Deleting single
    public void deleteExam(examsm exam) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_EXAMS, KEY_ID + " = ?",
                new String[] { String.valueOf(exam.getId()) });
        db.close();
    }
    
    
    public void deleteClas(clas clas) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CLAS, KEY_ID + " = ?",
                new String[] { String.valueOf(clas.getId()) });
        db.close();
    }
    
    public void deleteAsm(asm asm) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ASM, KEY_ID + " = ?",
                new String[] { String.valueOf(asm.getId()) });
        db.close();
    }
 
}