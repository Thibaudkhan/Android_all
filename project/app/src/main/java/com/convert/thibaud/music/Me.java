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
        TextView nbVersionTextView = findViewById(R.id.nbVersionTextView);
        nbVersionTextView.setText( "vesion "+BuildConfig.VERSION_NAME );
    }
}
