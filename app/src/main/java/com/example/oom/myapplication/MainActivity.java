package com.example.oom.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ImageButton imBtn1;
    ImageButton imBtn2;
    TextView textView_header;
    ArrayList arr_list;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imBtn1 = (ImageButton) findViewById(R.id.imBtn1);
        imBtn2 = (ImageButton) findViewById(R.id.imBtn2);
        textView_header = (TextView) findViewById(R.id.textView_header);

        toLoginActivity();
        toCreateToppic();
        toRead();
    }

    private void toRead() {
        textView_header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReadActivity.class);
                startActivity(intent);
            }
        });
    }

    private void toCreateToppic() {
        imBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CreateActivity.class);
                startActivity(intent);
            }
        });
    }

    private void toLoginActivity() {
        imBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });


    }

}
