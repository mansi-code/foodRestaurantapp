package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class profile extends AppCompatActivity implements View.OnClickListener{

    TextView t2,t4,t6,t8;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        t4 = (TextView)findViewById(R.id.textView4);
        t2 = (TextView)findViewById(R.id.loc);
        t6 = (TextView)findViewById(R.id.phn);
        t8 = (TextView)findViewById(R.id.textView8);
        b= (Button)findViewById(R.id.button);
        b.setOnClickListener(this);
        Intent m = getIntent();

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, editprofile.class);
        startActivityForResult(i,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        t4.setText(data.getStringExtra("name"));
        t6.setText(data.getStringExtra("phone"));
        t2.setText(data.getStringExtra("location"));
        t8.setText(data.getStringExtra("description"));
    }
}




