package com.example.pcbill.oparealestate.Controler;

public class SaleControler {
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
    private String CheckInput(String Input)
    {
        Input=Input.replaceAll("[^a-zA-Z0-9]","");
        return Input;
    }
}
