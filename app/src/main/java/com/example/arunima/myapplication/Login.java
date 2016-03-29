package com.example.arunima.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Arunima on 21-03-2016.
 */
public class Login extends AppCompatActivity {
    Button log_btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        log_btn = (Button)findViewById(R.id.log_btn);
        log_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Login.this,StoryBoardFirst.class);
                startActivity(myIntent);
            }
        });

    }
}
