package com.example.shabdkosh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddWordActivity extends AppCompatActivity {

    EditText et_addword,et_addmeaning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);
        et_addword=findViewById(R.id.et_addword);
        et_addmeaning=findViewById(R.id.et_addmeaning);
    }

    public void addword(View view) {
        if(et_addword.getText().toString().isEmpty()){
            et_addword.setError("Empty");
            et_addword.requestFocus();
        }
        else if(et_addmeaning.getText().toString().isEmpty()){
            et_addmeaning.setError("Empty");
            et_addmeaning.requestFocus();
        }
        else{
            DbManager dm= new DbManager();
            Connection con= dm.getCon(this);
            String word= et_addword.getText().toString().trim();
            String meaning= et_addmeaning.getText().toString().trim();
            String query= "insert into dict(word,meaning) values('"+word+"','"+meaning+"')";
            try {
                PreparedStatement ps= con.prepareStatement(query);
                ps.executeUpdate();
                Toast.makeText(this,"Word added",Toast.LENGTH_SHORT).show();
                et_addword.setText("");
                et_addmeaning.setText("");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    public void back(View view) {
        Intent I= new Intent(AddWordActivity.this,MainActivity.class);
        startActivity(I);
        finish();
    }
}