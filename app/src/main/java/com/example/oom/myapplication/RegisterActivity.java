package com.example.oom.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by oom on 22/11/2559.
 */

public class RegisterActivity extends Activity {

    private TextView textView_username;
    private TextView textView_password;
    private TextView textView_firstname;
    private TextView textView_lastname;
    private EditText edt_username;
    private EditText edt_password;
    private EditText edt_firstname;
    private EditText edt_lastname;
    private Button btn3;
    private Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textView_username = (TextView) findViewById(R.id.textView_username);
        textView_password = (TextView) findViewById(R.id.textView_password);
        textView_firstname = (TextView) findViewById(R.id.textView_firstname);
        textView_lastname = (TextView) findViewById(R.id.textView_lastname);
        edt_username = (EditText) findViewById(R.id.edt_username);
        edt_username = (EditText) findViewById(R.id.edt_password);
        edt_username = (EditText) findViewById(R.id.edt_firstname);
        edt_username = (EditText) findViewById(R.id.edt_lastname);
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
                finish();
            }
        });
    }
}
