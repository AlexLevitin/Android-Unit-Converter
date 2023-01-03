package com.example.androidunitconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class DistanceConversion extends AppCompatActivity {

    EditText inputDistance;
    Button convertDistance;
    TextView viewRes;
    RadioGroup radioGroup;
    RadioButton radioKM;
    RadioButton radioMiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance_conversion);
        inputDistance = (EditText)findViewById(R.id.DistanceInput);
        convertDistance = findViewById(R.id.ConvertDistance);
        viewRes = findViewById(R.id.ResDist);
        radioGroup = findViewById(R.id.Radio_Group_Distance);
        radioKM = findViewById(R.id.Radio_Button_KM);
        radioMiles = findViewById(R.id.Radio_Button_Miles);


        convertDistance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                int checkedId = radioGroup.getCheckedRadioButtonId();
                String input = inputDistance.getText().toString();
                if(input.equals("")) {
                    inputDistance.setError("Please Enter Distance");
                    Toast.makeText(DistanceConversion.this, "Please Enter Distance", Toast.LENGTH_SHORT).show();
                    viewRes.setText("");
                }
                else if(checkedId == radioKM.getId())
                    viewRes.setText("Value in Miles is: " + new DecimalFormat("##.##").format(ConversionKMtoMiles(inputDistance)));
                else
                    viewRes.setText("Value in KM is: " + new DecimalFormat("##.##").format(ConversionMilestoKM(inputDistance)));

            }
        });




    }
    public Double ConversionKMtoMiles(@NonNull EditText userInput)
    {
        Double x = Double.parseDouble(userInput.getText().toString());
        // if KG --> LBS
        x =  x * 0.621371;
        return x;
    }
    public Double ConversionMilestoKM(@NonNull EditText userInput)
    {
        Double x = Double.parseDouble(userInput.getText().toString());
        // if KG --> LBS
        x =  x / 0.621371;
        return x;
    }
}