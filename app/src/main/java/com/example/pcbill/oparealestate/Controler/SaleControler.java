package com.example.pcbill.oparealestate.Controler;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.pcbill.oparealestate.DBmodel.DBHelper;

public class SaleControler {
    /**When this function is called
     * it checks the variables that has received for
     * Eny type of non wanted activity
     * calls an object DBHelper
     * which performs the actual Insert in the database**/
    public void checkData(Context context,String Type, String City, String StreetNumber, String StreetName, String PostNumber, String Date, String RoomNuber)
    {
        /**check ab=n corrects each variable**/
        Type=CheckInput(Type);
        City=CheckInput(City);
        StreetNumber=CheckInput(StreetNumber);
        StreetName=CheckInput(StreetName);
        PostNumber=CheckInput(PostNumber);
        Date=CheckInput(Date);
        RoomNuber=CheckInput(RoomNuber);
        //creation of dbhelper object()
        DBHelper dbHelper = new DBHelper(context);//context is something that android needs to get the current state
        /**the actual insert**/
        dbHelper.Insert(Type, City,  StreetNumber,  StreetName,  PostNumber,  Date,  RoomNuber);
    }
    /**this function checks for any actual malicious threat**/
    private String CheckInput(String Input)
    {
        /**it replaces every other character other than letter and numbers **/
        Input=Input.replaceAll("[^a-zA-Z0-9]","");
        return Input;
    }
}
