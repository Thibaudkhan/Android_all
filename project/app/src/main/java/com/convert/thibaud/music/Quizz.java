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
    String[][] myArrayNoobMusic = {{"Quelle est la chanson","Matthew Bellamy","Unnatural Selection","Dominic Howard","Christopher Howard"},{"En quelle année est sorti cette chanson","Matthew Bellamy","Dominic Howard","Christopher Wolstenholme","Christopher Howard"},{"Quelle est la chanson","Christopher Wolstenholme","Matthew Bellamy","Dominic Howard","Christopher Howard"}};
    String[][] myArrayEzMusic = {{"Dans quelle album et cette chanson","Matthew Bellamy","Christopher Wolstenholme","Dominic Howard","Christopher Howard"},{"Quelle est la chanson","Matthew Bellamy","Dominic Howard","Christopher Wolstenholme","Christopher Howard"},{"En quelle année est sorti l'album de cette chanson","Christopher Wolstenholme","Matthew Bellamy","Dominic Howard","Christopher Howard"}};
    String[][] myArrayFanMusic = {{"Quelle est le nom de cette chanson","New Born","Showbiss","Thought Contagion","Psycho"},{"Quelle est le classement de cette chanson d'après XFMs 1000","7","9","14","4"},{"Quelle est son classement comme meilleur morceau de guitare au monde  cf -2005","5","44","27","79"}};
    protected List<String> onCreate(){
        getAllQuestion(myArrayNoob);
        getAllQuestion(myArrayEz);
        getAllQuestion(myArrayFan);
        getAllQuestion(myArrayNoobMusic);
        getAllQuestion(myArrayEzMusic);
        getAllQuestion(myArrayFanMusic);

        return allMyQuestions;
    }
    // --  take all the questions and insert un "main questions"
    public void getAllQuestion(String[][] array){
        for(int i =0 ; i < array.length; i++){
            allMyQuestions.add(array[i][0]);
        }
    }

    // -- unset string value
    public String[][]remeoveStringOccurence(String[][] array,int nb){
        return ArrayUtils.remove(array,nb);
    }
    // -- unset int value
    public int[] remeoveIntOccurence(int[] array,int nb){
        return ArrayUtils.remove(array,nb);
    }

}
