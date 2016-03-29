package com.example.arunima.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Arunima on 21-03-2016.
 */
public class SignUp extends AppCompatActivity {
    Button sign_btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_layout);
        sign_btn = (Button) findViewById(R.id.sign_btn);
        sign_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUp.this, StoryBoardFirst.class);
                startActivity(i);

            }
        });
    }
}
