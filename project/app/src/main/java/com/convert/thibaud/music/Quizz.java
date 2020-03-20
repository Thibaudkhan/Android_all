package com.convert.thibaud.music;

import android.widget.RadioButton;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class Quizz {

    List<String> allMyQuestions = new ArrayList<String>();
    String[][] myArrayNoob = {{"Qui est sur la photo","Matthew Bellamy","Christopher Wolstenholme","Dominic Howard","Christopher Howard"},{"Quel est le premier album de Muse","Bliss","Showbiz","Origin of symetry","Drones"},{"Qui est sur la photo","Christopher Wolstenholme","Matthew Bellamy","Dominic Howard","Christopher Howard"}};
    String[][] myArrayEz = {{"Quel est le nom de cette album","2Law","Drones","Origin of symetry","Showbiz"},{"En quelle année est sortie cette album","1999","2001","2000","2002"},{"Qui est sur la photo","Christopher Wolstenholme","Matthew Bellamy","Dominic Howard","Christopher Howard"}};
    String[][] myArrayFan = {{"Quel est le nom de la guitarre utilisé par Matthew en concert","Mason MB","Mason MB-1","Suhr MB","Suhr BM"},{"Comment s'appelle cette chanson","Bliss","Plug In Baby","New Born","2LAw"},{"Qui est sur la photo","Matt Bellamy","Matthew Bellamy","Mathew Bellamy","Matthew Bellamie"}};
    String[][] myArrayNoobMusic = {{"Quelle est la chanson","2Law","Unnatural Selection","Butterflies And hurrican","Come as you are"},{"En quelle année est sorti cette chanson","1999","2001","2007","2005"},{"Quelle est la chanson","Ressistance","Plug In baby","Hysteria","Madness"}};
    String[][] myArrayEzMusic = {{"Dans quelle album et cette chanson","Origin of Symetry","Showbiz","Drone","2Law"},{"Quelle est la chanson","Resistance","Algorithm","Absolution","Drones"},{"En quelle année est sorti l'album de cette chanson","1999","2001","2007","2005"}};
    String[][] myArrayFanMusic = {{"Quelle est le titre de cette chanson","New Born","Showbiz","Thought Contagion","Psycho"},{"Quelle est sa position dans l'albmum","3","1","11","7"},{"Quelle est son classement comme meilleur morceau de guitare au monde  cf -2005","5","44","27","79"}};
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
