package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main3Activity extends AppCompatActivity {
    private EditText username, userpassword, useremail;
    private Button b1;
    private TextView userlogin;
    private FirebaseAuth firebaseauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        username=(EditText)findViewById(R.id.editText3);
        userpassword=(EditText)findViewById(R.id.editText4);
        useremail=(EditText)findViewById(R.id.editText5);
        b1 =(Button) findViewById(R.id.button2);
        userlogin =(TextView)findViewById(R.id.textView3);

        firebaseauth = FirebaseAuth.getInstance();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    //upload to database
                    String user_email= useremail.getText().toString().trim();
                    String user_password = userpassword.getText().toString().trim();
                    firebaseauth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Main3Activity.this, "registration successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Main3Activity.this,MainActivity.class));
                            } else {
                                Toast.makeText(Main3Activity.this, "registration unsuccessful", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        userlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main3Activity.this,MainActivity.class));
            }
        });

    }
    private boolean validate()
    {
        Boolean result=false;
        String name=username.getText().toString();
        String password= userpassword.getText().toString();
        String email= useremail.getText().toString();
        if(name.isEmpty()|| password.isEmpty()||email.isEmpty())
        {
            Toast.makeText(this,"please enter all details  ",Toast.LENGTH_SHORT).show();
        }
        else
        {
            result=true;
        }
        return result;

    }
}
