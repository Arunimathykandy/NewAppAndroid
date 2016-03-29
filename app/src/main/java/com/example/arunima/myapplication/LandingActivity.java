package com.example.arunima.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Arunima on 21-03-2016.
 */
public class LandingActivity extends AppCompatActivity {
    Button sign_btn;
    Button login_btn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);
        sign_btn = (Button)findViewById(R.id.signl_btn);
        login_btn = (Button)findViewById(R.id.logl_btn);

        /*sign_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(LandingActivity.this,SignUp.class);
                startActivity(intent1);

            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LandingActivity.this,Login.class);
                startActivity(intent);

            }
        });*/


    }
    public void loginClicked(View view) {

        Intent intent = new Intent(LandingActivity.this,Login.class);
        startActivity(intent);
    }
    public void signClicked(View view) {

        Intent i = new Intent(LandingActivity.this,SignUp.class);
        startActivity(i);
    }
}
