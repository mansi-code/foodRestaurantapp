package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Main5Activity extends AppCompatActivity {

    int totalamount = 0;
    StringBuilder result = new StringBuilder();
    ListView list;
    private FirebaseAuth firebaseauth;

    /* CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
    CheckBox[] checkbox={c1,c2,c3,c4,c5,c6,c7,c8,c9,c10} ;*/
    String[] maintitle ={
            "RajmaChawal","RajmaChawal",
            "CholeChawal","CholeChawal",
            "CholeBhature","Dosa","Idli Sambhar",
            "Chowmein","Spring Roll",
            "Pasta","Pav Bhaji"
    };

    String[] subtitle ={
            "(Half) 20 Rs.","(Full) 30 Rs.",
            "(Half) 20 Rs.","(Full) 30 Rs.",
            "25 Rs.", "35 Rs.","25 Rs.",
            "30 Rs.","25 Rs.",
            "(Full) 30 Rs.","30 Rs."

    };

    Integer[] imgid={
            R.drawable.image1,R.drawable.image2,
            R.drawable.image3,R.drawable.image4,
            R.drawable.image5,R.drawable.image6,R.drawable.image7,
            R.drawable.image8,R.drawable.image9,
            R.drawable.image10,R.drawable.image11
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        firebaseauth = FirebaseAuth.getInstance();
Intent i = getIntent();
        final MyListAdapter adapter=new MyListAdapter(this, maintitle, subtitle, imgid) {
        };
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                Intent i ;
                if(position == 0) {
                    //code specific to first list item
//TRYING ONLY FOR FIRST LIST RIGHT NOW , sending pos to second activity
                    i= new Intent(Main5Activity.this, Main6Activity.class);
                    i.putExtra("menu1",1);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),""+"RAJMA CHAWAL", Toast.LENGTH_SHORT).show();
                }

                else if(position == 1) {
                    //code specific to 2nd list item
                    i= new Intent(Main5Activity.this, Main6Activity.class);
                    i.putExtra("menu1",2);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),"RAJMA CHAWAL", Toast.LENGTH_SHORT).show();
                }

                else if(position == 2) {

                    i= new Intent(Main5Activity.this, Main6Activity.class);
                    i.putExtra("menu1",3);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),"CHOLE CHAWAL", Toast.LENGTH_SHORT).show();
                }
                else if(position == 3) {
                    i= new Intent(Main5Activity.this, Main6Activity.class);
                    i.putExtra("menu1",4);
                    startActivity(i);

                    Toast.makeText(getApplicationContext(),"CHOLE CHAWAL", Toast.LENGTH_SHORT).show();
                }
                else if(position == 4) {
                    i= new Intent(Main5Activity.this, Main6Activity.class);
                    i.putExtra("menu1",5);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),"CHOLE BHATURE", Toast.LENGTH_SHORT).show();
                }else if(position == 5) {
                    i= new Intent(Main5Activity.this, Main6Activity.class);
                    i.putExtra("menu1",6);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),"DOSA", Toast.LENGTH_SHORT).show();
                }else if(position == 6) {
                    i= new Intent(Main5Activity.this, Main6Activity.class);
                    i.putExtra("menu1",7);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),"IDLI SAMBHAR", Toast.LENGTH_SHORT).show();
                }else if(position == 7) {
                    i= new Intent(Main5Activity.this, Main6Activity.class);
                    i.putExtra("menu1",8);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),"CHOWMEIN", Toast.LENGTH_SHORT).show();
                }else if(position == 8) {
                    i= new Intent(Main5Activity.this, Main6Activity.class);
                    i.putExtra("menu1",9);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),"SPRING ROLL", Toast.LENGTH_SHORT).show();
                }else if(position == 9) {
                    i= new Intent(Main5Activity.this, Main6Activity.class);
                    i.putExtra("menu1",10);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),"PASTA ", Toast.LENGTH_SHORT).show();
                }else if(position == 10) {
                    i= new Intent(Main5Activity.this, Main6Activity.class);
                    i.putExtra("menu1",11);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),"PAV BHAJI", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
    private void Logout()
    {
        firebaseauth.signOut();
        finish();
        startActivity(new Intent(Main5Activity.this,MainActivity.class));
    }
    public  boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu , menu);
        return true;
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
            case R.id.logoutMenu:
            {
                Logout();
            }
            case R.id.settingsMenu:
            {
                Intent i = new Intent(this, settings.class);
                startActivity(i);
                break;
            }

        }
        return super.onOptionsItemSelected(item);
    }


}
