package com.example.fullapplication.dashboard.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.fullapplication.R;

public class MainActivity extends AppCompatActivity {

    public static String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        TextView textView = findViewById(R.id.mainview);
//
//        SharedPreferences sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
//        String username = sharedPreferences.getString("username","");
//        String password = sharedPreferences.getString("password","");
//        textView.setText(String.format("Hello %s. Your password is %s", username, password));

    }
}