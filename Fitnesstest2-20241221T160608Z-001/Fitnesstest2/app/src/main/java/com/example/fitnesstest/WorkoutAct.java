package com.example.fitnesstest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WorkoutAct extends AppCompatActivity {

    TextView titlepage, subtitlepage, intropage, subintropage, btnexercise, fitonetitle, fitonedesc, fittwotitle, fittwodesc, fitthreetitle,
    fitthreedesc, fitfourtitle, fitfourdesc, bmiCalculator;

    View divpage, bgprogress;

    Animation bttone, bttwo, bttfour, bttfive, bttsix, bttseven, btteight;

    LinearLayout fitone, fittwo, fitthree, fitfour;

    String[] exerciseTitles = {"Wyciskanie sztangi", "Uginanie sztangi", "Wyciskanie hantli", "Wyprosty na maszynie"};
    String[] exerciseDescriptions = {
            "Ćwiczenie na mięśnie piersiowe.",
            "Ćwiczenie na bicepsy.",
            "Ćwiczenie na mięśnie naramienne.",
            "Ćwiczenie na mięśnie czworogłowe uda."
    };

    String[] exerciseImages = {
            "chest.jpg",
            "bicep.jpg",
            "shoulder.jpg",
            "leg.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        //Load Animation
        bttone = AnimationUtils.loadAnimation(this,R.anim.bttone);
        bttwo = AnimationUtils.loadAnimation(this,R.anim.bttwo);
        bttfour = AnimationUtils.loadAnimation(this,R.anim.bttfour);
        bttfive = AnimationUtils.loadAnimation(this,R.anim.bttfive);
        bttsix = AnimationUtils.loadAnimation(this,R.anim.bttsix);
        bttseven = AnimationUtils.loadAnimation(this,R.anim.bttseven);
        btteight = AnimationUtils.loadAnimation(this,R.anim.btteight);

        titlepage = (TextView) findViewById(R.id.titlepage);
        subtitlepage = (TextView) findViewById(R.id.subtitlepage);
        bmiCalculator = (TextView) findViewById(R.id.bmiCalculator);
        intropage = (TextView) findViewById(R.id.intropage);
        subintropage = (TextView) findViewById(R.id.subintropage);
        btnexercise = (TextView) findViewById(R.id.btnexercise);
        fitonetitle = (TextView) findViewById(R.id.fitonetitle);
        fitonedesc = (TextView) findViewById(R.id.fitonedesc);
        fittwotitle = (TextView) findViewById(R.id.fittwotitle);
        fittwodesc = (TextView) findViewById(R.id.fittwodesc);
        fitthreetitle = (TextView) findViewById(R.id.fitthreetitle);
        fitthreedesc = (TextView) findViewById(R.id.fitthreedesc);
        fitfourtitle = (TextView) findViewById(R.id.fitfourtitle);
        fitfourdesc = (TextView) findViewById(R.id.fitfourdesc);

        //give an event to another page
        btnexercise.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WorkoutAct.this,StartWorkAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });


        fitone = (LinearLayout) findViewById(R.id.fitone);
        fittwo = (LinearLayout) findViewById(R.id.fittwo);
        fitthree = (LinearLayout) findViewById(R.id.fitthree);
        fitfour = (LinearLayout) findViewById(R.id.fitfour);

        divpage = (View) findViewById(R.id.divpage);
        bgprogress = (View) findViewById(R.id.bgprogress);

        //assign the animation
        titlepage.startAnimation(bttone);
        subtitlepage.startAnimation(bttone);
        divpage.startAnimation(bttone);

        intropage.startAnimation(bttwo);
        subintropage.startAnimation(bttwo);
        bmiCalculator.startAnimation(bttwo);

        fitone.startAnimation(bttwo);
        fittwo.startAnimation(bttfour);
        fitthree.startAnimation(bttfive);
        fitfour.startAnimation(bttsix);

        btnexercise.startAnimation(btteight);
        bgprogress.startAnimation(bttseven);


        fitone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WorkoutAct.this, StartWorkAct.class);
                a.putExtra("EXERCISE_TITLE", exerciseTitles[0]);  // Wybrany tytuł ćwiczenia
                a.putExtra("EXERCISE_DESC", exerciseDescriptions[0]);  // Wybrany opis ćwiczenia
//                a.putExtra("EXERCISE_IMAGE", exerciseImages[0]);  // Wybrana nazwa obrazu
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        fittwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WorkoutAct.this, StartWorkAct.class);
                a.putExtra("EXERCISE_TITLE", exerciseTitles[1]);  // Wybrany tytuł ćwiczenia
                a.putExtra("EXERCISE_DESC", exerciseDescriptions[1]);  // Wybrany opis ćwiczenia
//                a.putExtra("EXERCISE_IMAGE", exerciseImages[1]);  // Wybrana nazwa obrazu
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        fitthree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WorkoutAct.this, StartWorkAct.class);
                a.putExtra("EXERCISE_TITLE", exerciseTitles[2]);  // Wybrany tytuł ćwiczenia
                a.putExtra("EXERCISE_DESC", exerciseDescriptions[2]);  // Wybrany opis ćwiczenia
//                a.putExtra("EXERCISE_IMAGE", exerciseImages[2]);  // Wybrana nazwa obrazu
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        fitfour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WorkoutAct.this, StartWorkAct.class);
                a.putExtra("EXERCISE_TITLE", exerciseTitles[3]);  // Wybrany tytuł ćwiczenia
                a.putExtra("EXERCISE_DESC", exerciseDescriptions[3]);  // Wybrany opis ćwiczenia
//                a.putExtra("EXERCISE_IMAGE", exerciseImages[3]);  // Wybrana nazwa obrazu
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        bmiCalculator.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WorkoutAct.this,bmiCalc.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });


    }
}