package com.example.splitthebillapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Calculator extends AppCompatActivity {

    private Button btnSplitCalculate;
    private Button btnClear;

    // Members
    private double totalCost, finalCost, taxValue;
    private int persons;
    private String rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        btnSplitCalculate = (Button)findViewById(R.id.finalCal);
        btnClear = (Button)findViewById(R.id.clear);
        assert btnSplitCalculate != null;

        final EditText totalBill = (EditText)findViewById(R.id.billAmount);
        final EditText noPersons = (EditText)findViewById(R.id.noPersons);
        final Spinner ratingVal = (Spinner)findViewById(R.id.spinnerRating);
        final TextView tax = (TextView)findViewById(R.id.taxAmount);
        final TextView individualShare = (TextView)findViewById(R.id.individualShareValue);
        final String exc="Excellent",avg="Average",poor="Poor";

        View.OnClickListener btnSplitCalListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable inputOne = totalBill.getText();
                Editable inputTwo = noPersons.getText();
                String inputOneString = inputOne.toString();
                String inputTwoString = inputTwo.toString();

                try{
                    totalCost = Double.parseDouble(inputOneString);
                    persons = Integer.parseInt(inputTwoString);
                    rating = ratingVal.getSelectedItem().toString();

                    if (rating.equals(exc))
                        taxValue = (totalCost*20)/100;
                    else if (rating.equals(avg))
                        taxValue = (totalCost*15)/100;
                    else
                        taxValue = (totalCost*5)/100;

                    finalCost = (totalCost+taxValue)/persons;

                    DecimalFormat currency = new DecimalFormat("$###,###.##");
                    String finalCostValue = currency.format(finalCost);
                    String taxFinalValue = currency.format(taxValue);
                    individualShare.setText(finalCostValue);
                    tax.setText(taxFinalValue);
                } catch (Exception e){
                    Log.e(e.getMessage(), e.toString());
                }
            }
        }; btnSplitCalculate.setOnClickListener(btnSplitCalListener);

        View.OnClickListener btnClearListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalBill.setText("");
                noPersons.setText("");
                ratingVal.setSelection(1);
                tax.setText("$0.0");
                individualShare.setText("$0.0");
            }
        };
        btnClear.setOnClickListener(btnClearListener);
    }
}
