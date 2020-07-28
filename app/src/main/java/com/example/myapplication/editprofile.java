package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class editprofile extends AppCompatActivity implements View.OnClickListener {

    EditText e2, e3, e4, e;
    Button b1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editprofile);
        e4 = (EditText) findViewById(R.id.editText4);
        e3 = (EditText) findViewById(R.id.editText3);
        e2 = (EditText) findViewById(R.id.editText2);
        e = (EditText) findViewById(R.id.editText);
        b1 = (Button) findViewById(R.id.button2);
        b1.setOnClickListener(this);
Intent i = getIntent();

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent();
        i.putExtra("name", e4.getText().toString());
        i.putExtra("phone", e3.getText().toString());
        i.putExtra("location", e2.getText().toString());
        i.putExtra("description", e.getText().toString());
        setResult(123, i);
finish();

    }



}


