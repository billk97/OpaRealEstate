package com.example.pcbill.oparealestate.DBmodel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper
{
        private static final String TABLE_NAME= "building";
        private static final String ID="ID";
        private  static final String TYPE= "TYPE";
        private static final String CITY= "CITY";
        private static final  String ADDRESS= "ADDRESS";
        private static final String ADDRESSNUMBER= "ADDRESSNUMBER";
        private static final  String TK= "TK";
        private  static final String DATE= "DATE";
        private  static final String ROOMS= "ROOMS";

    public DBHelper( Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        tableCreateStatements(sqLiteDatabase);
        System.out.println("data added");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersinon, int newVesion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    private void tableCreateStatements(SQLiteDatabase sqLiteDatabase) {

            String sql = "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME + "(" +
                    ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, " +
                    TYPE +" TEXT, " +
                    CITY +" TEXT, "+
                    ADDRESS +" TEXT, "+
                    ADDRESSNUMBER+ " TEXT, "+
                    TK+" TEXT, "+
                    DATE+" TEXT, "+
                    ROOMS+" TEXT )";
            sqLiteDatabase.execSQL(sql);
            System.out.println("data added");

    }

    public boolean Insert(String type,String city,String adress,String addressNumber,String tk,String hmerominia,String ardomation)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TYPE,type);
        contentValues.put(CITY,city);
        contentValues.put(ADDRESS,adress);
        contentValues.put(ADDRESSNUMBER,addressNumber);
        contentValues.put(TK,tk);
        contentValues.put(DATE,hmerominia);
        contentValues.put(ROOMS,ardomation);
        long result = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
        {
            return false;
        }
        else
         {
                return true;
         }
    }

    public Cursor Select(String city, String roomNumber, String value1, String value2, String value3)
    {
        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + CITY +" = " + city + " AND " + ROOMS + " = " + roomNumber + " AND " + TYPE + " = " + value1 + " AND " + TYPE + " = " + value2 + " AND " + TYPE + " = " + value3;
        return sqLiteDatabase.rawQuery(sql,null);
    }
}//end DBHelper