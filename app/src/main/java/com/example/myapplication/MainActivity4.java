package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener{
    Button b ;
    View view ;
    private FirebaseAuth firebaseauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        b= (Button)findViewById(R.id.Button);
        view =this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.pink);
        b.setOnClickListener(this);
        firebaseauth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, Main5Activity.class);

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
        startActivity(new Intent(MainActivity4.this,MainActivity.class));
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
