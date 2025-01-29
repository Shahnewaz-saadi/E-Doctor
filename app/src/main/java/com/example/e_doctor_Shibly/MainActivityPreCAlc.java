package com.example.e_doctor_Shibly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class MainActivityPreCAlc extends AppCompatActivity {

    private EditText editTextDate;
    private Button buttonCalculate;
    private TextView textViewResult;

    public MainActivityPreCAlc() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_preg_calc);

        editTextDate = findViewById(R.id.editTextDate);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCalculate.setOnClickListener((View v) -> {
            calculatePregnancy();
        });
    }
    private void calculatePregnancy() {
        String lastMenstrualPeriod = editTextDate.getText().toString();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            Date lmpDate = sdf.parse(lastMenstrualPeriod);

            Calendar calendar = Calendar.getInstance();
            Date currentDate = calendar.getTime();

            long diffInMilliseconds = currentDate.getTime() - lmpDate.getTime();
            long diffInWeeks = TimeUnit.MILLISECONDS.toDays(diffInMilliseconds) / 7;

            String result = "Your pregnancy is approximately " + diffInWeeks + " weeks.";

            textViewResult.setText(result);
        } catch (ParseException e) {
            e.printStackTrace();
            textViewResult.setText("Invalid date format. Please use the format YYYY-MM-DD.");
        }
    }

}