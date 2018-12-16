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
    private Boolean Empty = false;
    public static ArrayList<String> SelecedData = new ArrayList<String>();
    private static ArrayList<String> Test = new ArrayList<String>();
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

    public Boolean getEmpty() {
        return Empty;
    }

    public void setEmpty(Boolean empty) {
        Empty = empty;
    }

    /**When this function is called
     * it checks the variables that has received for
     * Eny type of non wanted activity
     * calls an object DBHelper
     * which performs the actual Insert in the database**/
    public  void checkData(Context context,String city, String roomNumber)
    {
        if(CheckIsEmpty( context, city, roomNumber)==false)
        {
            city=CheckInput(city);
            roomNumber=CheckInput(roomNumber);
            if(!Fild.equals("0")&&!Flat.equals("0")&&!Building.equals("0"))
            {
                Select3(context,city,roomNumber);
            }

            else if(!Fild.equals("0")&&!Flat.equals("0")&&Building.equals("0"))
            {
                Select2(context,city,roomNumber,"Field","Flat");
                System.out.println("1");
            }
            else if (!Fild.equals("0")&&Flat.equals("0")&&!Building.equals("0"))
            {
                Select2(context,city,roomNumber,"Field","building");
                System.out.println("2");
            }
            else if (!Fild.equals("0")&&Flat.equals("0")&&Building.equals("0"))
            {
                Select1(context,city,roomNumber,Fild);
            }
            else if (Fild.equals("0")&&!Flat.equals("0")&&!Building.equals("0"))
            {
                Select2(context,city,roomNumber,"Flat","building");
                System.out.println("3");
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
            Toast toast = Toast.makeText(context,"Searching",Toast.LENGTH_SHORT);
            toast.show();
        }


    }
    public  boolean CheckIsEmpty(Context context, String City, String RoomNuber)
    {
        if( City.isEmpty()|| RoomNuber.isEmpty())
        {
            Toast toast = Toast.makeText(context,"All fields  must be filled ",Toast.LENGTH_SHORT);
            toast.show();
            return true;
        }
        return false;
    }

    //todo filter empty input
    /**this function checks for any actual malicious threat**/
    private String CheckInput(String Input)
    {
        /**it replaces every other character other than letter and numbers **/
        Input=Input.replaceAll("[^a-zA-Z0-9]","");
        return Input;
    }



    public  ArrayList<String> getSelecedData() {

        return SelecedData;
    }

    public static ArrayList<String> getTest() {
        return Test;
    }

    private void Select3(Context context, String city,String roomNumber)
    {
        int count=1;
        DBHelper dbHelper = new DBHelper(context);
        /**its an interface which represents a 2 dimensional table of any database **/
        Cursor cursor = dbHelper.Select(city,roomNumber,"Flat","Field","building");
        if(!cursor.moveToNext()){//checks if the is any other row left
            Toast.makeText(context, "NO such building3 ", Toast.LENGTH_SHORT).show();
            setEmpty(true);
        }
        else
        {
            if(cursor.isFirst())
            {
                SelecedData.add(0,cursor.getString(1) +" - "+ //gets its column Type
                        cursor.getString(2) +" - "+//gets its column City
                        cursor.getString(3) +" - "+//gets its column Address
                        cursor.getString(4) +" - "+//gets its column Number
                        cursor.getString(5) +" - "+//gets its column tk
                        cursor.getString(6) +" - "+//gets its column date
                        cursor.getString(7) );     //gets its column arDom
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
        }
    }//endSelect3
    private void Select2(Context context, String city,String roomNumber, String value1,String value2)
    {
        int count=1;
        DBHelper dbHelper = new DBHelper(context);
        /**its an interface which represents a 2 dimensional table of any database **/
        Cursor cursor = dbHelper.Select(city,roomNumber,value1,value2);
        if(!cursor.moveToNext()){//checks if the is any other row left
            Toast.makeText(context, "NO such building2", Toast.LENGTH_SHORT).show();
            setEmpty(true);
        }
        else
        {
            if(cursor.isFirst())
            {
                SelecedData.add(0,cursor.getString(1) +" - "+ //gets its column Type
                        cursor.getString(2) +" - "+//gets its column City
                        cursor.getString(3) +" - "+//gets its column Address
                        cursor.getString(4) +" - "+//gets its column Number
                        cursor.getString(5) +" - "+//gets its column tk
                        cursor.getString(6) +" - "+//gets its column date
                        cursor.getString(7) );     //gets its column arDom
                System.err.println("select 2: "+ SelecedData.get(0));
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
                System.err.println("select 2: "+ SelecedData.get(count));
                count++;

            }
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
            Toast.makeText(context, "NO such building1", Toast.LENGTH_SHORT).show();
            setEmpty(true);
        }
        else
        {
            if(cursor.isFirst())
            {
                SelecedData.add(0,cursor.getString(1) +" - "+ //gets its column Type
                        cursor.getString(2) +" - "+//gets its column City
                        cursor.getString(3) +" - "+//gets its column Address
                        cursor.getString(4) +" - "+//gets its column Number
                        cursor.getString(5) +" - "+//gets its column tk
                        cursor.getString(6) +" - "+//gets its column date
                        cursor.getString(7) );     //gets its column arDom
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
                System.err.println( "select 1: "+SelecedData.get(count));
                count++;
            }
        }

    }//endSelect1
}
