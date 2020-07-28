package com.example.sweatroulette;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.HashSet;

import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    private Set<String> exerciseSet;
    //private CheckBox pushUps;
    private TextView exerciseView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exerciseSet = new HashSet<>();
        //pushUps = findViewById(R.id.pushups);
        //need to get a value from the user (Reps) and turn into an int
        TextView numberView = findViewById(R.id.number);
        int userReps = 0;
        try {
            userReps = Integer.parseInt(numberView.getText().toString());
        } catch (NumberFormatException e) {
            userReps = -1;
        }
        exerciseView = findViewById(R.id.exerciseView);
        //start workout button and click listener
        final Button startWorkout = findViewById(R.id.workout);
        startWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                workout();
                startWorkout.setText("Next!");
            }
        });
    }

    public void onCheckboxClicked(View view){

        String exercise = ((CheckBox) view).getText().toString();
        exerciseSet.add(exercise);
        exerciseView.setText("" + exerciseSet);

    }


    public void workout(){
        //code that loops through the set with a random number 0-userReps

    }

    @Override
    public void onClick(View view) {

    }
}