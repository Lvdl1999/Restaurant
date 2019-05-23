package com.example.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity extends AppCompatActivity implements CategoriesRequest.Callback {


    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        listView = findViewById(R.id.listview);

        CategoriesRequest x = new CategoriesRequest(this);
        x.getCategories(this);

        Toast.makeText(this, "Started", Toast.LENGTH_SHORT).show();

        // link aan listview in main
        listView = (ListView) findViewById(R.id.listview);
        listView.setOnItemClickListener(new ItemClickListener());
    }

    @Override
    public void gotCategories(ArrayList<String> categories) {
        Toast.makeText(this, categories.get(0), Toast.LENGTH_SHORT).show();

        CategoryAdapter categoryAdapter = new CategoryAdapter(this, R.id.test, categories);
        listView.setAdapter(categoryAdapter);
    }

    @Override
    public void gotCategoriesError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    // when clicking on a menu it navigates to next activity with more info
    private class ItemClickListener implements AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

            Intent intent = new Intent(CategoriesActivity.this, MenuActivity.class);
            intent.putExtra("menu", (String) adapterView.getItemAtPosition(position));
            startActivity(intent);
        }
    }

}