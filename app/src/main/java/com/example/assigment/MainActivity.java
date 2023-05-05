package com.example.assigment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Spinner spinner1, spinner2, spinner3, spinner4;
    int Spinner1 = 0, Spinner2 = 0,Spinner3,Spinner4;
    private Button btnCalculated;
    private TextView tvResult,tvResult2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        spinner4 = findViewById(R.id.spinner4);
        tvResult = findViewById(R.id.tvResult);
        tvResult2 = findViewById(R.id.tvResult2);
        btnCalculated = findViewById(R.id.btnCalculate);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.numbers, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.numbers1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
        spinner4.setAdapter(adapter1);



        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner1 = Integer.parseInt(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner2 = Integer.parseInt(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner3 = Integer.parseInt(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner4= Integer.parseInt(parent.getItemAtPosition(position).toString().trim());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnCalculated.setOnClickListener(v->{
            int Result=Spinner1+Spinner2;
            if(Spinner4==0)
            {   tvResult.setText(""+Result);
                tvResult2.setText("infinity");
            }
            else {
                double result=Spinner3/Spinner4;
                DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                // Create a DecimalFormat object with 2 decimal places
                String formattedValue = decimalFormat.format(result);
                tvResult.setText(""+Result);
                tvResult2.setText(""+formattedValue);

            }

        });


    }

}