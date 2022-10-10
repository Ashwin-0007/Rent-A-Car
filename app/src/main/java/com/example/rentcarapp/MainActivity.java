package com.example.rentcarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox mCheckBoxAge,mCheckBoxInsurance;
    EditText mNumberOfDays,mReturnMileage;
    double totalAmount;
    TextView mFinalAmount;
    @SuppressLint("SetTextI18n")
    public void onFindRentClick(View view) {
        int dailyRent = 50;
        if (mCheckBoxAge.isChecked()) {
            dailyRent += 5;
        }
        if (mCheckBoxInsurance.isChecked()) {
            dailyRent += 13;
        }
        String days = mNumberOfDays.getText().toString();
        int NumberOfdays = Integer.parseInt(days);
        int totalkms = dailyRent * NumberOfdays;

        // mileage condition
        int currentMileage = 3453;
        int returnMileage = Integer.parseInt(mReturnMileage.getText().toString());
        int mileage = returnMileage - currentMileage;


        int limit = 200*NumberOfdays;
        if(mileage<=limit){
            totalAmount = totalkms;
        }else{
            totalAmount  = totalkms +(mileage-limit)*0.05;
        }
        mFinalAmount.setText("Rent: "+totalAmount);

    }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCheckBoxAge = findViewById(R.id.checkBox);
        mCheckBoxInsurance = findViewById(R.id.checkBox2);
        mNumberOfDays = findViewById(R.id.editTextNumOfDays);
        mReturnMileage = findViewById(R.id.editTextReturnMil);
        mFinalAmount = findViewById(R.id.textViewRent);
    }
}