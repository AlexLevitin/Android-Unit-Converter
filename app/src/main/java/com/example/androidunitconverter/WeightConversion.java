package com.example.androidunitconverter;

import static java.lang.Integer.parseInt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class WeightConversion extends AppCompatActivity {

    EditText inputWeight;
    Button convertWeight;
    TextView viewRes;
    RadioGroup radioGroup;
    RadioButton radioKG;
    RadioButton radioLBS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_conversion);
        inputWeight = (EditText)findViewById(R.id.WeightInput);
        convertWeight = findViewById(R.id.ConvertWeight);
        viewRes = findViewById(R.id.Res);
        radioGroup = findViewById(R.id.Radio_Group_Weight);
        radioKG = findViewById(R.id.Radio_Button_KG);
        radioLBS = findViewById(R.id.Radio_Button_LBS);


        convertWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                int checkedId = radioGroup.getCheckedRadioButtonId();
                String input = inputWeight.getText().toString();
                if(input.equals("")) {
                    inputWeight.setError("Please Enter Weight");
                    Toast.makeText(WeightConversion.this, "Please Enter Weight", Toast.LENGTH_SHORT).show();
                    viewRes.setText("");
                }
                else if(checkedId == radioKG.getId())
                    viewRes.setText("Value in LBS is: " + new DecimalFormat("##.##").format(ConversionKgtoLbs(inputWeight)));
                else
                    viewRes.setText("Value in KG is: " + new DecimalFormat("##.##").format(ConversionLbstoKg(inputWeight)));

            }
        });




    }
    public Double ConversionKgtoLbs(@NonNull EditText userInput)
    {
        Double x = Double.parseDouble(userInput.getText().toString());
        // if KG --> LBS
        x =  x * 2.20462;
        return x;
    }
    public Double ConversionLbstoKg(@NonNull EditText userInput)
    {
        Double x = Double.parseDouble(userInput.getText().toString());
        // if KG --> LBS
        x =  x / 2.20462;
        return x;
    }
}