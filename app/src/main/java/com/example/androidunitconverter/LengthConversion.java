package com.example.androidunitconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.*;
import java.util.HashMap;

public class LengthConversion extends AppCompatActivity {

    EditText inputLength;
    Button convertLength;
    TextView viewRes;
    Spinner FromSpinner;
    Spinner ToSpinner;
    String[] FromString = {"mm", "cm", "m", "km"};
    Map<String, Double> myMap = new HashMap<String, Double>();

    public void setMyMap(Map<String, Double> myMap) {
       myMap.put("mm", 0.001);
       myMap.put("cm", 0.01);
       myMap.put("m", 1.0);
       myMap.put("km", 1000.0);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_conversion);
        inputLength = (EditText)findViewById(R.id.LengthInput);
        convertLength = findViewById(R.id.ConvertLength);
        viewRes = findViewById(R.id.ResLength);
        FromSpinner = (Spinner)findViewById(R.id.SpinnerFrom);
        ToSpinner = (Spinner)findViewById(R.id.SpinnerTo);
        //set array adapter for spinner
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,FromString);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        FromSpinner.setAdapter(aa);
        ToSpinner.setAdapter(aa);
        setMyMap(myMap);

        convertLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input = inputLength.getText().toString();
                if (input.equals("")) {
                    inputLength.setError("Please Enter Length");
                    Toast.makeText(LengthConversion.this, "Please Enter Length", Toast.LENGTH_SHORT).show();
                    viewRes.setText("");
                } else
                    viewRes.setText("Value of " + input + FromSpinner.getSelectedItem() + " to " + ToSpinner.getSelectedItem() + " is: " + new DecimalFormat("##.########").format(ConvertLength(inputLength)));


            }
        });
    }
    public double ConvertLength(@NonNull EditText userInput)
    {
        Double x = Double.parseDouble(userInput.getText().toString());
        return x*myMap.get(FromSpinner.getSelectedItem()) / myMap.get(ToSpinner.getSelectedItem()) ;
    }

}
