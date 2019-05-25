package com.example.restaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuAdapter extends ArrayAdapter {


    ArrayList<MenuItem> MenuItems;

    public MenuAdapter(Context context, int layout, ArrayList<MenuItem> items_menu) {
        super(context, layout, items_menu);

        this.MenuItems = items_menu;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // A new view must be inflated if it doesn't exist already
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.menu_row, parent, false);
        }

        String item = MenuItems.get(position).toString();
        TextView name_dish = convertView.findViewById(R.id.name_dish);
        TextView price_dish = convertView.findViewById(R.id.price_dish);
        ImageView photo_dish = convertView.findViewById(R.id.photo_dish);

        MenuItem sort_dish = MenuItems.get(position);
        String image_url = sort_dish.getUrl();
        String menu = sort_dish.getMenu_name();
        String price = sort_dish.getPrice().toString();

        name_dish.setText(menu);
        price_dish.setText(price);



        return convertView;

    }

}
