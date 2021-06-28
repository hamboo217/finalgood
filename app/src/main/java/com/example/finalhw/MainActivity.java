package com.example.finalhw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void btn_enteronclick(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,member.class);
        startActivity(intent);
    }

    public void btn_enter2onclick(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,member.class);
        startActivity(intent);
    }
}