package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private  int count=5;
    private TextView userregistration;
    private FirebaseAuth firebaseauth;
    private ProgressDialog progressdialog;
    private TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=(EditText)findViewById(R.id.editText);
        Password=(EditText)findViewById(R.id.editText2);
        Info=(TextView)findViewById(R.id.textView);
        Login=(Button)findViewById(R.id.button);
        userregistration= (TextView)findViewById(R.id.textView4);
        forgotPassword = (TextView)findViewById(R.id.tvForgotPassword);

        Info.setText("NO OF ATTEMPTS REMAINING:5");
Intent i = getIntent();
        firebaseauth = FirebaseAuth.getInstance();
        progressdialog = new ProgressDialog(this);

        FirebaseUser user = firebaseauth.getCurrentUser();

        if(user!= null)
        {
            finish();
            startActivity(new Intent(MainActivity.this,MainActivity4.class));
        }

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });
        userregistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Main3Activity.class));
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PasswordActivity.class));
            }
        });

    }
    private void validate(String username, String userpassword)
    {
        progressdialog.setMessage("please wait!!loading!!!");
        progressdialog.show();

        firebaseauth.signInWithEmailAndPassword(username,userpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    progressdialog.dismiss();
                    Toast.makeText(MainActivity.this,"login successful",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,MainActivity4.class));
                }else{
                    Toast.makeText(MainActivity.this,"login failed",Toast.LENGTH_SHORT).show();
                    count--;
                    Info.setText("no of attempts remaining"+count);
                    progressdialog.dismiss();
                    if(count==0){
                        Login.setEnabled(false);
                    }
                }
            }
        });
    }
}
