package com.convert.thibaud.music;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuestionItem extends RecyclerView.Adapter<QuestionItem.ViewHolder> {

    private List<String> question;
    String[] test ;

    public QuestionItem(String[] test) {
        this.test = test;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ask.setText(test[position]);


    }

    @Override
    public int getItemCount() {
        return test.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        final TextView ask;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ask = itemView.findViewById(R.id.questionTextView);
        }
    }
}
