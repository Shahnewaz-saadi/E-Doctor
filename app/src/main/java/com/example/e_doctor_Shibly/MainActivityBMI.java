package com.example.e_doctor_Shibly;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityBMI extends AppCompatActivity {
    private EditText weightEditText, heightEditText;
    private Button calculateButton;
    private TextView bmiTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bmi);
        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);
        calculateButton = findViewById(R.id.calculateButton);
        bmiTextView = findViewById(R.id.bmiTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    @SuppressLint("DefaultLocale")
    private void calculateBMI() {
        String weightString = weightEditText.getText().toString();
        String heightString = heightEditText.getText().toString();

        if (weightString.isEmpty() || heightString.isEmpty()) {
            bmiTextView.setText("Please enter weight and height");
            return;
        }

        float weight = Float.parseFloat(weightString);
        float height = Float.parseFloat(heightString) / 100; // convert height to meters

        float bmi = weight / (height * height);

        String bmiCategory;
        if (bmi < 18.5) {
            bmiCategory = "Underweight";
        } else if (bmi < 25) {
            bmiCategory = "Normal weight";
        } else if (bmi < 30) {
            bmiCategory = "Overweight";
        } else {
            bmiCategory = "Obese";
        }

        @SuppressLint("DefaultLocale") String result;
        result = "BMI: " + String.format("%.2f", bmi) + "\nCategory: " + bmiCategory;
        bmiTextView.setText(result);
    }
}