package com.example.pizzano_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MenuDisplay extends AppCompatActivity {



        GridView grid;
        String[] menu=
                {
                        "Pizzas",
                        "Speciality",
                        "Meatless Pizzas",
                        "Meals",
                        "Fried Chicken",
                        "Deals",
                        "Roll & Shawarma",
                        "Garlic Bread",
                        "Chinese",
                        "Sandwich",
                        "Nuggets",
                        "Fires",
                        "Hot Wings",
                        "Drinks"

                };
        int[] Imageid=
                {
                        R.drawable.pizza,
                        R.drawable.special,
                        R.drawable.meatless_pizza,
                        R.drawable.food_meals,
                        R.drawable.fried_chicken,
                        R.drawable.deals,
                        R.drawable.shawarma,
                        R.drawable.garlic_bread,
                        R.drawable.chinese,
                        R.drawable.sandwich,
                        R.drawable.nuggets,
                        R.drawable.fries,
                        R.drawable.hotwings,
                        R.drawable.cold_drinks

                };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_display);
        CustomAdapter adapter=new CustomAdapter(MenuDisplay.this, menu,Imageid);
        grid=(GridView)findViewById(R.id.menuGrid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(MenuDisplay.this,"You Clicked at " +menu[+position],
                        Toast.LENGTH_SHORT).show();


            }
        });

    }
}
