package com.example.pcbill.oparealestate.Controler;

/**
 * Created by bill1 on 12/3/2018.
 */

public class SearchControler {
    private String value1 ="0";
    private String value2 ="0";
    private String value3 ="0";
    public void checkData(String city, String roomNumber)
    {
        city=CheckInput(city);
        roomNumber=CheckInput(roomNumber);
        //call a function select from the dbhelper
        //Db.select(city,room,number,value1,value2,value3)
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
}
