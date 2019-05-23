package com.example.restaurant;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.MenuItem;
        import android.widget.ImageView;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements MenuItemsRequest.Callback {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent = getIntent();
        String dish = (String) intent.getSerializableExtra("menu");

        MenuItemsRequest request = new MenuItemsRequest(getApplicationContext(), dish);
//        // link aan listview in main
//        ListView listView = (ListView) findViewById(R.id.listview_menu);
//        listView.setOnItemClickListener(new MenuActivity().ItemClickListener());
    }


    @Override
    public void gotMenuItems(ArrayList<MenuItem> menuItems) {

        MenuAdapter menuAdapter = new MenuAdapter( this, R.id.test, menuItems);
        listView.setAdapter(menuAdapter);
    }

    @Override
    public void gotMenuItemsError(String message) {
//        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
