package com.pearadox.gearboxgirlsoutreach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Magazine_Activity extends AppCompatActivity {
    String TAG = "Magazine_Activity";        // This CLASS name
    ImageView magPage;
    Button btn_Back, btn_Forward;
    private int[] magImages = new int[] {
            R.drawable.ssv1_coverpage, R.drawable.ssv1_p00, R.drawable.ssv1_p01, R.drawable.ssv1_p02,R.drawable.ssv1_p03,
            R.drawable.ssv1_p04, R.drawable.ssv1_p05, R.drawable.ssv1_p06, R.drawable.ssv1_p07, R.drawable.ssv1_p08,
            R.drawable.ssv1_p09, R.drawable.ssv1_p10, R.drawable.ssv1_p11, R.drawable.ssv1_p12,
    };
    String pg_2Display = "";
    int pg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magazine);
        Log.i(TAG, "## Magazine_Activity  ##");

        final ImageView magPage = (ImageView) findViewById(R.id.magPage);
        btn_Back = (Button) findViewById(R.id.btn_Back);
        btn_Forward = (Button) findViewById(R.id.btn_Forward);

        pg = 0;
        pg_2Display = String.valueOf(magImages[pg]);
        magPage.setImageResource(getResources().getIdentifier(pg_2Display, "drawable", getPackageName()));
        btn_Back.setEnabled(false);

        // Start Listeners
// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        btn_Back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "@@@  btn_Back  @@@  " + pg);
                if (pg > 0) {
                    pg --;
                } else {
                    btn_Back.setEnabled(false);
                }
                pg_2Display = String.valueOf(magImages[pg]);
                magPage.setImageResource(getResources().getIdentifier(pg_2Display, "drawable", getPackageName()));
            }
        });

        btn_Forward.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "@@@  btn_Forward  @@@  " + pg);
                if (pg < magImages.length-1) {
                    pg ++;
                } else {
                    btn_Forward.setEnabled(false);
                }
                pg_2Display = String.valueOf(magImages[pg]);
                magPage.setImageResource(getResources().getIdentifier(pg_2Display, "drawable", getPackageName()));
                btn_Back.setEnabled(true);
            }
        });
    }



}
