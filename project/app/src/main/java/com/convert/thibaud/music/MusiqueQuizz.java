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
    List<String> allMyQuestions = new ArrayList<String>();
    int[] arrayInt = {R.raw.showbiz,R.raw.algorithm,R.raw.plug};
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
        myArrayNoob = quizz.myArrayNoob2;
        myArrayEz = quizz.myArrayEz2;
        myArrayFan = quizz.myArrayFan2;
        nbQuestionTextView.setText(nbQuestion + " / "+ nbTotQuestion);
        Intent srcIntent = getIntent();

        int diff = srcIntent.getIntExtra("difficulty",0);
        difficulty = diff;
        Button playButton = findViewById(R.id.playButton);
        quizz.getAllQuestion(myArrayNoob);
        quizz.getAllQuestion(myArrayEz);
        quizz.getAllQuestion(myArrayFan);
        time = new Timer();

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        choseDiff(diff);
        reset();
    }

    private void getAllQuestion(String[][] array){
        for(int i =0 ; i < array.length; i++){
            allMyQuestions.add(array[i][0]);
        }
    }

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

    private String[][] choseDiff(int difficulties){
        if(difficulties == 0){
            myArray = myArrayNoob;
        }else if (difficulties == 1){
            myArray = myArrayEz;
        }else{
            myArray = myArrayFan;
        }
        return myArray;
    }
    public boolean getRightAnswear(RadioButton radio_button,int a){
        return radio_button.getText().equals(myArray[a][2]);
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

        rightAnswear = (getRightAnswear(radio_button1,a))? radio_button1
                : getRightAnswear(radio_button2,a)? radio_button2
                : getRightAnswear(radio_button3,a)? radio_button3
                : radio_button4;
        playSong();


    }

    public void selected(int a ){
        TextView questionTextView = findViewById(R.id.questionTextView);
        Button submitButton = findViewById(R.id.submitButton);
        final RadioGroup radio_group = findViewById(R.id.radio_group);
        final int random = a;
        questionTextView.setText(myArray[a][0]+" ");

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
                }else{

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
            Log.i("Quizz","okkkk");
            Intent intent = new Intent(MusiqueQuizz.this, Score.class);
            intent.putExtra("difficulty",difficulty);
            intent.putExtra("goodAnswear", goodAnswear);
            intent.putExtra("length", nbTotQuestion);
            startActivity(intent);
        }else {
            random = rand.nextInt(myArray.length);
            Log.i("Quizz", "test " + myArray[random][2] + " random " + random);
            initQuizz(random);
            selected(random);
        }
    }

}
