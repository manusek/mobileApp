package com.example.fitnesstest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class StartWorkAct extends AppCompatActivity {

    TextView intropage, subintropage, fitonetitle, fitonedesc, timerValue, btnexercise, startExercise;
    View divpage, bgprogress;
    LinearLayout fitone;
    ImageView imgTimer;

    private static final long START_TIME_IN_MILLIS = 50000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    Animation btthree, bttfour, bttfive, ttbone, ttbtwo, alphago;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_work);

        // Inicjalizacja widoków
        fitonetitle = findViewById(R.id.fitonetitle);
        fitonedesc = findViewById(R.id.fitonedesc);
//        ImageView exerciseImage = findViewById(R.id.exerciseImage);  // ImageView do wyświetlania obrazu

        // Pobranie danych z Intent
        Intent intent = getIntent();
        String exerciseTitle = intent.getStringExtra("EXERCISE_TITLE");
        String exerciseDesc = intent.getStringExtra("EXERCISE_DESC");


        // Ustawienie tytułu i opisu ćwiczenia w widokach
        fitonetitle.setText(exerciseTitle);
        fitonedesc.setText(exerciseDesc);



        //Load Animations
        btthree = AnimationUtils.loadAnimation(this, R.anim.btthree);
        bttfour = AnimationUtils.loadAnimation(this, R.anim.bttfour);
        bttfive = AnimationUtils.loadAnimation(this, R.anim.bttfive);
        ttbone = AnimationUtils.loadAnimation(this, R.anim.ttbone);
        ttbtwo = AnimationUtils.loadAnimation(this, R.anim.ttbtwo);
        alphago = AnimationUtils.loadAnimation(this, R.anim.alphago);

        intropage = (TextView) findViewById(R.id.intropage);
        subintropage = (TextView) findViewById(R.id.subintropage);
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