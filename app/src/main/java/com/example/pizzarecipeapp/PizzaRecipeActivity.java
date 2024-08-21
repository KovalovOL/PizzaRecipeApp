package com.example.pizzarecipeapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PizzaRecipeActivity extends AppCompatActivity {

    ImageView pizzaImageImageView;
    TextView pizzaNameTextView;
    TextView pizzaDescribeTextView;
    TextView pizzaRecipeTextView;

    ImageView backImageView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pizza_recipe);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pizzaRecipeBg), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent reseivedIntent = getIntent();

        pizzaImageImageView = findViewById(R.id.pizzaImageRecipe);
        pizzaNameTextView = findViewById(R.id.pizzaNameRecipe);
        pizzaDescribeTextView = findViewById(R.id.pizzaDescribeRecipe);
        pizzaRecipeTextView = findViewById(R.id.pizzaRecipe);

        pizzaImageImageView.setImageResource(reseivedIntent.getIntExtra("pizzaImage", 0));
        pizzaNameTextView.setText(reseivedIntent.getStringExtra("pizzaName"));
        pizzaDescribeTextView.setText(reseivedIntent.getStringExtra("pizzaDescribe"));
        pizzaRecipeTextView.setText(reseivedIntent.getStringExtra("pizzaRecipe"));

        backImageView = findViewById(R.id.backButton);

    }

    public void Back(View view) {
        Intent intent = new Intent(PizzaRecipeActivity.this, MainActivity.class);
        startActivity(intent);
    }
}