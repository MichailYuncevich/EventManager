package com.example.tonys.event;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by TonyS on 16-May-17.
 */

public class EventActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_event);
        Button saveButton = (Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

                Intent intent = new Intent(EventActivity.this, MainActivity.class);
                intent.putExtra("com.example.tonys.event.username", name);
                intent.putExtra("com.example.tonys.event.date", date);
                intent.putExtra("com.example.tonys.event.email", email);
                intent.putExtra("com.example.tonys.event.phoneNumber", phoneNumber);
                intent.putExtra("com.example.tonys.event.description", description);
                intent.putExtra("com.example.tonys.event.category", category);
                setResult(RESULT_OK, intent);
                finish();
                //startActivity(intent);
            }
        });
    }
}
