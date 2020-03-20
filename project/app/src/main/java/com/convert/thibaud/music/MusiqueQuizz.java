package com.convert.thibaud.music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
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

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MusiqueQuizz extends AppCompatActivity {
    private RadioGroup radio_group;
    private RadioButton radioButton;
    private MediaPlayer mediaPlayer;
    int random = 0;
    int nbQuestion = 0;
    int goodAnswear = 0;
    int difficulties = 0;
    private boolean firstTime = true;
    String[][] myArray;
    String[][] myArrayNoob;
    String[][] myArrayEz;
    String[][] myArrayFan;
    int[] arrayInt = {1};
    int[] arrayIntNoob = {R.raw.mercibis,R.raw.mercibis,R.raw.isolatedsystem};
    int[] arrayIntEz = {R.raw.mercy,R.raw.algorithm,R.raw.plug};
    int[] arrayIntFan = {R.raw.showbiz,R.raw.algorithm,R.raw.plug};
    int nbTotQuestion = arrayInt.length;
    int difficulty = 0;
    Quizz quizz;
    Timer time;
    RadioButton rightAnswear;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musique_quizz);
        TextView nbQuestionTextView = findViewById(R.id.nbQuestionTextView);
        quizz = new Quizz();
        myArrayNoob = quizz.myArrayNoobMusic;
        myArrayEz = quizz.myArrayEzMusic;
        myArrayFan = quizz.myArrayFanMusic;
        Intent srcIntent = getIntent();

        int diff = srcIntent.getIntExtra("difficulty",0);
        difficulty = diff;
        Button playButton = findViewById(R.id.playButton);
        quizz.getAllQuestion(myArrayNoob);
        quizz.getAllQuestion(myArrayEz);
        quizz.getAllQuestion(myArrayFan);
        time = new Timer();

        // -- Restart music when press button replay ( call method play song)
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSong();
            }
        });
        choseDiff(diff);
        nbTotQuestion = arrayInt.length;
        nbQuestionTextView.setText(nbQuestion + " / "+ nbTotQuestion);
        reset();
    }

    // -- Start music first stop song and next to chose the music depend of the random
    private void playSong(){
        stopSong();
        if(mediaPlayer == null){
            Log.i("music","ok "+ arrayInt[random]);
            mediaPlayer = MediaPlayer.create(MusiqueQuizz.this,arrayInt[random]);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopSong();
                }
            });
        }
        mediaPlayer.start();
    }

    //  -- Stop the music and define mediaPLayer to null
    private void stopSong(){
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopSong();
    }

    // -- Depending of the difficulty return the good array ( 1 array for difficulty)
    private String[][] choseDiff(int difficulties){
        if(difficulties == 0){
            myArray = myArrayNoob;
            arrayInt = arrayIntNoob;
        }else if (difficulties == 1){
            myArray = myArrayEz;
            arrayInt = arrayIntEz;
        }else{
            arrayInt = arrayIntFan;
            myArray = myArrayFan;
        }
        return myArray;
    }
    // -- Return the right answer depending of the value of the radio
    public boolean getRightAnswear(RadioButton radio_button,int a){
        return radio_button.getText().equals(myArray[a][2]);
    }

    // -2- Show all the text, image, music and give the right radio_button. Take in argument random int
    private void initQuizz(int rand){
        ArrayList<String> tempArr = new ArrayList<String>();
        tempArr.add(myArray[rand][1]);
        tempArr.add(myArray[rand][2]);
        tempArr.add(myArray[rand][3]);
        tempArr.add(myArray[rand][4]);
        Collections.shuffle(tempArr);
        RadioButton radio_button1 = findViewById(R.id.radio_button1);
        RadioButton radio_button2 = findViewById(R.id.radio_button2);
        RadioButton radio_button3 = findViewById(R.id.radio_button3);
        RadioButton radio_button4 = findViewById(R.id.radio_button4);
        radio_button1.setText(""+ tempArr.get(0));
        radio_button2.setText(""+ tempArr.get(1));
        radio_button3.setText(""+ tempArr.get(2));
        radio_button4.setText(""+ tempArr.get(3));

        rightAnswear = (getRightAnswear(radio_button1,rand))? radio_button1
                : getRightAnswear(radio_button2,rand)? radio_button2
                : getRightAnswear(radio_button3,rand)? radio_button3
                : radio_button4;
        playSong();


    }

    // -3- Check if the radio_button selected are right and if not show the right answer.
    public void selected(int rand ){
        TextView questionTextView = findViewById(R.id.questionTextView);
        Button submitButton = findViewById(R.id.submitButton);
        final RadioGroup radio_group = findViewById(R.id.radio_group);
        final int random = rand;
        questionTextView.setText(myArray[rand][0]+" ");

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstTime = false;
                int id = radio_group.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(id);
                Log.i("Quizz","nice "+myArray[random][2] + "  // "+radioButton.getText());
                if(radioButton.getText().toString().equals(myArray[random][2])){
                    goodAnswear++;
                    reset();
                }// - Show the right answer during 3 seconds and call reset method.
                else
                    {

                    rightAnswear.setBackgroundColor(Color.GREEN);
                    submitButton.setEnabled(false);
                    time.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    rightAnswear.setBackgroundColor(Color.WHITE);
                                    submitButton.setEnabled(true);
                                    reset();
                                }
                            });
                        }
                    },3000);
                }
            }
        });
    }

    // -1- unset previous value of the arrays, define the random value, send values to Score and call other principal method
    private void reset(){
        Random rand = new Random();
        if (!firstTime) {
            myArray = quizz.remeoveStringOccurence(myArray, random);
            arrayInt = quizz.remeoveIntOccurence(arrayInt, random);
            nbQuestion++;
            TextView nbQuestionTextView = findViewById(R.id.nbQuestionTextView);
            nbQuestionTextView.setText(nbQuestion + " / " + nbTotQuestion);

        }
        if(myArray.length < 1){
            emptyArray();
        }else {
            random = rand.nextInt(myArray.length);
            Log.i("Quizz", "test " + myArray[random][2] + " random " + random);
            initQuizz(random);
            selected(random);
        }
    }
    // -- Send the score to Score class
    public void emptyArray(){
            Log.i("Quizz", "okkkk");
            Intent intent = new Intent(MusiqueQuizz.this, Score.class);
            intent.putExtra("difficulty", difficulty);
            intent.putExtra("goodAnswear", goodAnswear);
            intent.putExtra("length", nbTotQuestion);
            startActivity(intent);
    }

}
