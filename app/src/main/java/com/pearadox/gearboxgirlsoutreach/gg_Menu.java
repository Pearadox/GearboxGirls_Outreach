package com.pearadox.gearboxgirlsoutreach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class gg_Menu extends AppCompatActivity {
    String TAG = "gg_Menu";        // This CLASS name
    Button btn_Tutorials, btn_Quizzes, btn_Magazine, btn_Games;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gg__menu);
        Log.i(TAG, "## gg_Menu  ##");

        btn_Tutorials = (Button) findViewById(R.id.btn_Tutorials);
        btn_Quizzes = (Button) findViewById(R.id.btn_Quizzes);
        btn_Magazine = (Button) findViewById(R.id.btn_Magazine);
        btn_Games = (Button) findViewById(R.id.btn_Games);


// Start Listeners
// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        btn_Magazine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "@@@ btn_Magazine  @@@");

                Intent mag_intent = new Intent(gg_Menu.this, Magazine_Activity.class);
                startActivity(mag_intent);        // Start the Magazine activity

            }
        });

    }

//###################################################################
//###################################################################
//###################################################################
    @Override
    public void onStart() {
        super.onStart();
        Log.v(TAG, "onStart");

    }
    @Override
    public void onResume() {
        super.onResume();
        Log.v(TAG, "onResume");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v(TAG, "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "OnDestroy key-> ");
    }

}
