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

    TextView titlepage, subtitlepage, intropage, subintropage, fitonetitle, fitonedesc, fittwotitle, fittwodesc, fitthreetitle,
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

    String[] exerciseDescriptions2 = {
            "Ćwiczenie na klatkę piersiową, które angażuje również mięśnie tricepsów i barków.\n Idealne dla budowania siły i masy mięśniowej.",
            "Skuteczne ćwiczenie na bicepsy, które zwiększa siłę i objętość ramion. Wykonywane \n w pozycji stojącej dla lepszej izolacji mięśni.",
            "Alternatywa dla wyciskania sztangi, pozwalająca na większy zakres ruchu i równomierny\n rozwój mięśni klatki piersiowej.",
            "Doskonałe ćwiczenie na mięśnie nóg, szczególnie na czworogłowe uda. Idealne do poprawy\n siły i stabilności kończyn dolnych."
    };

    //dodałem
    int[] exerciseImageId = {
            R.drawable.chest,
            R.drawable.bicep,
            R.drawable.shoulder,
            R.drawable.leg
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
        fitonetitle = (TextView) findViewById(R.id.fitonetitle);
        fitonedesc = (TextView) findViewById(R.id.fitonedesc);
        fittwotitle = (TextView) findViewById(R.id.fittwotitle);
        fittwodesc = (TextView) findViewById(R.id.fittwodesc);
        fitthreetitle = (TextView) findViewById(R.id.fitthreetitle);
        fitthreedesc = (TextView) findViewById(R.id.fitthreedesc);
        fitfourtitle = (TextView) findViewById(R.id.fitfourtitle);
        fitfourdesc = (TextView) findViewById(R.id.fitfourdesc);

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

        fitone.startAnimation(bttfour);
        fittwo.startAnimation(bttfour);
        fitthree.startAnimation(bttfive);
        fitfour.startAnimation(bttsix);

        bgprogress.startAnimation(bttseven);


        fitone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WorkoutAct.this, StartWorkAct.class);
                a.putExtra("EXERCISE_TITLE", exerciseTitles[0]);  // Wybrany tytuł ćwiczenia
                a.putExtra("EXERCISE_DESC", exerciseDescriptions[0]);  // Wybrany opis ćwiczenia
                a.putExtra("EXERCISE_DESC2", exerciseDescriptions2[0]);  // Wybrany opis ćwiczenia
                a.putExtra("EXERCISE_IMAGE", exerciseImages[0]);  // Wybrana nazwa obrazu
                a.putExtra("EXERCISE_IMAGE_ID",exerciseImageId[0]); // wybrane zdj
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
                a.putExtra("EXERCISE_DESC2", exerciseDescriptions2[1]);  // Wybrany opis ćwiczenia
                a.putExtra("EXERCISE_IMAGE", exerciseImages[1]);  // Wybrana nazwa obrazu
                a.putExtra("EXERCISE_IMAGE_ID" ,exerciseImageId[1]); // wybrane zdj
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
                a.putExtra("EXERCISE_DESC2", exerciseDescriptions2[2]);  // Wybrany opis ćwiczenia
                a.putExtra("EXERCISE_IMAGE", exerciseImages[2]);  // Wybrana nazwa obrazu
                a.putExtra("EXERCISE_IMAGE_ID" ,exerciseImageId[2]); // wybrane zdj
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
                a.putExtra("EXERCISE_DESC2", exerciseDescriptions2[3]);  // Wybrany opis ćwiczenia
                a.putExtra("EXERCISE_IMAGE", exerciseImages[3]);  // Wybrana nazwa obrazu
                a.putExtra("EXERCISE_IMAGE_ID" ,exerciseImageId[3]); // wybrane zdj
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