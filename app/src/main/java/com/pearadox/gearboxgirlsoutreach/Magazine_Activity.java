package com.pearadox.gearboxgirlsoutreach;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class Magazine_Activity extends AppCompatActivity {
    String TAG = "Magazine_Activity";        // This CLASS name
   String num = " ";

    ImageView magPage;
    Button btn_Back, btn_Forward;
    private int[] magIssue1 = new int[] {
            R.drawable.ssv1_coverpage, R.drawable.ssv1_p00, R.drawable.ssv1_p01, R.drawable.ssv1_p02,R.drawable.ssv1_p03,
            R.drawable.ssv1_p04, R.drawable.ssv1_p05, R.drawable.ssv1_p06, R.drawable.ssv1_p07, R.drawable.ssv1_p08,
            R.drawable.ssv1_p09, R.drawable.ssv1_p10, R.drawable.ssv1_p11, R.drawable.ssv1_p12,
    };

    private int[] magIssue2 = new int[] {
            R.drawable.ssv2_coverpage, R.drawable.ssv2_p00, R.drawable.ssv2_p01, R.drawable.ssv2_p02,R.drawable.ssv2_p03,
            R.drawable.ssv2_p04, R.drawable.ssv2_p05, R.drawable.ssv2_p06, R.drawable.ssv2_p07, R.drawable.ssv2_p08,
            R.drawable.ssv2_p09, R.drawable.ssv2_p10, R.drawable.ssv2_p11, R.drawable.ssv2_p12, R.drawable.ssv2_p13, R.drawable.ssv2_p14,
    };
    String pg_2Display = "";
    int pg = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magazine);
        Log.i(TAG, "## Magazine_Activity  ##");
        Bundle bundle = this.getIntent().getExtras();
        num = (bundle.getString("iss"));
        Log.d(TAG, "Issue =  " + num);

        final ImageView magPage = (ImageView) findViewById(R.id.magPage);
        btn_Back = (Button) findViewById(R.id.btn_Back);
        btn_Forward = (Button) findViewById(R.id.btn_Forward);

//        final Spinner spinner_Issue = (Spinner) findViewById(R.id.spinner_Issue);
//        ArrayAdapter adapter_Issue = new ArrayAdapter<String>(this, R.layout.issue_list_layout, issue);
//        adapter_Issue.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner_Issue.setAdapter(adapter_Issue);
//        spinner_Issue.setSelection(0, false);
//        spinner_Issue.setOnItemSelectedListener(new Magazine_Activity.issue_listener());


        pg = 0;
        btn_Back.setEnabled(false);
        switch (num) {
            case "STEM Savvy V.1":
                pg_2Display = String.valueOf(magIssue1[pg]);
                magPage.setImageResource(getResources().getIdentifier(pg_2Display, "drawable", getPackageName()));
                break;
            case "STEM Savvy V.2":
                pg_2Display = String.valueOf(magIssue2[pg]);
                magPage.setImageResource(getResources().getIdentifier(pg_2Display, "drawable", getPackageName()));
                break;
            default:
                pg_2Display = String.valueOf(magIssue1[pg]);
                magPage.setImageResource(getResources().getIdentifier(pg_2Display, "drawable", getPackageName()));
                break;
        }


        // Start Listeners
// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        btn_Back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "@@@  btn_Back  @@@  " + pg);
                     if (pg > 0) {
                         pg--;
                     } else {
                         btn_Back.setEnabled(false);
                     }
                switch (num) {
                    case "STEM Savvy V.1":
                        pg_2Display = String.valueOf(magIssue1[pg]);
                        break;
                    case "STEM Savvy V.2":
                        pg_2Display = String.valueOf(magIssue2[pg]);
                        break;
                }
                magPage.setImageResource(getResources().getIdentifier(pg_2Display, "drawable", getPackageName()));
            }
        });

        btn_Forward.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "@@@  btn_Forward  @@@  " + pg);
                switch (num) {
                    case "STEM Savvy V.1":
                        if (pg < magIssue1.length - 1) {
                            pg++;
                        } else {
                            btn_Forward.setEnabled(false);
                        }
                        pg_2Display = String.valueOf(magIssue1[pg]);
                        break;
                    case "STEM Savvy V.2":
                        if (pg < magIssue2.length - 1) {
                            pg++;
                        } else {
                            btn_Forward.setEnabled(false);
                        }
                        pg_2Display = String.valueOf(magIssue2[pg]);
                        break;
                }
                magPage.setImageResource(getResources().getIdentifier(pg_2Display, "drawable", getPackageName()));
                btn_Back.setEnabled(true);
            }
        });

    }
    

}




