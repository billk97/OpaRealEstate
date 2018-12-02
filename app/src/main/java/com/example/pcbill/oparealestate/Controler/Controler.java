package com.example.pcbill.oparealestate.Controler;

public class Controler {
    private String value1 ="0";
    private String value2 ="0";
    private String value3 ="0";
    public String checkData(String Type,String City,String StreetNumber,String StreetName, String PostNumber,String Date,String RoomNuber)
    {
        Type=CheckInput(Type);
        City=CheckInput(City);
        StreetNumber=CheckInput(StreetNumber);
        StreetName=CheckInput(StreetName);
        PostNumber=CheckInput(PostNumber);
        Date=CheckInput(Date);
        RoomNuber=CheckInput(RoomNuber);
        //call a function from dbhelper
        return "something was  replaced ";
    }
    private void bill(){}
    private void bill(int i){}
    private void bill(int i,int j){}
    private String CheckInput(String Input)
    {
        Input=Input.replaceAll("[^a-zA-Z0-9]","");
        return Input;
    }
    private void Type()
    {
        //calls a select function from helper
    }
    public String CheckSearchData(String city, String roomNumber)
    {
        CheckInput(city);
        CheckInput(roomNumber);
        return "";
        //Db.select(city,room,number,value1)
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
