package com.convert.thibaud.music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DifficultyQuizz extends AppCompatActivity {
    int level = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_quizz);
        Intent srcIntent = getIntent();
        int lvl = srcIntent.getIntExtra("level",0);
        level = lvl;
        Button noobButton = findViewById(R.id.noobButton);
        Button ezButton = findViewById(R.id.ezButton);
        Button fanButton = findViewById(R.id.fanButton);
        noobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                difficultyChosed(0,level);
            }
        });
        ezButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                difficultyChosed(1,level);
            }
        });
        fanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                difficultyChosed(2, level);
            }
        });
    }

    // -- Redirect to the good quizz
    public void difficultyChosed(int diff,int level){
        if(level == 0){
            Intent intent = new Intent(DifficultyQuizz.this, MusiqueQuizz.class);
            intent.putExtra("difficulty", diff);
            startActivity(intent);
        }else{
            Intent intent = new Intent(DifficultyQuizz.this, ImageQuizz.class);
            intent.putExtra("difficulty", diff);
            startActivity(intent);
        }

    }

}
