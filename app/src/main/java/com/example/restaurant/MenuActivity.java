package com.example.restaurant;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.io.Serializable;
        import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements MenuItemsRequest.Callback{


    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent = getIntent();
        String dish = (String) intent.getSerializableExtra("menu");
        MenuItemsRequest request = new MenuItemsRequest(getApplicationContext(), dish);
        request.getMenuItems(this, dish);
        listView = findViewById(R.id.listview_menu);
        listView.setOnItemClickListener(new ListClickListener());
    }


    @Override
    public void gotMenuItems(ArrayList<MenuItem> menuItems) {

        MenuAdapter menuAdapter = new MenuAdapter( this, R.id.test, menuItems);
        listView.setAdapter(menuAdapter);
    }

    @Override
    public void gotMenuItemsError(String message) {
         Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


    // when clicking on a menu it navigates to next activity with more info
    public class ListClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

            Intent intent = new Intent(MenuActivity.this, MenuItemActivity.class);
            intent.putExtra("sort_menu", (Serializable) adapterView.getItemAtPosition(position));
            startActivity(intent);
        }
    }

}
