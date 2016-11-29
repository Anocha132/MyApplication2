package com.example.oom.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by oom on 23/11/2559.
 */

public class CreateActivity extends Activity {

    Button btn_post;
    EditText edt_heading;
    EditText edt_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        btn_post = (Button) findViewById(R.id.btn_post);
        edt_heading = (EditText) findViewById(R.id.edt_heading);
        edt_content = (EditText) findViewById(R.id.edt_content);
        toPost();
    }

    private void toPost() {
        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                finish();
            }
        });
    }

}
