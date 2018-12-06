package com.example.pcbill.oparealestate.Controler;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import com.example.pcbill.oparealestate.DBmodel.DBHelper;

import java.util.ArrayList;

/**
 * Created by bill1 on 12/3/2018.
 */

public class SearchControler {
    private String Fild ="0";
    private String Flat ="0";
    private String Building ="0";
    public static ArrayList<String> SelecedData = new ArrayList<String>();
    private static ArrayList<String> Test = new ArrayList<String>();
    /**When this function is called
     * it checks the variables that has received for
     * Eny type of non wanted activity
     * calls an object DBHelper
     * which performs the actual Insert in the database**/
    public  void checkData(Context context,String city, String roomNumber)
    {
        city=CheckInput(city);
        roomNumber=CheckInput(roomNumber);
        SelectAll(context);
        if(!Fild.equals("0")&&!Flat.equals("0")&&!Building.equals("0"))
        {
            Select3(context,city,roomNumber);
        }
        else if(!Fild.equals("0")&&!Flat.equals("0")&&Building.equals("0"))
        {
            Select2(context,city,roomNumber,Fild,Flat);
        }
        else if (!Fild.equals("0")&&Flat.equals("0")&&!Building.equals("0"))
        {
            Select2(context,city,roomNumber,Fild,Building);
        }
        else if (!Fild.equals("0")&&Flat.equals("0")&&Building.equals("0"))
        {
            Select1(context,city,roomNumber,Fild);
        }
        else if (Fild.equals("0")&&!Flat.equals("0")&&!Building.equals("0"))
        {
            Select2(context,city,roomNumber,Flat,Building);
        }
        else if (Fild.equals("0")&&!Flat.equals("0")&&Building.equals("0"))
        {
            Select1(context,city,roomNumber,Flat);
        }
        else if (Fild.equals("0")&&Flat.equals("0")&&!Building.equals("0"))
        {
            Select1(context,city,roomNumber,Building);
        }
        else if (Fild.equals("0")&&Flat.equals("0")&&Building.equals("0"))
        {
            Select3(context,city,roomNumber);
        }


    }
    //todo filter empty input
    /**this function checks for any actual malicious threat**/
    private String CheckInput(String Input)
    {
        /**it replaces every other character other than letter and numbers **/
        Input=Input.replaceAll("[^a-zA-Z0-9]","");
        return Input;
    }

    public void setField(String value1) {
        Fild = value1;
    }
    public  void setFlat(String value2)
    {
        Flat = value2;
    }
    public void setBuilding(String value3)
    {
        Building = value3;
    }

    public  ArrayList<String> getSelecedData() {

        return SelecedData;
    }

    public static ArrayList<String> getTest() {
        return Test;
    }

    public static void setTest(ArrayList<String> test) {
        Test = test;
    }

    private void SelectAll(Context context)
    {
        int count=0;
        DBHelper dbHelper = new DBHelper(context);
        /**its an interface which represents a 2 dimensional table of any database **/
        //todo insert legit data and do it in a function
//        dbHelper.Insert("Flat","athens","Smolika","35","10443","1.1.1997","3");
//        dbHelper.Insert("Flat","athens","derigni","22","10453","1.1.2000","2");
//        dbHelper.Insert("Flat","athens","kodriktonos","22","10453","1.1.2010","4");
//        dbHelper.Insert("Flat","patra","Smolika","35","10443","1.1.1997","3");
//        dbHelper.Insert("Flat","patra","derigni","22","10453","1.1.2000","2");
//        dbHelper.Insert("Flat","patra","kodriktonos","22","10453","1.1.2010","4");
//        dbHelper.Insert("Field","patra","kodriktonos","22","10453","1.1.2010","0");
//        dbHelper.Insert("Field","patra","derigni","22","10453","1.1.2010","0");
//        dbHelper.Insert("Field","athens","Smolika","22","10453","1.1.2010","0");
//        dbHelper.Insert("Field","athens","kodriktonos","22","10453","1.1.2010","0");
//        dbHelper.Insert("Field","athens","derigni","22","10453","1.1.2010","0");
//        dbHelper.Insert("Field","athens","Smolika","22","10453","1.1.2010","0");
//        dbHelper.Insert("building","athens","kodriktonos","22","10453","1.1.2010","20");
//        dbHelper.Insert("building","athens","derigni","22","10453","1.1.2010","30");
//        dbHelper.Insert("building","athens","Smolika","22","10453","1.1.2010","20");
        Cursor cursor = dbHelper.SelectAll();

        if(!cursor.moveToNext()){//checks if the is any other row left
            Toast.makeText(context, "There are no contacts to show", Toast.LENGTH_SHORT).show();
        }
        while(cursor.moveToNext()){//goes to the next column
            /**the actual insert
             * insert to the array list Selected data the result of the query **/
            Test.add(count,cursor.getString(1) +" - "+ //gets its column Type
                    cursor.getString(2) +" - "+//gets its column City
                    cursor.getString(3) +" - "+//gets its column Address
                    cursor.getString(4) +" - "+//gets its column Number
                    cursor.getString(5) +" - "+//gets its column tk
                    cursor.getString(6) +" - "+//gets its column date
                    cursor.getString(7) );     //gets its column arDom
            System.err.println("select all: " + Test.get(count));
            count++;
        }
    }//endSelect3
    private void Select3(Context context, String city,String roomNumber)
    {
        int count=0;
        DBHelper dbHelper = new DBHelper(context);
        /**its an interface which represents a 2 dimensional table of any database **/
        Cursor cursor = dbHelper.Select(city,roomNumber,"Flat","Field","building");
        if(!cursor.moveToNext()){//checks if the is any other row left
            Toast.makeText(context, "There are no contacts to show", Toast.LENGTH_SHORT).show();
        }
        while(cursor.moveToNext()){//goes to the next column
            /**the actual insert
             * insert to the array list Selected data the result of the query **/
            SelecedData.add(count,cursor.getString(1) +" - "+ //gets its column Type
                    cursor.getString(2) +" - "+//gets its column City
                    cursor.getString(3) +" - "+//gets its column Address
                    cursor.getString(4) +" - "+//gets its column Number
                    cursor.getString(5) +" - "+//gets its column tk
                    cursor.getString(6) +" - "+//gets its column date
                    cursor.getString(7) );     //gets its column arDom
            System.err.println("select 3: "+SelecedData.get(count));
            count++;
        }
    }//endSelect3
    private void Select2(Context context, String city,String roomNumber, String value1,String value2)
    {
        int count=0;
        DBHelper dbHelper = new DBHelper(context);
        /**its an interface which represents a 2 dimensional table of any database **/
        Cursor cursor = dbHelper.Select(city,roomNumber,value1,value2);
        if(!cursor.moveToNext()){//checks if the is any other row left
            Toast.makeText(context, "There are no contacts to show", Toast.LENGTH_SHORT).show();
        }
        while(cursor.moveToNext()){//goes to the next column
            /**the actual insert
             * insert to the array list Selected data the result of the query **/
            SelecedData.add(count,cursor.getString(1) +" - "+ //gets its column Type
                    cursor.getString(2) +" - "+//gets its column City
                    cursor.getString(3) +" - "+//gets its column Address
                    cursor.getString(4) +" - "+//gets its column Number
                    cursor.getString(5) +" - "+//gets its column tk
                    cursor.getString(6) +" - "+//gets its column date
                    cursor.getString(7) );     //gets its column arDom
            count++;
            System.err.println("select 2: "+ SelecedData.get(count));
        }
    }//endSelect2
    private void Select1(Context context, String city,String roomNumber, String value )
    {
        System.out.println(" city: "+ city);
        System.out.println(" roomNumber: "+ roomNumber);
        System.out.println(" value: "+ value);
        int count=1;
        DBHelper dbHelper = new DBHelper(context);
        /**its an interface which represents a 2 dimensional table of any database **/
        Cursor cursor = dbHelper.Select(city,roomNumber,value);
        if(!cursor.moveToNext()){//checks if the is any other row left
            Toast.makeText(context, "There are no contacts to show", Toast.LENGTH_SHORT).show();
        }
        SelecedData.add(0,cursor.getString(1) +" - "+ //gets its column Type
                cursor.getString(2) +" - "+//gets its column City
                cursor.getString(3) +" - "+//gets its column Address
                cursor.getString(4) +" - "+//gets its column Number
                cursor.getString(5) +" - "+//gets its column tk
                cursor.getString(6) +" - "+//gets its column date
                cursor.getString(7) );     //gets its column arDom
        while(cursor.moveToNext()){//goes to the next column
            /**the actual insert
             * insert to the array list Selected data the result of the query **/
            SelecedData.add(count,cursor.getString(1) +" - "+ //gets its column Type
                    cursor.getString(2) +" - "+//gets its column City
                    cursor.getString(3) +" - "+//gets its column Address
                    cursor.getString(4) +" - "+//gets its column Number
                    cursor.getString(5) +" - "+//gets its column tk
                    cursor.getString(6) +" - "+//gets its column date
                    cursor.getString(7) );     //gets its column arDom
            System.err.println( "select 1: "+SelecedData.get(count));
            count++;
        }
    }//endSelect1
}
