package com.example.tonys.event;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    static ArrayList<String> categoriesList = new ArrayList<String>();
    ArrayList<Event> events = new ArrayList<Event>();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CalendarView calV =(CalendarView) findViewById(R.id.calendarView);

        calV.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year,
                                            int month, int dayOfMonth) {
                ArrayList<String> eventsList = new ArrayList<String>();
                String selectedDate = "";

                if(dayOfMonth < 10){
                    selectedDate += String.valueOf('0');
                }

                selectedDate += String.valueOf((dayOfMonth) +
                        ".");

                if(month < 10){
                    selectedDate += String.valueOf('0');
                }

                selectedDate += String.valueOf((month + 1) +
                        "." + year);

                for (int j = 0; events.size() > j; j++) {
                    if(Objects.equals(events.get(j).getDate(), selectedDate)) {
                        eventsList.add(events.get(j).getName());
                        Snackbar.make(findViewById(R.id.action_sync), events.get(j).getName(),
                                Snackbar.LENGTH_LONG).show();
                    }
                    else{
                        Snackbar.make(findViewById(R.id.action_sync), "Nope",
                                Snackbar.LENGTH_LONG).show();
                    }
                }

                ListView lvEvents = (ListView) findViewById(R.id.lvEvents);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_list_item_1, eventsList);

                lvEvents.setAdapter(adapter);
            }
        });

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

                events.add(new Event(name,date,email,phoneNumber,description,category));

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

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

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
