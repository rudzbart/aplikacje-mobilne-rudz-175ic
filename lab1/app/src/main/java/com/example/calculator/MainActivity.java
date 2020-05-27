package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView resultTextView;
    private Spinner firstDigitSpinner;
    private Spinner secondDigitSpinner;
    private Button addButton;
    private Button substractButton;
    private Button multiplyButton;
    private Button divideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
        firstDigitSpinner = findViewById(R.id.firstDigitSpinner);
        secondDigitSpinner = findViewById(R.id.secondDigitSpinner);
        addButton = findViewById(R.id.addButton);
        substractButton = findViewById(R.id.substractButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        divideButton = findViewById(R.id.divideButton);

        String[] arraySpinner = new String[] {
          "0","1","2","3","4","5","6","7","8","9"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        firstDigitSpinner.setAdapter(adapter);
        secondDigitSpinner.setAdapter(adapter);

        addButton.setOnClickListener(this);
        substractButton.setOnClickListener(this);
        multiplyButton.setOnClickListener(this);
        divideButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        double firstDigit = Double.parseDouble(firstDigitSpinner.getSelectedItem().toString());
        double secondDigit = Double.parseDouble(secondDigitSpinner.getSelectedItem().toString());
        double result;
        switch (v.getId()){
            case R.id.addButton:
                result = firstDigit + secondDigit;
                resultTextView.setText(Double.toString(result));
                break;
            case R.id.substractButton:
                result = firstDigit - secondDigit;
                resultTextView.setText(Double.toString(result));
                break;
            case R.id.multiplyButton:
                result = firstDigit * secondDigit;
                resultTextView.setText(Double.toString(result));
                break;
            case R.id.divideButton:
                if(secondDigit == 0)
                {
                    resultTextView.setText("N/A");
                    break;
                }
                result = firstDigit / secondDigit;
                resultTextView.setText(Double.toString(result));
                break;
        }
    }
}
