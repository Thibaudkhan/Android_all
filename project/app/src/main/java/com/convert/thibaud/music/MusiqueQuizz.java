package com.convert.thibaud.music;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MusiqueQuizz extends AppCompatActivity {
    private RadioGroup radio_group;
    private RadioButton radioButton;
    private MediaPlayer mediaPlayer;
    String[][] myArray = {{"Quelle musique","Matthew Bellamy","Showbiz","Dominic Howard","Christopher Howard"},{"Quelle musique","Matthew Bellamy","Algorithm","Christopher Wolstenholme","Christopher Howard"},{"Quelle musique","Christopher Wolstenholme","Plug in Baby","Dominic Howard","Christopher Howard"}};
    int[] arrayInt = {R.raw.showbiz,R.raw.algorithm,R.raw.plug};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musique_quizz);
        Random rand = new Random();
        final int random = rand.nextInt(myArray.length);
        Button playButton = findViewById(R.id.playButton);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer == null){
                    mediaPlayer = MediaPlayer.create(MusiqueQuizz.this,arrayInt[random]);
                    mediaPlayer.start();
                }
            }
        });
        //String temp[][] = myArray;
        //Arrays.sort(temp);
        initQuizz(random);
        selected(random);

    }
    private void initQuizz(int a){
        ArrayList<String> tempArr = new ArrayList<String>();
        tempArr.add(myArray[a][1]);
        tempArr.add(myArray[a][2]);
        tempArr.add(myArray[a][3]);
        tempArr.add(myArray[a][4]);
        Collections.shuffle(tempArr);
        RadioButton radio_button1 = findViewById(R.id.radio_button1);
        RadioButton radio_button2 = findViewById(R.id.radio_button2);
        RadioButton radio_button3 = findViewById(R.id.radio_button3);
        RadioButton radio_button4 = findViewById(R.id.radio_button4);
        radio_button1.setText(""+ tempArr.get(0));
        radio_button2.setText(""+ tempArr.get(1));
        radio_button3.setText(""+ tempArr.get(2));
        radio_button4.setText(""+ tempArr.get(3));

    }

    public void selected(int a ){
        TextView questionTextView = findViewById(R.id.questionTextView);
        Button submitButton = findViewById(R.id.submitButton);
        final RadioGroup radio_group = findViewById(R.id.radio_group);
        final int random = a;
        questionTextView.setText(myArray[1][0]+" ");

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = radio_group.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(id);
                Log.i("Quizz","nice "+myArray[random][2] + "  // "+radioButton.getText());
                if(radioButton.getText().toString().equals(myArray[random][2])){
                    Log.i("Quizz","okkkk");
                }

            }
        });
    }



}
