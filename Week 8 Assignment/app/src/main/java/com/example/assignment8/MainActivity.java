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

        int num1 = Integer.parseInt(value1.getText().toString());
        int num2 = Integer.parseInt(value2.getText().toString());

        int result;
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
            default:
                result = 0;
        }

        value3.setText(String.valueOf(result));
    }
}