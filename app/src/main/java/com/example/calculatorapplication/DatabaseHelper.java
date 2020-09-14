package com.example.calculatorapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATA_BASE_NAME = "CalculatorApplication.db";
    public static final String TABLE_NAME = "Calculator";
    public static final String COL_0 = "ID";
    public static final String COL_1 = "INPUT";
    public static final String COL_2 = "OUTPUT";
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATA_BASE_NAME,null,10);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,INPUT TEXT,OUTPUT TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
       onCreate(db);
    }
    public boolean insert(String input,String output){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,input);
        contentValues.put(COL_2,output);
        long result = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return result != -1;
    }
    public Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.rawQuery("select * from "+TABLE_NAME,null);
    }
    public boolean updateData(String id,String input,String output){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_0,id);
        contentValues.put(COL_1,input);
        contentValues.put(COL_2,output);
        sqLiteDatabase.update(TABLE_NAME,contentValues,"ID = ?",new String[] {id});
        return true;
    }
    public Integer Delete(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME, "ID = ?", new String[]{id});
    }
}
