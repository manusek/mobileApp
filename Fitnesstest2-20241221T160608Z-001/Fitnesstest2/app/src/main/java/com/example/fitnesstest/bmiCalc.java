package com.example.fitnesstest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class bmiCalc extends AppCompatActivity {


    TextView bmititle, bntexcercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_calculator);

        // Znajdź nowy przycisk POWRÓT
        TextView btnExercise = findViewById(R.id.btnexercise);

        // Obsługa kliknięcia przycisku
        btnExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent(bmiCalc.this, WorkoutAct.class);
                startActivity(returnIntent); // Powrót do widoku ćwiczeń
                finish(); // Zakończ bieżącą aktywność
            }
        });
    }
}
