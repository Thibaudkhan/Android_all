package com.convert.thibaud.music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button playButton = findViewById(R.id.playButton);


        playButton.setOnClickListener(new View.OnClickListener() {
            // -- redirect to Selected Menu
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, SelectedMenu.class);
                startActivity(intent);
            }
        });
    }
}
