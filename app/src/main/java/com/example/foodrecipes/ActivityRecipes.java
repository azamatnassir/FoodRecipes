package com.example.foodrecipes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class ActivityRecipes extends AppCompatActivity {
    private static final String TAG = "ActivityRecipes";

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Recipes");
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        String number = intent.getStringExtra("number");

        TextView textView = findViewById(R.id.name);
        TextView textView1 = findViewById(R.id.ingredient_list);
        TextView textView2 = findViewById(R.id.method_list);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection(type).document(number)
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()){
                            String ingredients = documentSnapshot.getString("ingredients");
                            String instructions = documentSnapshot.getString("method");
                            String name = documentSnapshot.getString("name");

                            textView.setText(name);
                            textView1.setText(ingredients);
                            textView2.setText(instructions);
                        } else {
                            Toast.makeText(ActivityRecipes.this, "Doesn't exist", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ActivityRecipes.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}