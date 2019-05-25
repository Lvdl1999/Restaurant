package com.example.restaurant;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.restaurant.MenuItem;
import com.example.restaurant.R;

import org.w3c.dom.Text;

public class MenuItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item);

        Intent intent = getIntent();
        MenuItem menuItem = (MenuItem) intent.getSerializableExtra("sort_menu");

        TextView name = findViewById(R.id.name);
        TextView description = findViewById(R.id.description);
        TextView price = findViewById(R.id.price);

        name.setText(menuItem.getMenu_name());
        description.setText(menuItem.getMenu_description());
        price.setText(menuItem.getPrice().toString());



    }
}
