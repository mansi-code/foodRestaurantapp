package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class feedback extends AppCompatActivity implements View.OnClickListener{
    Button b1, b2, b3;
View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);
        view =this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.pink);
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i ;
        switch(v.getId())
        {
            case R.id.button3:
                i= new Intent();
                i.setAction(Intent.ACTION_SEND);
                i.setType("text/plain");
                startActivity(Intent.createChooser(i,"SEND WITH"));
                break;
            case R.id.button:
                         i= new Intent();
                         i.setAction(Intent.ACTION_DIAL);

                         startActivity(Intent.createChooser(i,"CALL WITH"));
                         break;
            case R.id.button2:
                i= new Intent();
                i.setAction(Intent.ACTION_WEB_SEARCH);
               // i.setType("text/url");
                startActivity(Intent.createChooser(i,"SEARCH WEB WITH"));
                break;
                default:
                    i= new Intent();

        }



    }
}
