package com.convert.thibaud.music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        TextView answearTextView = findViewById(R.id.answearTextView);
        TextView totalTextView = findViewById(R.id.totalTextView);
        TextView diffTextView = findViewById(R.id.diffTextView);
        Intent srcIntent = getIntent();
        int nbAnswear = srcIntent.getIntExtra("goodAnswear",0);
        int diff = srcIntent.getIntExtra("difficulty",0);
        int lengthArr = srcIntent.getIntExtra("length",1);
        answearTextView.setText(nbAnswear+" / "+ lengthArr );
        diffTextView.setText("Difficulty level : "+ diff);
        totalTextView.setText((nbAnswear*100/lengthArr*100)/100 + " %" );

    }
}
