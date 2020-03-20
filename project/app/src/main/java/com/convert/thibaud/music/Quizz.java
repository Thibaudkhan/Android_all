package com.convert.thibaud.music;

import android.widget.RadioButton;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class Quizz {

    List<String> allMyQuestions = new ArrayList<String>();
    String[][] myArrayNoob = {{"Qui est sur la photo","Matthew Bellamy","Christopher Wolstenholme","Dominic Howard","Christopher Howard"},{"Qui est sur la photo","Matthew Bellamy","Dominic Howard","Christopher Wolstenholme","Christopher Howard"},{"Qui est sur la photo","Christopher Wolstenholme","Matthew Bellamy","Dominic Howard","Christopher Howard"}};
    String[][] myArrayEz = {{"QUoi est sur la photo","Matthew Bellamy","Christopher Wolstenholme","Dominic Howard","Christopher Howard"},{"Qui est sur la photo","Matthew Bellamy","Dominic Howard","Christopher Wolstenholme","Christopher Howard"},{"Qui est sur la photo","Christopher Wolstenholme","Matthew Bellamy","Dominic Howard","Christopher Howard"}};
    String[][] myArrayFan = {{"Que est sur la photo","Christopher Wolstenholmes","Christopher Wolstenholme","Christophers Wolstenholme","Christopher Wolstehnolme"},{"Qui est sur la photo","Dominique Howard","Dominic Howard","Dominic Clurk","Dominic Clark"},{"Qui est sur la photo","Matt Bellamy","Matthew Bellamy","Mathew Bellamy","Matthew Bellamie"}};
    String[][] myArrayNoobMusic = {{"Qui est sur la photo","Matthew Bellamy","Christopher Wolstenholme","Dominic Howard","Christopher Howard"},{"Qui est sur la photo","Matthew Bellamy","Dominic Howard","Christopher Wolstenholme","Christopher Howard"},{"Qui est sur la photo","Christopher Wolstenholme","Matthew Bellamy","Dominic Howard","Christopher Howard"}};
    String[][] myArrayEzMusic = {{"Qui est sur la photo","Matthew Bellamy","Christopher Wolstenholme","Dominic Howard","Christopher Howard"},{"Qui est sur la photo","Matthew Bellamy","Dominic Howard","Christopher Wolstenholme","Christopher Howard"},{"Qui est sur la photo","Christopher Wolstenholme","Matthew Bellamy","Dominic Howard","Christopher Howard"}};
    String[][] myArrayFanMusic = {{"Qui est sur la photo","Christopher Wolstenholmes","Christopher Wolstenholme","Christophers Wolstenholme","Christopher Wolstehnolme"},{"Qui est sur la photo","Dominique Howard","Dominic Howard","Dominic Clurk","Dominic Clark"},{"Qui est sur la photo","Matt Bellamy","Matthew Bellamy","Mathew Bellamy","Matthew Bellamie"}};
    protected List<String> onCreate(){
        getAllQuestion(myArrayNoob);
        getAllQuestion(myArrayEz);
        getAllQuestion(myArrayFan);
        getAllQuestion(myArrayNoobMusic);
        getAllQuestion(myArrayEzMusic);
        getAllQuestion(myArrayFanMusic);

        return allMyQuestions;
    }

    public void getAllQuestion(String[][] array){
        for(int i =0 ; i < array.length; i++){
            allMyQuestions.add(array[i][0]);
        }
    }

    public String[][]remeoveStringOccurence(String[][] array,int nb){
        return ArrayUtils.remove(array,nb);
    }
    public int[] remeoveIntOccurence(int[] array,int nb){
        return ArrayUtils.remove(array,nb);
    }

}
