package com.example.cs408lab2btempconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cs408lab2btempconverter.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "mainActivity";

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double fahrenheit;
                double celsius;

                EditText f = binding.fahrenheitInput;
                EditText c = binding.celsiusInput;

                String fInput = f.getText().toString();
                String cInput = c.getText().toString();
                String convertValue;

                if((fInput.isEmpty()) && (!(cInput.isEmpty()))) {

                    f.setText(convertToFahrenheit(cInput));
                }
                else if((!(fInput.isEmpty())) && (cInput.isEmpty())) {

                    c.setText(convertToCelsius(fInput));
                }
                else if((!(fInput.isEmpty())) && (!(cInput.isEmpty()))) {

                    c.setText(convertToCelsius(fInput));
                }

            }
        });

    }

    public boolean isNumeric(String n) {

        try {
            double d = Double.parseDouble(n);
            return true;
        }
        catch(NumberFormatException nfe) {
            return false;
        }

    }

    public String convertToFahrenheit(String cInput) {

        double c;
        String convertValue ="";

        if(isNumeric(cInput)) {

            c = Double.parseDouble(cInput);

            double f = (((c * 9) /5) + 32);

            DecimalFormat df = new DecimalFormat("#.00");
            convertValue = df.format(f);
        }
        else {

        }

        return convertValue;
    }
    public String convertToCelsius(String fInput) {

        double f;
        String convertValue = "";

        if(isNumeric(fInput)) {

            f = Double.parseDouble(fInput);

            double c = (((f - 32) * 5)/9);

            DecimalFormat df = new DecimalFormat("#.00");
            convertValue = df.format(c);
        }
        else {

        }

        return convertValue;
    }

}