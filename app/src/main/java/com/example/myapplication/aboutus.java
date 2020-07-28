package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class aboutus extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    String[] developers = { "see name ","MANSI JAIN", "PRIYANKA AGGARWAL", "PRIYA DAHIYA "};
    String[] describe = {" about us"," ROLL NUMBER : 5068"," ROLL NUMBER : 5030" , " ROLL NUMBER : 5047"};

    int flag=1;
    Button b ;
View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        view =this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.pink);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,developers);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);



    }






    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),describe[position] , Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


}
