package com.example.spacecolony;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button recruitBtn, trainBtn, missionBtn;

    int skill = 5;
    int energy = 20;
    int experience = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        recruitBtn = findViewById(R.id.recruitBtn);
        trainBtn = findViewById(R.id.trainBtn);
        missionBtn = findViewById(R.id.missionBtn);

        recruitBtn.setOnClickListener(v -> {
            skill = 5;
            energy = 20;
            experience = 0;
            updateText("Crew recruited!");
        });

        trainBtn.setOnClickListener(v -> {
            experience++;
            skill++;
            updateText("Training done! EXP: " + experience);
        });

        missionBtn.setOnClickListener(v -> runMission());

        updateText("Welcome to Space Colony");
    }

    private void runMission() {
        Random rand = new Random();
        int threat = 5 + rand.nextInt(5);

        int damage = skill - 2;
        int taken = threat - 3;

        energy -= taken;

        if (energy <= 0) {
            updateText("Mission failed! Crew died.");
        } else {
            experience++;
            updateText("Mission success! EXP: " + experience + "\nEnergy: " + energy);
        }
    }

    private void updateText(String msg) {
        textView.setText(msg + "\nSkill: " + skill + " | Energy: " + energy);
    }
}