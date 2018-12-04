package com.example.pcbill.oparealestate.Controler;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.pcbill.oparealestate.DBmodel.DBHelper;

public class SaleControler {
    public String checkData(Context context,String Type, String City, String StreetNumber, String StreetName, String PostNumber, String Date, String RoomNuber)
    {
        Type=CheckInput(Type);
        City=CheckInput(City);
        StreetNumber=CheckInput(StreetNumber);
        StreetName=CheckInput(StreetName);
        PostNumber=CheckInput(PostNumber);
        Date=CheckInput(Date);
        RoomNuber=CheckInput(RoomNuber);
        //call a function from dbhelper
        DBHelper dbHelper = new DBHelper(context);
        dbHelper.Insert(Type, City,  StreetNumber,  StreetName,  PostNumber,  Date,  RoomNuber);
        return "something was  replaced ";
    }
    private String CheckInput(String Input)
    {
        Input=Input.replaceAll("[^a-zA-Z0-9]","");
        return Input;
    }
}
