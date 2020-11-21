package com.example.foodrecipes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Choose food type");
        actionBar.setDisplayHomeAsUpEnabled(true);

        ImageView soup = findViewById(R.id.soup);
        ImageView second_course = findViewById(R.id.second_course);
        ImageView salad = findViewById(R.id.salad);
        ImageView baking = findViewById(R.id.baking);
        ImageView drinks = findViewById(R.id.drinks);
        ImageView desserts = findViewById(R.id.desserts);
        ImageView fast_food = findViewById(R.id.fast_food);

        soup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openActivitySoup();
            }
        });

        second_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivitySecondCourse();
            }
        });

        salad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivitySalad();
            }
        });

        baking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityBaking();
            }
        });

        drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityDrinks();
            }
        });

        desserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityDesserts();
            }
        });

        fast_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityFastfood();
            }
        });
    }

    public void openActivitySoup(){
        Intent intent = new Intent(this, ActivitySoup.class);
        startActivity(intent);
    }

    public void openActivitySecondCourse(){
        Intent intent = new Intent(this, ActivitySecondCourse.class);
        startActivity(intent);
    }

    public void openActivitySalad(){
        Intent intent = new Intent(this, ActivitySalad.class);
        startActivity(intent);
    }

    public void openActivityBaking(){
        Intent intent = new Intent(this, ActivityBaking.class);
        startActivity(intent);
    }

    public void openActivityDrinks(){
        Intent intent = new Intent(this, ActivityDrinks.class);
        startActivity(intent);
    }

    public void openActivityDesserts(){
        Intent intent = new Intent(this, ActivityDesserts.class);
        startActivity(intent);
    }

    public void openActivityFastfood(){
        Intent intent = new Intent(this, ActivityFastfood.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_view, menu);
        MenuItem menuItem = menu.findItem(R.id.search_view);

        return super.onCreateOptionsMenu(menu);
    }
}