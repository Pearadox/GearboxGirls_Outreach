package com.pearadox.gearboxgirlsoutreach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class gg_Menu extends AppCompatActivity {
    String TAG = "gg_Menu";        // This CLASS name
    Button btn_Tutorials, btn_Quizzes, btn_Magazine, btn_Games;
    public static String[] issue  = new String []
            {" ", "STEM Savvy V.1", "STEM Savvy V.2"};

    String num = " ";
    String issueName = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gg__menu);
        Log.i(TAG, "## gg_Menu  ##");

        btn_Tutorials = (Button) findViewById(R.id.btn_Tutorials);
        btn_Quizzes = (Button) findViewById(R.id.btn_Quizzes);
        btn_Magazine = (Button) findViewById(R.id.btn_Magazine);
        btn_Games = (Button) findViewById(R.id.btn_Games);

        final Spinner spinner_Issue = (Spinner) findViewById(R.id.spinner_Issue);
        ArrayAdapter adapter_Issue = new ArrayAdapter<String>(this, R.layout.issue_list_layout, issue);
        adapter_Issue.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_Issue.setAdapter(adapter_Issue);
        spinner_Issue.setSelection(0, false);
        spinner_Issue.setOnItemSelectedListener(new issue_OnItemSelectedListner());


// Start Listeners
// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        btn_Magazine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "@@@ btn_Magazine  @@@ "  + issueName);

                Intent mag_intent = new Intent(gg_Menu.this, Magazine_Activity.class);
                Bundle issueNumber = new Bundle();
                issueNumber.putString("iss",issueName);
                mag_intent.putExtras(issueNumber);
                startActivity(mag_intent);        // Start the Magazine activity

            }
        });

    }

    public class issue_OnItemSelectedListner implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
            Log.d(TAG, "####  Issues Listner  ####  " + pos);
            num = adapterView.getItemAtPosition(pos).toString();
            issueName = issue[pos];
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
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
