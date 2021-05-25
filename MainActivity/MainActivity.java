package com.example.shabdkosh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView actv_word;
    TextView tv_meaning;
    ArrayAdapter Ad;
    ArrayList<String> al= new ArrayList<String>();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    DbManager dm;
    String query;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actv_word= findViewById(R.id.actv_word);
        tv_meaning =findViewById(R.id.tv_meaning);
        dm= new DbManager();
        con=dm.getCon(this);
        query= "select word from dict";
        try {
            ps=con.prepareStatement(query);
            rs= ps.executeQuery();
            while(rs.next()){
                al.add(rs.getString("word"));
            }
            Ad= new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,al);
            actv_word.setAdapter(Ad);
            actv_word.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String word= Ad.getItem(position).toString();
                    query= "select meaning from dict where word='"+word+"'";
                    try {
                        ps= con.prepareStatement(query);
                        rs= ps.executeQuery();
                        if(rs.next()) tv_meaning.setText(rs.getString("meaning"));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                }
            });
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void loginform(View view) {
        Intent I =new Intent(MainActivity.this,LoginActivity.class);
        startActivity(I);
        finish();
    }
}