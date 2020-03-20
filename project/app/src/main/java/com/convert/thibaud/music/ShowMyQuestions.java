package com.convert.thibaud.music;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ShowMyQuestions extends AppCompatActivity {

    private QuestionItem adapter;
    private Quizz quizz;
    private List<String> allMyQuestions;
    String[] test = {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_my_questions);
        quizz = new Quizz();
        allMyQuestions = quizz.onCreate();
        test = allMyQuestions.toArray(new String[allMyQuestions.size()]);
        adapter = new QuestionItem(test);

        Log.i("List", String.valueOf(allMyQuestions));
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
