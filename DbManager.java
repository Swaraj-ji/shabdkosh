package com.example.shabdkosh;

import android.content.Context;
import android.os.StrictMode;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {
    public Connection getCon(Context context){
        Connection con=null;
        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Class.forName("com.mysql.jdbc.Driver");   //Loading driver
            //connection between front and back.
            con= DriverManager.getConnection("jdbc:mysql://p3nlmysql51plsk.secureserver.net:3306/mmmut","mmmut","mmmut@123");
            //Toast.makeText(context,"Connection Done",Toast.LENGTH_SHORT).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }
}
