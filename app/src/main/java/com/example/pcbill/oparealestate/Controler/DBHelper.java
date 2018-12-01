package com.example.pcbill.oparealestate.Controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class DBHelper
{
    public static Connection getConnection() throws Exception
    {
        try
        {
            String driver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";//this is a driver important
            /**this is the url where th database is usually located
             * the p3150085 is the name of the datapade
             * localhost is the path
             * 3306 id the default post */
            String url = "jdbc:sqlserver://195.251.248.152,22/p3150085";
            String username = "p3150085";
            String password = "Password";
            Class.forName(driver);
            /**trying to establish connection**/
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("SUCCESSFUL CONNECTION");
            return  connection;
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

    public static void CreateTable()throws Exception
    {
        getConnection();
        try
        {
            Connection connection = getConnection();
            PreparedStatement create = connection.prepareStatement("CREATE TABLE IF NOT EXISTS building(id int NOT NULL AUTOINCREMENT,first varchar(255), last varchar(255), PRIMARY KEY (ID))");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


}//end DBHelper