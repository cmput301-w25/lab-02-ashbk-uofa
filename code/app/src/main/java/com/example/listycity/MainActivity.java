package com.example.listycity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList; //for reference to visual
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //R has a lot of info about project
        cityList = findViewById(R.id.city_list);

        String[] cities = {"Edmonton", "Paris", "London", "Ottawa", "New York"};
        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        //adapter takes list primitive into list view, tie it to content.xml file
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter); //tie adapter to listview
    }
}