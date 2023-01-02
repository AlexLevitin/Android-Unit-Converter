package com.example.androidunitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button WeightBtn;
        Button DistanceBtn;
        WeightBtn = (Button)findViewById(R.id.WeightButton);
        DistanceBtn = (Button)findViewById(R.id.DistanceButton);
        WeightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, WeightConversion.class);
                startActivity(intent1);
            }
        });
        DistanceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, DistanceConversion.class);
                startActivity(intent2);
            }
        });
    }



}