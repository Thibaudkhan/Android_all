package com.convert.thibaud.music;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.TypedArrayUtils;

import android.content.Intent;
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

import java.util.Random;
import java.util.*;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.Object;
import java.util.Arrays;

public class ImageQuizz extends AppCompatActivity {
    private RadioGroup radio_group;
    private RadioButton radioButton;
    private MediaPlayer mediaPlayer;
    int random = 0;
    int nbQuestion = 0;
    int goodAnswear = 0;
    int difficulties = 0;
    private boolean firstTime = true;
    List<List<String>> myList = new ArrayList<List<String>>();
    String[][] myArray;
    String[][] myArrayNoob = {{"Qui est sur la photo","Matthew Bellamy","Christopher Wolstenholme","Dominic Howard","Christopher Howard"},{"Qui est sur la photo","Matthew Bellamy","Dominic Howard","Christopher Wolstenholme","Christopher Howard"},{"Qui est sur la photo","Christopher Wolstenholme","Matthew Bellamy","Dominic Howard","Christopher Howard"}};
    String[][] myArrayEz = {{"Qui est sur la photo","Matthew Bellamy","Christopher Wolstenholme","Dominic Howard","Christopher Howard"},{"Qui est sur la photo","Matthew Bellamy","Dominic Howard","Christopher Wolstenholme","Christopher Howard"},{"Qui est sur la photo","Christopher Wolstenholme","Matthew Bellamy","Dominic Howard","Christopher Howard"}};
    String[][] myArrayFan = {{"Qui est sur la photo","Christopher Wolstenholmes","Christopher Wolstenholme","Christophers Wolstenholme","Christopher Wolstehnolme"},{"Qui est sur la photo","Dominique Howard","Dominic Howard","Dominic Clurk","Dominic Clark"},{"Qui est sur la photo","Matt Bellamy","Matthew Bellamy","Mathew Bellamy","Matthew Bellamie"}};
    int[] arrayInt = {R.drawable.chris,R.drawable.dominic,R.drawable.matt};
    int nbTotQuestion = arrayInt.length;
    int difficulty = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_quizz);
        TextView nbQuestionTextView = findViewById(R.id.nbQuestionTextView);
        nbQuestionTextView.setText(nbQuestion + " / "+ nbTotQuestion);
        Intent srcIntent = getIntent();
        int diff = srcIntent.getIntExtra("difficulty",0);
        difficulty = diff;
        choseDiff(diff);
        reset();
        //String temp[][] = myArray;
        //Arrays.sort(temp);


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

    private void initQuizz(int a){
        ArrayList<String> tempArr = new ArrayList<String>();
        tempArr.add(myArray[a][1]);
        tempArr.add(myArray[a][2]);
        tempArr.add(myArray[a][3]);
        tempArr.add(myArray[a][4]);
        Collections.shuffle(tempArr);
        ImageView questionImageView = findViewById(R.id.questionImageView);
        RadioButton radio_button1 = findViewById(R.id.radio_button1);
        RadioButton radio_button2 = findViewById(R.id.radio_button2);
        RadioButton radio_button3 = findViewById(R.id.radio_button3);
        RadioButton radio_button4 = findViewById(R.id.radio_button4);
        questionImageView.setImageResource(arrayInt[a]);
        radio_button1.setText(""+ tempArr.get(0));
        radio_button2.setText(""+ tempArr.get(1));
        radio_button3.setText(""+ tempArr.get(2));
        radio_button4.setText(""+ tempArr.get(3));
        tempArr.remove(a);

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
                    //Toast.makeText(ImageQuizz.this,"Bravo !! ",Toast.LENGTH_SHORT).show();
                }
                reset();



            }
        });
    }



    private void reset(){

            Random rand = new Random();
            if (!firstTime) {
                myArray = remeoveStringOccurence(myArray, random);
                arrayInt = remeoveIntOccurence(arrayInt, random);
                nbQuestion++;
                TextView nbQuestionTextView = findViewById(R.id.nbQuestionTextView);
                nbQuestionTextView.setText(nbQuestion + " / " + nbTotQuestion);

            }
            if(myArray.length < 1){
            Log.i("Quizz","okkkk");
            Intent intent = new Intent(ImageQuizz.this, Score.class);
                intent.putExtra("difficulty",difficulty);
                intent.putExtra("goodAnswear", goodAnswear);
                intent.putExtra("length", nbTotQuestion);

            startActivity(intent);
            }else {
                random = rand.nextInt(myArray.length);


                Log.i("Quizz", "test " + myArray[random][2] + " random " + random);
                //remove(myArray,random);

                initQuizz(random);
                selected(random);
            }
    }

    public String[][]remeoveStringOccurence(String[][] array,int nb){
        return ArrayUtils.remove(array,nb);
    }
    public int[] remeoveIntOccurence(int[] array,int nb){
        return ArrayUtils.remove(array,nb);
    }

}
