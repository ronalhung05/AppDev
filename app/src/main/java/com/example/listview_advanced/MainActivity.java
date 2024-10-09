package com.example.listview_advanced;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<City> cityArrayList;
    ListView lvCity;
    CityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the ListView and ArrayList
        lvCity = findViewById(R.id.lvCity);
        cityArrayList = new ArrayList<>(); // Initialize the ArrayList

        // Add City objects to the ArrayList
        cityArrayList.add(new City("London", R.drawable.london, "https://en.wikipedia.org/wiki/London"));
        cityArrayList.add(new City("Paris", R.drawable.paris, "https://en.wikipedia.org/wiki/Paris"));
        cityArrayList.add(new City("Tokyo", R.drawable.tokyo, "https://en.wikipedia.org/wiki/Tokyo"));

        // Set up the adapter
        adapter = new CityAdapter(this, R.layout.dong_thanh_pho, cityArrayList);
        lvCity.setAdapter(adapter);

        // Apply window insets to adjust padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
