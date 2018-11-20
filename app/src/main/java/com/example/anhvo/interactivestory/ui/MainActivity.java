package com.example.anhvo.interactivestory.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.anhvo.interactivestory.R;

public class MainActivity extends AppCompatActivity {

    private Button startButton;
    private EditText nameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.nameEditText);
        startButton = findViewById(R.id.startButton);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameField.getText().toString();
                startStory(name);
                //Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
            }
        };

        startButton.setOnClickListener(listener);

    }

    private void startStory(String name) {
        Intent  intent = new Intent(this, StoryActivity.class);
        Resources resources = getResources();
        String key = resources.getString(R.string.key_name);

        intent.putExtra(key, name);
        startActivity(intent);

    }
}