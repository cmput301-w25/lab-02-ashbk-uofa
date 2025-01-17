package com.example.listycity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList; //for reference to visual
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    Button addButton;
    EditText addField;
    Button deleteButton;

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

        addButton = findViewById(R.id.add_button);
        addField = findViewById(R.id.add_name);
        addButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Editable addName = addField.getText();
                dataList.add(String.valueOf(addName));
                cityList.setAdapter(cityAdapter);
            }
        });


        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3)
            {
                deleteButton = findViewById(R.id.delete_button);
                deleteButton.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        dataList.remove(String.valueOf(arg0.getItemAtPosition(position)));
                        cityList.setAdapter(cityAdapter);
                    }
                });
            }
        });
    };
}