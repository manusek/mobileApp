package com.example.fitnesstest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class StartWorkAct extends AppCompatActivity {

    TextView intropage, subintropage, fitonetitle, fitonedesc, timerValue, btnexercise, startExercise, levelLabel;
    View divpage, bgprogress;
    LinearLayout fitone;
    ImageView imgTimer;

    Spinner levelSpinner;

//    private static final long START_TIME_IN_MILLIS = 50000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
//    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    private static final long BEGINNER_TIME_IN_MILLIS = 60000; // 10 minut
    private static final long INTERMEDIATE_TIME_IN_MILLIS = 90000; // 15 minut
    private static final long ADVANCED_TIME_IN_MILLIS = 120000; // 20 minut

    private long START_TIME_IN_MILLIS = BEGINNER_TIME_IN_MILLIS; // Domyślnie dla początkujących
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS; // Aktualny czas do odliczania


    Animation btthree, bttfour, bttfive, ttbone, ttbtwo, alphago;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_work);

        // Inicjalizacja widoków
        fitonetitle = findViewById(R.id.fitonetitle);
        fitonedesc = findViewById(R.id.fitonedesc);
        subintropage = findViewById(R.id.subintropage);

//        ImageView exerciseImage = findViewById(R.id.exerciseImage);  // ImageView do wyświetlania obrazu

        // Pobranie danych z Intent
        Intent intent = getIntent();
        String exerciseTitle = intent.getStringExtra("EXERCISE_TITLE");
        String exerciseDesc = intent.getStringExtra("EXERCISE_DESC");
        String exerciseDesc2 = intent.getStringExtra("EXERCISE_DESC2");
        int exerciseImageId = getIntent().getIntExtra("EXERCISE_IMAGE_ID", -1);
        ImageView exerciseImageView = findViewById(R.id.exerciseImageView);

        // Sprawdzenie, czy identyfikator obrazu jest prawidłowy
        if (exerciseImageId != -1) {
            // Ustawienie obrazu w ImageView
            exerciseImageView.setImageResource(exerciseImageId);
        } else {
            Toast.makeText(this, "Nie udało się załadować obrazu", Toast.LENGTH_SHORT).show();
        }




        // Ustawienie tytułu i opisu ćwiczenia w widokach
        fitonetitle.setText(exerciseTitle);
        fitonedesc.setText(exerciseDesc);
        subintropage.setText(exerciseDesc2);



        //Load Animations
        btthree = AnimationUtils.loadAnimation(this, R.anim.btthree);
        bttfour = AnimationUtils.loadAnimation(this, R.anim.bttfour);
        bttfive = AnimationUtils.loadAnimation(this, R.anim.bttfive);
        ttbone = AnimationUtils.loadAnimation(this, R.anim.ttbone);
        ttbtwo = AnimationUtils.loadAnimation(this, R.anim.ttbtwo);
        alphago = AnimationUtils.loadAnimation(this, R.anim.alphago);

        intropage = (TextView) findViewById(R.id.intropage);
        subintropage = (TextView) findViewById(R.id.subintropage);
        levelLabel = (TextView) findViewById(R.id.levelLabel);
        levelSpinner = (Spinner) findViewById(R.id.levelSpinner);
        fitonetitle = (TextView) findViewById(R.id.fitonetitle);
        fitonedesc = (TextView) findViewById(R.id.fitonedesc);
        timerValue = (TextView) findViewById(R.id.timerValue);
        btnexercise = (TextView) findViewById(R.id.btnexercise);
        startExercise = (TextView) findViewById(R.id.startExercise);

        divpage = (View) findViewById(R.id.divpage);
        bgprogress = (View) findViewById(R.id.bgprogress);

        fitone = (LinearLayout) findViewById(R.id.fitone);

        imgTimer = (ImageView) findViewById(R.id.imgtimer);

        //assign animation
        btnexercise.startAnimation(bttfour);
        bgprogress.startAnimation(btthree);
        startExercise.startAnimation(bttfive);
        fitone.startAnimation(ttbone);
        intropage.startAnimation(ttbtwo);
        subintropage.startAnimation(ttbtwo);
        levelLabel.startAnimation(ttbtwo);
        levelSpinner.startAnimation(ttbtwo);
        divpage.startAnimation(ttbtwo);
        timerValue.startAnimation(alphago);
        imgTimer.startAnimation(alphago);

        resetTimer();

        btnexercise.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent a = new Intent(StartWorkAct.this,WorkoutAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        startExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    stopTimer(); // Jeśli timer działa, zatrzymaj go
                    startExercise.setText("START"); // Zmień tekst przycisku
                } else {
                    startTimer(); // Jeśli timer nie działa, uruchom go
                    startExercise.setText("STOP"); // Zmień tekst przycisku
                }
            }
        });

        Spinner levelSpinner = findViewById(R.id.levelSpinner);
        levelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLevel = parent.getItemAtPosition(position).toString();

                // Ustaw czas początkowy na podstawie wybranego poziomu
                switch (selectedLevel) {
                    case "Początkujący":
                        START_TIME_IN_MILLIS = BEGINNER_TIME_IN_MILLIS;
                        break;
                    case "Średniozaawansowany":
                        START_TIME_IN_MILLIS = INTERMEDIATE_TIME_IN_MILLIS;
                        break;
                    case "Zaawansowany":
                        START_TIME_IN_MILLIS = ADVANCED_TIME_IN_MILLIS;
                        break;
                }

                // Resetuj timer z nowym czasem
                mTimeLeftInMillis = START_TIME_IN_MILLIS;
                resetTimer();

                // Poinformuj użytkownika o zmianie czasu
                Toast.makeText(StartWorkAct.this, "Ustawiono czas: " +
                        (START_TIME_IN_MILLIS / 60000) + " minut", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Obsługa sytuacji, gdy nic nie zostało wybrane (opcjonalnie)
            }
        });


    }

    private void startTimer(){
        countDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(),"KONIEC!", Toast.LENGTH_SHORT).show();
                resetTimer();
            }
        }.start();
        mTimerRunning = true;
    }

    private void stopTimer() {
        if (countDownTimer != null) { // Sprawdź, czy timer został zainicjalizowany
            countDownTimer.cancel(); // Anuluj odliczanie
            mTimerRunning = false; // Ustaw status timera na false
        }
    }

    private void updateCountDownText(){
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeft = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds) ;
        timerValue.setText(timeLeft);
    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS; // Przywróć czas początkowy
        updateCountDownText(); // Zaktualizuj tekst wyświetlany na ekranie
        mTimerRunning = false; // Ustaw stan timera na "nie działa"
        startExercise.setText("START");
    }



}