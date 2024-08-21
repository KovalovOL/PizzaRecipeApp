package com.example.pizzarecipeapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<PizzaItem> pizzaItemArrayList;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        pizzaItemArrayList = new ArrayList<>();
        createStartPizzas();

        recyclerView = findViewById(R.id.recyclerView);
        MyAdapter myAdapter = new MyAdapter(this, pizzaItemArrayList);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    void createStartPizzas() {
        pizzaItemArrayList.add(new PizzaItem(
                R.drawable.marghuerita1,
                getString(R.string.pizza1_name),
                getString(R.string.pizza1_describe),
                getString(R.string.pizza1_recipe)
        ));

        pizzaItemArrayList.add(new PizzaItem(
              R.drawable.pizza2,
              getString(R.string.pizza2_name),
                getString(R.string.pizza2_describe),
                getString(R.string.pizza2_recipe)

        ));

        pizzaItemArrayList.add(new PizzaItem(
                R.drawable.pizza3,
                getString(R.string.pizza3_name),
                getString(R.string.pizza3_describe),
                getString(R.string.pizza3_recipe)
        ));

        pizzaItemArrayList.add(new PizzaItem(
                R.drawable.pizza4,
                getString(R.string.pizza4_name),
                getString(R.string.pizza4_describe),
                getString(R.string.pizza4_recipe)
        ));

        pizzaItemArrayList.add(new PizzaItem(
                R.drawable.pizza5,
                getString(R.string.pizza5_name),
                getString(R.string.pizza5_describe),
                getString(R.string.pizza5_recipe)
        ));

        pizzaItemArrayList.add(new PizzaItem(
                R.drawable.pizza6,
                getString(R.string.pizza6_name),
                getString(R.string.pizza6_describe),
                getString(R.string.pizza6_recipe)
        ));

        pizzaItemArrayList.add(new PizzaItem(
                R.drawable.pizza7,
                getString(R.string.pizza7_name),
                getString(R.string.pizza7_describe),
                getString(R.string.pizza7_recipe)
        ));
    }
}