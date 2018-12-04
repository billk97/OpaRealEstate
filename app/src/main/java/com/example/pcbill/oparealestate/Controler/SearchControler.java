package com.example.pcbill.oparealestate.Controler;

import android.content.Context;
import android.database.Cursor;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pcbill.oparealestate.DBmodel.Building;
import com.example.pcbill.oparealestate.DBmodel.DBHelper;

import java.util.ArrayList;

/**
 * Created by bill1 on 12/3/2018.
 */

public class SearchControler {
    private String value1 ="0";
    private String value2 ="0";
    private String value3 ="0";
    private Building building = new Building();
    private int count=0;
    private static ArrayList<String> SelecedData = new ArrayList<String>();
    public  void checkData(Context context,String city, String roomNumber)
    {
        city=CheckInput(city);
        roomNumber=CheckInput(roomNumber);
        //call a function select from the dbhelper
        DBHelper dbHelper = new DBHelper(context);
        Cursor cursor = dbHelper.SelectAll();
        String [] data = new String[200];
        int i=0;
        if(!cursor.moveToNext()){
            Toast.makeText(context, "There are no contacts to show", Toast.LENGTH_SHORT).show();
        }
        while(cursor.moveToNext()){
           SelecedData.add(count,cursor.getString(1) +" - "+
                   cursor.getString(2) +" - "+
                   cursor.getString(3) +" - "+
                   cursor.getString(4) +" - "+
                   cursor.getString(5) +" - "+
                   cursor.getString(6) +" - "+
                   cursor.getString(7) );
           count++;
        }
    }
    private String CheckInput(String Input)
    {
        Input=Input.replaceAll("[^a-zA-Z0-9]","");
        return Input;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }
    public  void setValue2(String value2)
    {
        this.value2 = value2;
    }
    public void setValue3(String value3)
    {
        this.value3 = value3;
    }

    public static ArrayList<String> getSelecedData() {
        return SelecedData;
    }
}
