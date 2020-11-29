package com.example.menuactvty;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView contListView;
    private String[] contacts = {"Amina", "Asya", "Ayana", "Ayazhan", "Gaziza"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contListView = findViewById(R.id.lv_Contacts);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, contacts
        );
        contListView.setAdapter(adapter);
        registerForContextMenu(contListView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Select Action");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.call_action:
                Toast.makeText(this, "You are calling", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sms_action:
                Toast.makeText(this, "You are typing SMS", Toast.LENGTH_SHORT).show();
                break;
            case R.id.edit_action:
                Toast.makeText(this, "You are editing Contact", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete_action:
                Toast.makeText(this, "You are deleting Contact", Toast.LENGTH_SHORT).show();
                break;
            case R.id.favorite_action:
                Toast.makeText(this, "Added to favorite successfully", Toast.LENGTH_SHORT).show();
                break;
            case R.id.blacklist_action:
                Toast.makeText(this, "Contact has been blacklisted", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_settings:
                Toast.makeText(this, "Settings menu clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_save:
                Toast.makeText(this, "Save menu clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_open:
                Toast.makeText(this, "Open menu clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_forward:
                Toast.makeText(this, "You are moving forward", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_back:
                Toast.makeText(this, "You are moving back", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_move:
                Toast.makeText(this, "Move menu clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_delete:
                Toast.makeText(this, "Delete menu clicked", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}