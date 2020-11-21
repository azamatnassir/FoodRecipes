package com.example.foodrecipes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ActivitySalad extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference docRef = db.collection("salad");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salad);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Choose your food");
        actionBar.setDisplayHomeAsUpEnabled(true);

        textView1 = findViewById(R.id.salad_1);
        textView2 = findViewById(R.id.salad_2);
        textView3 = findViewById(R.id.salad_3);
        textView4 = findViewById(R.id.salad_4);
        textView5 = findViewById(R.id.salad_5);
        textView6 = findViewById(R.id.salad_6);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1();
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2();
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b3();
            }
        });

        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b4();
            }
        });

        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b5();
            }
        });

        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b6();
            }
        });
    }

    public void b1() {
        Intent intent = new Intent(this, ActivityRecipes.class);
        intent.putExtra("number", "1");
        intent.putExtra("type", "salad");
        startActivity(intent);
    }

    public void b2() {
        Intent intent = new Intent(this, ActivityRecipes.class);
        intent.putExtra("number", "2");
        intent.putExtra("type", "salad");
        startActivity(intent);
    }

    public void b3() {
        Intent intent = new Intent(this, ActivityRecipes.class);
        intent.putExtra("number", "3");
        intent.putExtra("type", "salad");
        startActivity(intent);
    }

    public void b4() {
        Intent intent = new Intent(this, ActivityRecipes.class);
        intent.putExtra("number", "4");
        intent.putExtra("type", "salad");
        startActivity(intent);
    }

    public void b5() {
        Intent intent = new Intent(this, ActivityRecipes.class);
        intent.putExtra("number", "5");
        intent.putExtra("type", "salad");
        startActivity(intent);
    }

    public void b6() {
        Intent intent = new Intent(this, ActivityRecipes.class);
        intent.putExtra("number", "6");
        intent.putExtra("type", "salad");
        startActivity(intent);
    }
}