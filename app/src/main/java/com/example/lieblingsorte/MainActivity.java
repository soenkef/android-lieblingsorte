package com.example.lieblingsorte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<String> myPlaces;
    static ArrayAdapter<String> arrayAdapter;
    static ArrayList<LatLng> locations;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView memorablePlaces = (ListView) findViewById(R.id.memoryList);

        myPlaces = new ArrayList<>();

        myPlaces.add("Ort hinzufuegen");

        locations = new ArrayList<>();
        locations.add(new LatLng(11, 53));

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myPlaces);

        memorablePlaces.setAdapter(arrayAdapter);

        memorablePlaces.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                i.putExtra("locationInfo", position);
                startActivity(i);
            }
        });



    }
}
