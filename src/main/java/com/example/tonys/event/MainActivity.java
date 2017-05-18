package com.example.tonys.event;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Event> events = new ArrayList<Event>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fabEdditing = (FloatingActionButton) findViewById(R.id.fabAdding);
        fabEdditing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EventActivity.class);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra("com.example.tonys.event.username"),
                        date = data.getStringExtra("com.example.tonys.event.date"),
                        email = data.getStringExtra("com.example.tonys.event.email"),
                        phoneNumber = data.getStringExtra("com.example.tonys.event.phoneNumber"),
                        description = data.getStringExtra("com.example.tonys.event.description"),
                        category = data.getStringExtra("com.example.tonys.event.category");

                Snackbar.make(findViewById(R.id.action_sync),name + " " +
                                date + " " +
                                email + " " +
                                phoneNumber + " " +
                                description + " " +
                                category
                        ,Snackbar.LENGTH_LONG).show();
            } else {
                Snackbar.make(findViewById(R.id.action_sync),"empty",Snackbar.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id){
            case R.id.action_sync:{
                final View content = findViewById(R.id.action_sync);
                Snackbar.make(content, "Synchronized", Snackbar.LENGTH_SHORT).show();
            }break;

            case R.id.action_bin:{
                final View content = findViewById(R.id.action_sync);
                Snackbar.make(content, "Open activity_bin", Snackbar.LENGTH_SHORT).show();
            }break;

            case R.id.action_settings:{
                final View content = findViewById(R.id.action_sync);
                Snackbar.make(content, "Open activity_setting", Snackbar.LENGTH_SHORT).show();
            }break;

            case R.id.action_templates:{
                final View content = findViewById(R.id.action_sync);
                Snackbar.make(content, "Open activity_categories", Snackbar.LENGTH_SHORT).show();
            }break;
        }


        return super.onOptionsItemSelected(item);
    }
}
