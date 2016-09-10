package com.example.py.project17;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    private final static String SharedPreferencesFileName = "config";
    private final static String Key_Name = "Name";
    private final static String Key_ID = "ID";

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(SharedPreferencesFileName, MODE_PRIVATE);
        editor = preferences.edit();

        Button btnWrite = (Button) findViewById(R.id.ButtonWrite);
        Button btnRead = (Button) findViewById(R.id.ButtonRead);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putString(Key_Name, "唐伟东");
                editor.putString(Key_ID, "2014012726");

                editor.apply();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strName = preferences.getString(Key_Name, null);
                String nID = preferences.getString(Key_ID, null);
                if (strName != null && nID != null)
                    Toast.makeText(MainActivity.this, "学生姓名:" + strName + ";" + "学号:" + nID, Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "无数据", Toast.LENGTH_LONG).show();
            }
        });
    }
}