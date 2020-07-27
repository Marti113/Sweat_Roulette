package com.example.sweatroulette;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private List<String> exerciseList;
    private int userReps = 0;
    private CheckBox pushUps;
    private TextView exerciseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        exerciseList = new ArrayList<>();

        setContentView(R.layout.activity_main);

        pushUps = findViewById(R.id.pushups);

        exerciseView = findViewById(R.id.exerciseView);

    }

    public void onCheckboxClicked(View view){

        exerciseList.add( view.toString());
        
        exerciseView.setText("" + exerciseList.toString());


    }


}