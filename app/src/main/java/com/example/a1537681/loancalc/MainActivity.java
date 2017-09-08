package com.example.a1537681.loancalc;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    EditText etLoanAmount, etLoanTerm, etYearlyRate; //User Input
    TextView tvLoanAmount, tvLoanTerm, tvYearlyRate; //Label for User Input
    TextView tvMonthlyPay, tvTotalPay, tvTotalInterest; //Results
    Button btCalculate, btClear;
    double loanAmount, loanTerm, yearlyRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Identify all the text fields
        etLoanAmount = (EditText) findViewById(R.id.etLoanAmount);
        etLoanTerm = (EditText) findViewById(R.id.etLoanTerm);
        etYearlyRate = (EditText) findViewById(R.id.etYearlyRate);
        tvLoanAmount = (TextView) findViewById(R.id.tvLoanAmount);
        tvLoanTerm = (TextView) findViewById(R.id.tvLoanTerm);
        tvTotalInterest = (TextView) findViewById(R.id.tvTotalInterest);
        tvMonthlyPay = (TextView) findViewById(R.id.tvMonthlyPay);
        tvTotalPay = (TextView) findViewById(R.id.tvTotalPay);
        tvTotalInterest = (TextView) findViewById(R.id.tvTotalInterest);
        btCalculate = (Button) findViewById(R.id.btCalculate);
        btClear = (Button) findViewById(R.id.btClear);

    } //End of onCreate()

        //Calculation
        public void calculateLoan(View v) {
        loanAmount = Double.parseDouble(etLoanAmount.getText().toString());
        loanTerm = Double.parseDouble(etLoanTerm.getText().toString());
        yearlyRate = Double.parseDouble(etYearlyRate.getText().toString());
        yearlyRate = yearlyRate/100;

        tvMonthlyPay.setText(Double.toString(Math.round((loanAmount*yearlyRate)/12)* 100/100)); //Monthly rate --> Need to find way to round correctly .## decimal
        tvTotalPay.setText(Double.toString(loanAmount + (loanAmount*yearlyRate)*loanTerm)); //Total payment
        tvTotalInterest.setText(Double.toString(Double.parseDouble(tvTotalPay.getText().toString())- loanAmount)); //Total Interest
    } //End of calculateLoan





}
