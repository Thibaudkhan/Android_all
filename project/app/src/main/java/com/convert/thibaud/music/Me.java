package com.convert.thibaud.music;

import androidx.appcompat.app.AppCompatActivity;
import com.convert.thibaud.music.BuildConfig;

import android.os.Bundle;
import android.widget.TextView;

public class Me extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        //String versionName = BuildConfig.VERSION_NAME;
        TextView nbVersionTextView = findViewById(R.id.nbVersionTextView);
        nbVersionTextView.setText( BuildConfig.VERSION_NAME + " ");
    }
}
