package com.example.assignment8;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonPlus = findViewById(R.id.buttonPlus);
        Button buttonMinus = findViewById(R.id.buttonMinus);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);

        buttonPlus.setOnClickListener(this::Addition);
        buttonMinus.setOnClickListener(this::Subtraction);
        buttonMultiply.setOnClickListener(this::Multiplication);
        buttonDivide.setOnClickListener(this::Division);
    }

    public void Addition(View view) {
        performOperation("+");
    }

    public void Subtraction(View view) {
        performOperation("-");
    }

    public void Multiplication(View view) {
        performOperation("*");
    }

    public void Division(View view) {
        performOperation("/");
    }

    private void performOperation(String operator) {
        EditText value1 = findViewById(R.id.inputFirstNumber);
        EditText value2 = findViewById(R.id.inputSecondNumber);
        EditText value3 = findViewById(R.id.textResult);

        try {
            double num1 = Double.parseDouble(value1.getText().toString());
            double num2 = Double.parseDouble(value2.getText().toString());
            double result = 0;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        value3.setText("Cannot divide by zero");
                        return;
                    }
                    break;
            }

            value3.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            value3.setText("Invalid input");
        }
    }
}