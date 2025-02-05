package com.example.fitnesstest;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class bmiCalc extends AppCompatActivity {

    TextView bmititle, bntexcercise, btnCalculateBmi, bmiResult;
    EditText weightInput, heightInput;
    ProgressBar bmiProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_calculator);

        // Powiązanie widoków z XML
        TextView btnExercise = findViewById(R.id.btnexercise);
        btnCalculateBmi = findViewById(R.id.buttonTextBmi);
        bmiResult = findViewById(R.id.bmiResult);
        weightInput = findViewById(R.id.editTextNumber);
        heightInput = findViewById(R.id.editTextNumber2);
        bmiProgressBar = findViewById(R.id.bmiProgressBar);

        // Obsługa przycisku POWRÓT
        btnExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent(bmiCalc.this, WorkoutAct.class);
                startActivity(returnIntent); // Powrót do widoku ćwiczeń
                finish(); // Zakończ bieżącą aktywność
            }
        });

        // Obsługa przycisku "Oblicz BMI"
        btnCalculateBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightText = weightInput.getText().toString();
                String heightText = heightInput.getText().toString();

                // Sprawdź, czy dane wejściowe nie są puste
                if (!weightText.isEmpty() && !heightText.isEmpty()) {
                    try {
                        float weight = Float.parseFloat(weightText);
                        float height = Float.parseFloat(heightText) / 100; // Konwersja cm na metry
                        if (height > 0) {
                            // Oblicz BMI
                            float bmi = weight / (height * height);

                            // Pobierz kategorię BMI
                            String bmiCategory = getBmiCategory(bmi);

                            // Wyświetl wynik i kategorię
                            bmiResult.setText("Twoje BMI to: " + String.format("%.2f", bmi) + "\n" + bmiCategory);
                            bmiResult.setVisibility(View.VISIBLE);

                            // Ustaw wartość na ProgressBar
                            bmiProgressBar.setProgress((int) bmi);

                            // Ustaw widoczność paska
                            bmiProgressBar.setVisibility(View.VISIBLE);

                            // Zmień kolor paska w zależności od kategorii
                            if (bmi < 18.5) {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        bmiProgressBar.setProgressTintList(getColorStateList(R.color.blue));
                                    }
                                }
                            } else if (bmi >= 18.5 && bmi <= 24.9) {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        bmiProgressBar.setProgressTintList(getColorStateList(R.color.green));
                                    }
                                }
                            } else if (bmi >= 25 && bmi <= 29.9) {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        bmiProgressBar.setProgressTintList(getColorStateList(R.color.yellow));
                                    }
                                }
                            } else if (bmi >= 30 && bmi <= 34.9) {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        bmiProgressBar.setProgressTintList(getColorStateList(R.color.orange));
                                    }
                                }
                            } else {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        bmiProgressBar.setProgressTintList(getColorStateList(R.color.red));
                                    }
                                }
                            }

                        } else {
                            Toast.makeText(bmiCalc.this, "Wzrost musi być większy niż 0", Toast.LENGTH_SHORT).show();
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(bmiCalc.this, "Wprowadź poprawne liczby", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(bmiCalc.this, "Wypełnij wszystkie pola", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private String getBmiCategory(float bmi) {
        if (bmi < 18.5) {
            return "Kategoria: Niedowaga";
        } else if (bmi >= 18.5 && bmi <= 24.99) {
            return "Kategoria: Prawidłowa masa ciała";
        } else if (bmi >= 25 && bmi <= 29.99) {
            return "Kategoria: Nadwaga";
        } else if (bmi >= 30 && bmi <= 34.99) {
            return "Kategoria: Otyłość I stopnia";
        } else if (bmi >= 35 && bmi <= 39.99) {
            return "Kategoria: Otyłość II stopnia";
        } else {
            return "Kategoria: Otyłość III stopnia";
        }
    }
}
