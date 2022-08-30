package com.example.uiautomatortest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String TAG = "flo######";

    View mView;
    TextView xyView;
    Button initButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mView = findViewById(R.id.view);
        xyView = findViewById(R.id.coordinates);
        initButton = findViewById(R.id.init_button);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);

        // 현재 상태 텍스트 초기화
        initButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xyView.setText("");
            }
        });

        // 버튼1 클릭
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xyView.setText("버튼1 클릭됨");
            }
        });

        // 버튼2 클릭
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xyView.setText("버튼2 클릭됨");
            }
        });

        // 버튼3 클릭
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xyView.setText("버튼3 클릭됨");
            }
        });

        // 버튼4 클릭
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xyView.setText("버튼4 클릭됨");
            }
        });

        // 버튼5 클릭
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xyView.setText("버튼5 클릭됨");
            }
        });
    }
}