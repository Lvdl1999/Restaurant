package com.example.restaurant;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CategoriesRequest implements Response.Listener<JSONObject>, Response.ErrorListener {
    ArrayList<String> list_categories = new ArrayList<>();
    Context context;
    Callback callback;

//    downloads van een server en returnt een lijst van strings
// interface that contains the categories

//    Dit zegt wat de Callback terug zou moeten geven en methods beschrijven hoe
    public interface Callback {
        void gotCategories(ArrayList<String> categories);
        void gotCategoriesError(String message);
    }

    //    Constructor that accepts Context context parameter
    CategoriesRequest(Context context) {
        this.context = context;
        Log.d("test1", "CategoriesRequest: ");
    }

    public void getCategories(Callback activity){
        this.callback = activity;

        Log.d("test2", "CategoriesRequest: ");
        String categories_url = "https://resto.mprog.nl/categories";
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(categories_url,
                null, this, this);
        queue.add(jsonObjectRequest);
    }

    // Method when something goes wrong returns an error
    @Override
    public void onErrorResponse(VolleyError error) {
        callback.gotCategoriesError(error.getMessage());
        error.printStackTrace();
    }

    // Method when everything goes as expected returns the JSON object
    @Override
    public void onResponse(JSONObject response) {
        JSONArray jsonarray;

        try {
            jsonarray = response.getJSONArray("categories");
            int length = jsonarray.length();
            for (int i = 0; i < length; i=i+1) {
                list_categories.add(jsonarray.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        callback.gotCategories(list_categories);
    }


}
