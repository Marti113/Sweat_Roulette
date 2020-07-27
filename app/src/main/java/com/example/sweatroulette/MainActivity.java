package com.example.sweatroulette;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity  {

    private Set<String> exerciseSet;
    private List<String> exerciseList;
    private int userReps = 0;
    private CheckBox pushUps;
    private TextView exerciseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        exerciseList = new ArrayList<>();
        exerciseSet = new HashSet<>();

        setContentView(R.layout.activity_main);

        pushUps = findViewById(R.id.pushups);

        exerciseView = findViewById(R.id.exerciseView);

    }

    public void onCheckboxClicked(View view){

        //exerciseList.add( view.toString();
        String exercise = ((CheckBox) view).getText().toString();
        exerciseSet.add(exercise);
        exerciseView.setText("" + exerciseSet);


    }


}