package com.example.e_doctor_Shibly;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Appoinment extends AppCompatActivity {

    private EditText etPatientName, etAge, etAddress, etProblem;
    private Spinner spinnerGender;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoinment);


        etPatientName = findViewById(R.id.etPatientName);
        etAge = findViewById(R.id.etAge);
        spinnerGender = findViewById(R.id.spinnerGender);
        etAddress = findViewById(R.id.etAddress);
        etProblem = findViewById(R.id.etProblem);

        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAppointment();
            }
        });
    }

    private void createAppointment() {
        String patientName = etPatientName.getText().toString();
        String age = etAge.getText().toString();
        String gender = spinnerGender.getSelectedItem().toString();
        String address = etAddress.getText().toString();
        String problem = etProblem.getText().toString();

        // Generate a unique serial number
        String serialNumber = generateSerialNumber();

        // Save appointment details and serial number in the database or locally

        // Show confirmation message to the user
        showConfirmationDialog(serialNumber);
    }

    private String generateSerialNumber() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
        String timestamp = dateFormat.format(new Date());

        Random random = new Random();
        int randomNum = random.nextInt(10000);

        return timestamp + String.format("%04d", randomNum);
    }

    private void showConfirmationDialog(String serialNumber) {
        String message = "Appointment for Dr Shibly Shahriar is Complete. Your serial number: " + serialNumber;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}