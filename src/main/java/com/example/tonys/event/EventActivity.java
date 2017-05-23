package com.example.tonys.event;

import android.app.Activity;
import android.content.Intent;
import android.icu.util.GregorianCalendar;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by TonyS
 */

public class EventActivity extends Activity{
    ArrayList<String> categoriesList= new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        String[] data = {"one", "two", "three", "four", "five"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setPrompt("Categories");
        spinner.setSelection(0);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view,
//                                       int position, long id) {
//                Snackbar.make(findViewById(R.id.saveButton), "Position = " + position,
//                        Snackbar.LENGTH_LONG).show();
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//            }
//        });

        Button saveButton = (Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean inputError = false;

                EditText editName = (EditText)findViewById(R.id.editName);
                EditText editDate = (EditText)findViewById(R.id.editDate);
                EditText editEmail = (EditText)findViewById(R.id.editEmail);
                EditText editPhoneNumber = (EditText)findViewById(R.id.editPhoneNumber);
                EditText editDescription = (EditText)findViewById(R.id.editDescription);
                EditText editCategory = (EditText)findViewById(R.id.editCategory);

                String  name = editName.getText().toString(),
                        date = editDate.getText().toString(),
                        email = editEmail.getText().toString(),
                        phoneNumber = editPhoneNumber.getText().toString(),
                        description = editDescription.getText().toString(),
                        category = editCategory.getText().toString();

                int day = Integer.parseInt((String) date.subSequence(0,2));
                int month = Integer.parseInt((String) date.subSequence(3,5));
                int year = Integer.parseInt((String) date.subSequence(6,10));

                if(day > 31){
                    inputError = true;
                    Snackbar.make(findViewById(R.id.saveButton),"Day > 31", Snackbar.LENGTH_LONG).show();
                }


                if(month > 12){
                    inputError = true;
                    Snackbar.make(findViewById(R.id.saveButton),"Month > 12", Snackbar.LENGTH_LONG).show();
                }

                Calendar c = Calendar.getInstance();
                int yearCurrent = c.get(Calendar.YEAR);
                if(year < yearCurrent){
                    inputError = true;
                    Snackbar.make(findViewById(R.id.saveButton),(year +" < " + yearCurrent), Snackbar.LENGTH_LONG).show();
                }

                if(!inputError){
                    Intent intent = new Intent(EventActivity.this, MainActivity.class);
                    intent.putExtra("com.example.tonys.event.username", name);
                    intent.putExtra("com.example.tonys.event.date", date);
                    intent.putExtra("com.example.tonys.event.email", email);
                    intent.putExtra("com.example.tonys.event.phoneNumber", phoneNumber);
                    intent.putExtra("com.example.tonys.event.description", description);
                    intent.putExtra("com.example.tonys.event.category", category);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}
