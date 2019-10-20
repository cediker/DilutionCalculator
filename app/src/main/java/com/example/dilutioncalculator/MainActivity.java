package com.example.dilutioncalculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView requiredSolidsInput;
    TextView amountOfSolutionRequiredInput;
    TextView currentSolids;
    TextView output;
    TextView output1;
    TextView textView;
    TextView textView2;
    TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requiredSolidsInput = findViewById(R.id.requiredSolidsInput);
        amountOfSolutionRequiredInput = findViewById(R.id.amountOfSolutionRequiredInput);
        currentSolids = findViewById(R.id.currentSolidsInput);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        button = (Button) findViewById(R.id.button);

        output = findViewById(R.id.outputDilution);
        output1 = findViewById(R.id.outputDilution2);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(Double.parseDouble(requiredSolidsInput.getText().toString())>Double.parseDouble(currentSolids.getText().toString())) {
                    Context context = getApplicationContext();
                    CharSequence text = "Your required solids cannot be greater than your current solids!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {
                    resultDilution();
                }



            }
        });

    }

    public void resultDilution(){
        requiredSolidsInput.setVisibility(View.VISIBLE);
        amountOfSolutionRequiredInput.setVisibility(View.VISIBLE);
        currentSolids.setVisibility(View.VISIBLE);
        output.setVisibility(View.VISIBLE);
        output1.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
        textView2.setVisibility(View.VISIBLE);
        textView3.setVisibility(View.VISIBLE);
        double rsi = Double.parseDouble(requiredSolidsInput.getText().toString());

        double sri = Double.parseDouble(amountOfSolutionRequiredInput.getText().toString());

        double cs = Double.parseDouble(currentSolids.getText().toString());

        double result = sri-((rsi/cs)*sri);
        double mixResult = (rsi/cs)*sri;
        output1.setText(Double.toString(Math.round(mixResult*1000.0)/1000.0));
        output.setText(Double.toString(Math.round(result*1000.0)/1000.0));


    }


}
