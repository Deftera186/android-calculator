package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class calculator extends AppCompatActivity {
    private TextView display;
    private String currentNumber = "";
    private String operation = "";
    private double firstNumber = 0;
    private double secondNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        display = findViewById(R.id.textView);

        setNumberButtonListener(R.id.button0, "0");
        setNumberButtonListener(R.id.button1, "1");
        setNumberButtonListener(R.id.button2, "2");
        setNumberButtonListener(R.id.button3, "3");
        setNumberButtonListener(R.id.button4, "4");
        setNumberButtonListener(R.id.button5, "5");
        setNumberButtonListener(R.id.button6, "6");
        setNumberButtonListener(R.id.button7, "7");
        setNumberButtonListener(R.id.button8, "8");
        setNumberButtonListener(R.id.button9, "9");

        setOperationButtonListener(R.id.buttonSign1, "+");
        setOperationButtonListener(R.id.buttonSign2, "-");
        setOperationButtonListener(R.id.buttonSign3, "*");
        setOperationButtonListener(R.id.buttonSign4, "/");

        Button equalsButton = findViewById(R.id.buttonEquals);
        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    private void setNumberButtonListener(int buttonId, final String number) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber += number;
                display.setText(currentNumber);
            }
        });
    }

    private void setOperationButtonListener(int buttonId, final String operation) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Double.parseDouble(currentNumber);
                currentNumber = "";
                calculator.this.operation = operation;
            }
        });
    }

    private void calculate() {
        secondNumber = Double.parseDouble(currentNumber);

        switch (operation) {
            case "+":
                currentNumber = String.valueOf(firstNumber + secondNumber);
                break;
            case "-":
                currentNumber = String.valueOf(firstNumber - secondNumber);
                break;
            case "*":
                currentNumber = String.valueOf(firstNumber * secondNumber);
                break;
            case "/":
                if (secondNumber != 0) {
                    currentNumber = String.valueOf(firstNumber / secondNumber);
                } else {
                    currentNumber = "Error";
                }
                break;
        }

        display.setText(currentNumber);
    }
}