package com.example.restaurant;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MenuItemsRequest implements Response.Listener<JSONObject>, Response.ErrorListener {

    private String dish;
    private Callback callback;
    private Context context;
    private ArrayList<com.example.restaurant.MenuItem> menu_list = new ArrayList<>();

    public interface Callback {
        void gotMenuItems(ArrayList<MenuItem> categories);
        void gotMenuItemsError(String message);
    }


    MenuItemsRequest(Context context, String dishType) {
        this.context = context;
        this.dish = dishType;
    }

    void getMenuItems(final Callback callback, String dishType){

        String url = "https://resto.mprog.nl/menu";
        this.callback = callback;
        this.dish = dishType;

        RequestQueue requestvolley = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, this, this);
        requestvolley.add(jsonObjectRequest);
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        callback.gotMenuItemsError(error.getMessage());
    }

    @Override
    public void onResponse(JSONObject response) {
        JSONArray array;
        try {

            array = response.getJSONArray("items");
            JSONObject jsonobject;

            // loop over items in menu's
            for (int i = 0; i < array.length(); i++){
                jsonobject = array.getJSONObject(i);
                String category = jsonobject.getString("category");
                if (dish.equals(category)) {

                    String menu_name = jsonobject.getString("name");
                    String description = jsonobject.getString("description");
                    String url = jsonobject.getString("image_url");
                    Double price = jsonobject.getDouble("price");

                    menu_list.add(new MenuItem(menu_name, description, url, price, category));
                }
            }

        }
        catch (JSONException e){

            e.printStackTrace();

        }
        callback.gotMenuItems(menu_list);
    }
}
