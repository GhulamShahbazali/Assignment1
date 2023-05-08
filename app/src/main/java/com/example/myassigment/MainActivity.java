package com.example.myassigment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView addResultTv, divisionResultTv;
    int addValue1 = 0, addValue2 = 0;
    int divisionValue1, divisionValue2;
    List<String> addValues = new ArrayList<>(Arrays.asList("50", "100", "200", "300"));
    List<String> divisionValues = new ArrayList<>(Arrays.asList("2", "3", "4", "5", "0"));
    private Button calculateBtn;
    Spinner addSpinner1, adSpinner2, divisionSpinner3, divisionSpinner4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, addValues);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, divisionValues);

        addSpinner1.setAdapter(adapter);
        adSpinner2.setAdapter(adapter);
        divisionSpinner3.setAdapter(adapter2);
        divisionSpinner4.setAdapter(adapter2);

        setListeners();
    }

    private void initializeViews() {
        addSpinner1 = findViewById(R.id.add_spinner_1);
        adSpinner2 = findViewById(R.id.add_spinner_2);
        divisionSpinner3 = findViewById(R.id.division_spinner_1);
        divisionSpinner4 = findViewById(R.id.division_spinner_2);
        addResultTv = findViewById(R.id.add_result_tv);
        divisionResultTv = findViewById(R.id.tvResult2);
        calculateBtn = findViewById(R.id.btn_calculate);

    }

    private void setListeners() {
        addSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                addValue1 = Integer.parseInt(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        adSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                addValue2 = Integer.parseInt(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        divisionSpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                divisionValue1 = Integer.parseInt(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        divisionSpinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                divisionValue2 = Integer.parseInt(parent.getItemAtPosition(position).toString().trim());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        calculateBtn.setOnClickListener(v -> {
            int addResult = addValue1 + addValue2;
            addResultTv.setText(String.valueOf(addResult));

            if (divisionValue2 == 0) {
                divisionResultTv.setText("infinity");
            } else {
                double result = (double) divisionValue1 / divisionValue2;
                divisionResultTv.setText(String.format(Locale.getDefault(), "%.2f", result));
            }
        });
    }
}