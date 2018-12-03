package com.example.pcbill.oparealestate.DBmodel;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper
{
        public static final String TABLE_NAME= "building";
        public static final String ID="ID";
        public static final String TYPE= "";
        public static final String CITY= "";
        public static final String ADDRESS= "";
        public static final String ADDRESSNUMBER= "";
        public static final String TK= "";
        public static final String DATE= "";
        public static final String ROOMS= "";

    public DBHelper( Context context,String dbName,Integer version) {
        super(context, dbName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        tableCreateStatements(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersinon, int newVesion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    private void tableCreateStatements(SQLiteDatabase sqLiteDatabase) {
        try{
//            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_NAME +
//                    "("+ID + " INT  PRIMARY KEY AUTOINCREMENT, " +
//                    TYPE +" VARCHAR(255), " +
//                    CITY +" VARCHAR(255), "+
//                    ADDRESS +" VARCHAR(255), "+
//                    ADDRESSNUMBER+ " VARCHAR(255), "+
//                    TK+" VARCHAR(255), "+
//                    DATE+" VARCHAR(255), "+
//                    ROOMS+" VARCHAR(255), "+
//                    ")"
//                    );
        }catch (SQLException e)
        {e.printStackTrace();}
    }
    //public String Select(city,name,value1,value2,value3){}
    //public void Insert(type,city,adress,addressNumber,tk,hmerominia,ardomation);
}//end DBHelper