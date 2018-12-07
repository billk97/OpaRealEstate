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
        initializeData(context);
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
        Cursor cursor = dbHelper.SelectAll();

        if(!cursor.moveToNext()){//checks if the is any other row left
            Toast.makeText(context, "NO such building ", Toast.LENGTH_SHORT).show();
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
        int count=1;
        DBHelper dbHelper = new DBHelper(context);
        /**its an interface which represents a 2 dimensional table of any database **/
        Cursor cursor = dbHelper.Select(city,roomNumber,"Flat","Field","building");
        if(!cursor.moveToNext()){//checks if the is any other row left
            Toast.makeText(context, "There are no contacts to show", Toast.LENGTH_SHORT).show();
        }
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
    }//endSelect3
    private void Select2(Context context, String city,String roomNumber, String value1,String value2)
    {
        int count=1;
        DBHelper dbHelper = new DBHelper(context);
        /**its an interface which represents a 2 dimensional table of any database **/
        Cursor cursor = dbHelper.Select(city,roomNumber,value1,value2);
        if(!cursor.moveToNext()){//checks if the is any other row left
            Toast.makeText(context, "There are no contacts to show", Toast.LENGTH_SHORT).show();
        }
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
    }//endSelect1
    private void initializeData(Context context)
    {
        DBHelper dbHelper = new DBHelper(context);

        if (dbHelper.DbIsempty()==true)
        {

            /**its an interface which represents a 2 dimensional table of any database **/
            //todo insert legit data and do it in a function
            Cursor cursor = dbHelper.SelectAll();
            dbHelper.Insert("Flat","Athens","Lenorman","200","10443","2000","2");
            dbHelper.Insert("Flat","Athens","Vouliagmenis","200","10431","2000","2");
            dbHelper.Insert("Flat","Athens","Patision","200","10441","2000","2");
            dbHelper.Insert("Flat","Athens","Iera Odos","200","10432","2000","2");
            dbHelper.Insert("Flat","Athens","Konstantinoypolaios","200","10456","2000","2");
            dbHelper.Insert("Flat","Athens","Sygrou","200","10434","2000","2");
            dbHelper.Insert("Flat","Athens","Ermoy","200","10437","2000","3");
            dbHelper.Insert("Flat","Athens","Panepistimiou","200","10438","2000","3");
            dbHelper.Insert("Flat","Athens","Peireos","200","10439","2000","3");
            dbHelper.Insert("Flat","Athens","Benaki","200","10433","2000","3");
            dbHelper.Insert("Flat","Thesaloniki","Lenorman","200","10443","2001","2");
            dbHelper.Insert("Flat","Thesaloniki","Vouliagmenis","200","10431","2001","2");
            dbHelper.Insert("Flat","Thesaloniki","Patision","200","10441","2001","2");
            dbHelper.Insert("Flat","Thesaloniki","Iera Odos","200","10432","2001","2");
            dbHelper.Insert("Flat","Thesaloniki","Konstantinoypolaios","2001","10456","2000","2");
            dbHelper.Insert("Flat","Thesaloniki","Sygrou","200","10434","2001","2");
            dbHelper.Insert("Flat","Thesaloniki","Ermoy","200","10437","2001","3");
            dbHelper.Insert("Flat","Thesaloniki","Panepistimiou","200","10438","2001","3");
            dbHelper.Insert("Flat","Thesaloniki","Peireos","200","10439","2001","3");
            dbHelper.Insert("Flat","Thesaloniki","Benaki","200","10433","2001","3");
            dbHelper.Insert("Field","Thesaloniki","Lenorman","200","10443","2001","0");
            dbHelper.Insert("Field","Thesaloniki","Vouliagmenis","200","10431","2001","0");
            dbHelper.Insert("Field","Thesaloniki","Patision","200","10441","2001","0");
            dbHelper.Insert("Field","Thesaloniki","Iera Odos","200","10432","2001","0");
            dbHelper.Insert("Field","Thesaloniki","Konstantinoypolaios","2001","10456","2000","0");
            dbHelper.Insert("Field","Thesaloniki","Sygrou","200","10434","2001","0");
            dbHelper.Insert("Field","Thesaloniki","Ermoy","200","10437","2001","0");
            dbHelper.Insert("Field","Thesaloniki","Panepistimiou","200","10438","2001","0");
            dbHelper.Insert("Field","Thesaloniki","Peireos","200","10439","2001","0");
            dbHelper.Insert("Field","Thesaloniki","Benaki","200","10433","2001","0");
            dbHelper.Insert("building","Thesaloniki","Lenorman","200","10443","2001","15");
            dbHelper.Insert("building","Thesaloniki","Vouliagmenis","200","10431","2001","15");
            dbHelper.Insert("building","Thesaloniki","Patision","200","10441","2001","15");
            dbHelper.Insert("building","Thesaloniki","Iera Odos","200","10432","2001","15");
            dbHelper.Insert("building","Thesaloniki","Konstantinoypolaios","2001","10456","2000","7");
            dbHelper.Insert("building","Thesaloniki","Sygrou","200","10434","2001","17");
            dbHelper.Insert("building","Thesaloniki","Ermoy","200","10437","2001","18");
            dbHelper.Insert("building","Thesaloniki","Panepistimiou","200","10438","2001","10");
            dbHelper.Insert("building","Thesaloniki","Peireos","200","10439","2001","19");
            dbHelper.Insert("building","Thesaloniki","Benaki","200","10433","2001","10");
            dbHelper.Insert("building","Athens","Lenorman","200","10443","2000","16");
            dbHelper.Insert("building","Athens","Vouliagmenis","200","10431","2000","14");
            dbHelper.Insert("building","Athens","Patision","200","10441","2000","16");
            dbHelper.Insert("building","Athens","Iera Odos","200","10432","2000","16");
            dbHelper.Insert("building","Athens","Konstantinoypolaios","200","10456","2000","15");
            dbHelper.Insert("building","Athens","Sygrou","200","10434","2000","14");
            dbHelper.Insert("building","Athens","Ermoy","200","10437","2000","13");
            dbHelper.Insert("building","Athens","Panepistimiou","200","10438","2000","12");
            dbHelper.Insert("building","Athens","Peireos","200","10439","2000","12");
            dbHelper.Insert("building","Athens","Benaki","200","10433","2000","11");
            dbHelper.Insert("Flat","Patra","Lenorman","200","10443","2000","2");
            dbHelper.Insert("Flat","Patra","Vouliagmenis","200","10431","2000","2");
            dbHelper.Insert("Flat","Patra","Patision","200","10441","2000","2");
            dbHelper.Insert("Flat","Patra","Iera Odos","200","10432","2000","2");
            dbHelper.Insert("Flat","Patra","Konstantinoypolaios","200","10456","2000","2");
            dbHelper.Insert("Flat","Patra","Sygrou","200","10434","2000","2");
            dbHelper.Insert("Flat","Patra","Ermoy","200","10437","2000","3");
            dbHelper.Insert("Flat","Patra","Panepistimiou","200","10438","2000","3");
            dbHelper.Insert("Flat","Patra","Peireos","200","10439","2000","3");
            dbHelper.Insert("Flat","Patra","Benaki","200","10433","2000","3");
            dbHelper.Insert("Flat","Kefalonia","Lenorman","200","10443","2001","2");
            dbHelper.Insert("Flat","Kefalonia","Vouliagmenis","200","10431","2001","2");
            dbHelper.Insert("Flat","Kefalonia","Patision","200","10441","2001","2");
            dbHelper.Insert("Flat","Kefalonia","Iera Odos","200","10432","2001","2");
            dbHelper.Insert("Flat","Kefalonia","Konstantinoypolaios","2001","10456","2000","2");
            dbHelper.Insert("Flat","Kefalonia","Sygrou","200","10434","2001","2");
            dbHelper.Insert("Flat","Kefalonia","Ermoy","200","10437","2001","3");
            dbHelper.Insert("Flat","Kefalonia","Panepistimiou","200","10438","2001","3");
            dbHelper.Insert("Flat","Kefalonia","Peireos","200","10439","2001","3");
            dbHelper.Insert("Flat","Kefalonia","Benaki","200","10433","2001","3");
            dbHelper.Insert("Field","Kefalonia","Lenorman","200","10443","2001","0");
            dbHelper.Insert("Field","Kefalonia","Vouliagmenis","200","10431","2001","0");
            dbHelper.Insert("Field","Kefalonia","Patision","200","10441","2001","0");
            dbHelper.Insert("Field","Kefalonia","Iera Odos","200","10432","2001","0");
            dbHelper.Insert("Field","Kefalonia","Konstantinoypolaios","2001","10456","2000","0");
            dbHelper.Insert("Field","Kefalonia","Sygrou","200","10434","2001","0");
            dbHelper.Insert("Field","Kefalonia","Ermoy","200","10437","2001","0");
            dbHelper.Insert("Field","Kefalonia","Panepistimiou","200","10438","2001","0");
            dbHelper.Insert("Field","Kefalonia","Peireos","200","10439","2001","0");
            dbHelper.Insert("Field","Kefalonia","Benaki","200","10433","2001","0");
            dbHelper.Insert("building","Kefalonia","Lenorman","200","10443","2001","15");
            dbHelper.Insert("building","Kefalonia","Vouliagmenis","200","10431","2001","15");
            dbHelper.Insert("building","Kefalonia","Patision","200","10441","2001","15");
            dbHelper.Insert("building","Kefalonia","Iera Odos","200","10432","2001","15");
            dbHelper.Insert("building","Kefalonia","Konstantinoypolaios","2001","10456","2000","7");
            dbHelper.Insert("building","Kefalonia","Sygrou","200","10434","2001","17");
            dbHelper.Insert("building","Kefalonia","Ermoy","200","10437","2001","18");
            dbHelper.Insert("building","Kefalonia","Panepistimiou","200","10438","2001","10");
            dbHelper.Insert("building","Kefalonia","Peireos","200","10439","2001","19");
            dbHelper.Insert("building","Kefalonia","Benaki","200","10433","2001","10");
            dbHelper.Insert("building","Patra","Lenorman","200","10443","2000","16");
            dbHelper.Insert("building","Patra","Vouliagmenis","200","10431","2000","14");
            dbHelper.Insert("building","Patra","Patision","200","10441","2000","16");
            dbHelper.Insert("building","Patra","Iera Odos","200","10432","2000","16");
            dbHelper.Insert("building","Patra","Konstantinoypolaios","200","10456","2000","15");
            dbHelper.Insert("building","Patra","Sygrou","200","10434","2000","14");
            dbHelper.Insert("building","Patra","Ermoy","200","10437","2000","13");
            dbHelper.Insert("building","Patra","Panepistimiou","200","10438","2000","12");
            dbHelper.Insert("building","Patra","Peireos","200","10439","2000","12");
            dbHelper.Insert("building","Patra","Benaki","200","10433","2000","11");

        }
    }
}
