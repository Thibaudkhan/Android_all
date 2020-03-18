package com.convert.thibaud.music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectedMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_menu);

        Button songButton = findViewById(R.id.songButton);
        Button imageButton = findViewById(R.id.imageButton);
        Button meButton = findViewById(R.id.meButton);


        songButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectedMenu.this, MusiqueQuizz.class);
                startActivity(intent);
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectedMenu.this, ImageQuizz.class);
                startActivity(intent);
            }
        });
        meButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectedMenu.this, Me.class);
                startActivity(intent);
            }
        });
    }
}
