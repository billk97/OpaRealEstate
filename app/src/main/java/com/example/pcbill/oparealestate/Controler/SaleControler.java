package com.example.pcbill.oparealestate.Controler;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

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
        DBHelper dbHelper = new DBHelper(context);//context is something that android needs to get the current state
        /**the actual insert**/
        dbHelper.Insert(Type, City,  StreetNumber,  StreetName,  PostNumber,  Date,  RoomNuber);
    }
    /**this function checks for any actual malicious threat**/
    //todo filter empty input
    public  boolean CheckIsEmpty(Context context,String Type, String City, String StreetNumber, String StreetName, String PostNumber, String Date, String RoomNuber)
    {
        if(Type.isEmpty() || City.isEmpty()|| StreetNumber.isEmpty()||StreetName.isEmpty()||PostNumber.isEmpty()|| Date.isEmpty()|| RoomNuber.isEmpty())
        {
            Toast toast = Toast.makeText(context,"All fields  must be filled ",Toast.LENGTH_SHORT);
            toast.show();
            return true;
        }
        return false;
    }
    private String CheckInput(String Input)
    {
        /**it replaces every other character other than letter and numbers **/
        Input=Input.replaceAll("[^a-zA-Z0-9]","");
        return Input;
    }
}
