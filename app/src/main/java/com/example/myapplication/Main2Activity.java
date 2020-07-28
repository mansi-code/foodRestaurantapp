package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    private FirebaseAuth firebaseauth;
    Button b;
//THIS ACTIVITY IS NO LONGER USED
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
b= (Button)findViewById(R.id.btnhome);
        firebaseauth = FirebaseAuth.getInstance();
        b.setOnClickListener(this);
     }
    private void Logout()
    {
        firebaseauth.signOut();
        finish();
        startActivity(new Intent(Main2Activity.this,MainActivity.class));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.logoutMenu:{
                Logout();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, MainActivity4.class);
        startActivity(i);
    }
}


