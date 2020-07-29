package com.example.sweatroulette;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private Set<String> exerciseSet;
    //private CheckBox pushUps;
    private TextView exerciseView;
    private int userReps;
    TextView numberView;
    //keeps track of the rounds of exercises performed
    private int roundCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exerciseSet = new HashSet<>();
        //pushUps = findViewById(R.id.pushups);
        //need to get a value from the user (Reps) and turn into an int
        numberView = findViewById(R.id.number);
        userReps = 0;
        try {
            userReps = Integer.parseInt(numberView.getText().toString());
        } catch (NumberFormatException e) {
        }
        exerciseView = findViewById(R.id.exerciseView);
        //start workout button and click listener
        final Button startWorkout = findViewById(R.id.workout);
        startWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateWorkout();
                startWorkout.setText("Next!");
                roundCount = exerciseSet.size()-1;
                startWorkout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startWorkout.setText("2nd+!");
                        nextExercise(new ArrayList<String>());
                    }
                });
            }
        });
    }

    public void onCheckboxClicked(View view){

        String exercise = ((CheckBox) view).getText().toString();
        exerciseSet.add(exercise);
        //code used for testing
        //exerciseView.setText("" + exerciseSet);

    }


    public List<String> generateWorkout(){

        try {
            userReps = Integer.parseInt(numberView.getText().toString());
        } catch (NumberFormatException e) {
        }

        int numExercises = exerciseSet.size()-1;
        List<String> exerciseList = new ArrayList<>(exerciseSet);

        List<String> testList = new ArrayList<String>();
        testList.add("pushups");
        testList.add("situps");
        testList.add("burpees");

        Collections.shuffle(testList);

        //new List to be filled in for loop with random exercises and reps
        List<String> shuffledWorkout = new ArrayList<String>();
        Random rand = new Random();
        //code that loops through the list with a random number 0-userReps
        for(int i = 0; i < 3; i++ ){
            int reps = rand.nextInt(userReps)+1;
            shuffledWorkout.add(reps + " " + testList.get(i));
        }

        //code for testing
        //System.out.println(shuffledWorkout);
        return shuffledWorkout;
    }

    //iterates through the generated workout list - shuffledWorkout
    private void nextExercise(List<String> workoutList){
        if(roundCount > 0) {
            //exerciseView.setText(workoutList.get(roundCount));
            roundCount --;
        }
    }




}