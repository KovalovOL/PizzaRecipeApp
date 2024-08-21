package com.example.pizzarecipeapp;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

   private ArrayList arrayList;
   private ImageView pizzaImage;
   private TextView pizzaName;
   private TextView pizzaDescribe;
   private Context parentContext;

    public MyAdapter(Context parent, ArrayList<PizzaItem> arrayList) {
        parentContext = parent;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.pizza_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PizzaItem pizzaItem = (PizzaItem) arrayList.get(position);

        pizzaImage.setImageResource(pizzaItem.getImage());
        pizzaName.setText(pizzaItem.getPizzaName());
        pizzaDescribe.setText(pizzaItem.getPizzaDescribe());
    }

    @Override
    public int getItemCount() {
       return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            pizzaImage = itemView.findViewById(R.id.pizzaImage);
            pizzaName = itemView.findViewById(R.id.pizzaName);
            pizzaDescribe = itemView.findViewById(R.id.pizzaDescribe);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(parentContext, PizzaRecipeActivity.class);

                    int pizzaImageResource = ((PizzaItem) arrayList.get(getAdapterPosition()))
                            .getImage();

                    intent.putExtra("pizzaImage", pizzaImageResource);
                    intent.putExtra("pizzaName", pizzaName.getText());
                    intent.putExtra("pizzaDescribe", pizzaDescribe.getText());
                    intent.putExtra("pizzaRecipe",
                            ((PizzaItem) arrayList.get(getAdapterPosition())).getRecipe());

                    parentContext.startActivity(intent);
                }
            });
        }

        void bind(int listIndex) {
            PizzaItem pizzaItem = (PizzaItem) arrayList.get(listIndex);

            pizzaImage.setImageResource(pizzaItem.getImage());
            pizzaName.setText(pizzaItem.getPizzaName());
            pizzaDescribe.setText(pizzaItem.getPizzaDescribe());
        }
    }
}
