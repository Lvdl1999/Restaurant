package com.example.restaurant;

import android.content.Context;
import android.view.MenuItem;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.ArrayList;

public class MenuItemsRequest implements Response.Listener<JSONObject>, Response.ErrorListener {

    private String dish;
    private Callback callback;
    private Context context;
    private ArrayList<MenuItem> menu_list = new ArrayList<>();

    public interface Callback {
        void gotMenuItems(ArrayList<MenuItem> categories);
        void gotMenuItemsError(String message);
    }


    MenuItemsRequest(Context context, String dishType) {
        this.context = context;
        dish = dishType;
    }



    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }
}
