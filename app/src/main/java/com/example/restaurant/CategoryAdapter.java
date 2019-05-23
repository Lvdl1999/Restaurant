package com.example.restaurant;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoryAdapter extends ArrayAdapter {

    ArrayList categories;

    public CategoryAdapter(Context context, int layout, ArrayList<String> dish_sorts) {
        super(context, layout, dish_sorts);

        categories = dish_sorts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // A new view must be inflated if it doesn't exist already
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.dish_row, parent, false);
        }

        TextView dish_text = convertView.findViewById(R.id.test);
        String dish = categories.get(position).toString();
        dish_text.setText(dish);

        return convertView;

    }

}
