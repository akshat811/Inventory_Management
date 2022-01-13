package com.example.Inventory_Management.DBconn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
    public Statement databaseConnection() {
        Statement statement =null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(Constant.MAIN_URL+ Constant.DATABASE, Constant.USERNAME, Constant.PASSWORD);
            statement=con.createStatement();

        }catch(Exception e){ System.out.println(e);}

        return  statement;
    }
}

