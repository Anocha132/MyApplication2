package com.example.oom.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by oom on 22/11/2559.
 */

public class RegisterActivity extends Activity {

    private TextView textView_email;
    private TextView textView_password;
    private TextView textView_firstname;
    private TextView textView_lastname;
    private TextView textView_username;
    private EditText edt_username;
    private EditText edt_email;
    private EditText edt_password;
    private EditText edt_firstname;
    private EditText edt_lastname;
    private Button btn3;
    private Button btn4;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textView_email = (TextView) findViewById(R.id.textView_email);
        textView_password = (TextView) findViewById(R.id.textView_password);
        textView_firstname = (TextView) findViewById(R.id.textView_firstname);
        textView_lastname = (TextView) findViewById(R.id.textView_lastname);
        textView_username = (TextView) findViewById(R.id.textView_username);
        edt_username = (EditText) findViewById(R.id.edt_username);
        edt_email = (EditText) findViewById(R.id.edt_email);
        edt_password = (EditText) findViewById(R.id.edt_password);
        edt_firstname = (EditText) findViewById(R.id.edt_firstname);
        edt_lastname = (EditText) findViewById(R.id.edt_lastname);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);

        buttonok();
        buttoncancel();

    }



    private void buttoncancel() {
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                finish();
            }
        });
    }

    private void buttonok() {
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database = FirebaseDatabase.getInstance();
                final DatabaseReference myRefUser = database.getReference("user");
                mAuth = FirebaseAuth.getInstance();

                final String uName = edt_username.getText().toString().trim();
                final String uEmail = edt_email.getText().toString().trim();
                final String uPass = edt_password.getText().toString().trim();
                final String uFirst = edt_firstname.getText().toString().trim();
                final String uLast = edt_lastname.getText().toString().trim();

                Log.d("uName", "" + uName);
                Log.d("uEmail", "" + uEmail);
                Log.d("uPass", "" + uPass);
                Log.d("uFirst", "" + uFirst);
                Log.d("uLast", "" + uLast);

                mAuth.createUserWithEmailAndPassword(uEmail, uPass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Log.d("Register", "Complete");
                                    String Userid = mAuth.getCurrentUser().getUid();
                                    myRefUser.child(Userid).child("name").setValue(uFirst);
                                    myRefUser.child(Userid).child("lastname").setValue(uLast);
                                    myRefUser.child(Userid).child("uName").setValue(uName);

                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    finish();
                                } else {
                                    Log.d("Register", "Error");
                                }
                            }
                        });

            }
        });
    }
}
