package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class settings extends AppCompatActivity implements View.OnClickListener{
    private FirebaseAuth firebaseauth;

View view;
Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        view =this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.pink);

        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        firebaseauth = FirebaseAuth.getInstance();
b1.setOnClickListener(this);
b2.setOnClickListener(this);
b3.setOnClickListener(this);
b4.setOnClickListener(this);
Intent k = getIntent();
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.button:
                i = new Intent(this, profile.class);
                break;
            case R.id.button2:
                i = new Intent(this,rating.class);
                break;
            case R.id.button3:
                i = new Intent(this,aboutus.class);
                break;
            case R.id.button4:
                i = new Intent(this, feedback.class);
                break;
            default:
                i = new Intent();


        }
        startActivity(i);
    }
    public  boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu , menu);
        return true;
    }
    private void Logout()
    {
        firebaseauth.signOut();
        finish();
        startActivity(new Intent(settings.this,MainActivity.class));
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.home: {
                Intent i = new Intent(this, MainActivity4.class);
                startActivity(i);
                break;
            }

            case R.id.mainmenu:
            {
                Intent i = new Intent(this, Main5Activity.class);
                startActivity(i);
                break;
            }
            case R.id.settingsMenu:
            {
                Intent i = new Intent(this, settings.class);
                startActivity(i);
                break;
            }
            case R.id.logoutMenu:
            {
                Logout();
            }


        }
        return super.onOptionsItemSelected(item);
    }
}
