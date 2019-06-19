package com.example.splitthebillapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate = (Button)findViewById(R.id.nextButton);

        View.OnClickListener buttonInfoListener= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(MainActivity.this, Calculator.class);
                startActivity(nextIntent);
            }
        };

        btnCalculate.setOnClickListener(buttonInfoListener);
    }


}
