package com.convert.thibaud.music;

import java.util.ArrayList;
import java.util.List;

public class Quizz {

    List<String> allMyQuestions = new ArrayList<String>();
    String[][] myArrayNoob = {{"Qui est sur la photo","Matthew Bellamy","Christopher Wolstenholme","Dominic Howard","Christopher Howard"},{"Qui est sur la photo","Matthew Bellamy","Dominic Howard","Christopher Wolstenholme","Christopher Howard"},{"Qui est sur la photo","Christopher Wolstenholme","Matthew Bellamy","Dominic Howard","Christopher Howard"}};
    String[][] myArrayEz = {{"QUoi est sur la photo","Matthew Bellamy","Christopher Wolstenholme","Dominic Howard","Christopher Howard"},{"Qui est sur la photo","Matthew Bellamy","Dominic Howard","Christopher Wolstenholme","Christopher Howard"},{"Qui est sur la photo","Christopher Wolstenholme","Matthew Bellamy","Dominic Howard","Christopher Howard"}};
    String[][] myArrayFan = {{"Que est sur la photo","Christopher Wolstenholmes","Christopher Wolstenholme","Christophers Wolstenholme","Christopher Wolstehnolme"},{"Qui est sur la photo","Dominique Howard","Dominic Howard","Dominic Clurk","Dominic Clark"},{"Qui est sur la photo","Matt Bellamy","Matthew Bellamy","Mathew Bellamy","Matthew Bellamie"}};
    String[][] myArrayNoob2 = {{"Qui est sur la photo","Matthew Bellamy","Christopher Wolstenholme","Dominic Howard","Christopher Howard"},{"Qui est sur la photo","Matthew Bellamy","Dominic Howard","Christopher Wolstenholme","Christopher Howard"},{"Qui est sur la photo","Christopher Wolstenholme","Matthew Bellamy","Dominic Howard","Christopher Howard"}};
    String[][] myArrayEz2 = {{"Qui est sur la photo","Matthew Bellamy","Christopher Wolstenholme","Dominic Howard","Christopher Howard"},{"Qui est sur la photo","Matthew Bellamy","Dominic Howard","Christopher Wolstenholme","Christopher Howard"},{"Qui est sur la photo","Christopher Wolstenholme","Matthew Bellamy","Dominic Howard","Christopher Howard"}};
    String[][] myArrayFan2 = {{"Qui est sur la photo","Christopher Wolstenholmes","Christopher Wolstenholme","Christophers Wolstenholme","Christopher Wolstehnolme"},{"Qui est sur la photo","Dominique Howard","Dominic Howard","Dominic Clurk","Dominic Clark"},{"Qui est sur la photo","Matt Bellamy","Matthew Bellamy","Mathew Bellamy","Matthew Bellamie"}};

    protected List<String> onCreate(){
        getAllQuestion(myArrayNoob);
        getAllQuestion(myArrayEz);
        getAllQuestion(myArrayFan);
        getAllQuestion(myArrayNoob2);
        getAllQuestion(myArrayEz2);
        getAllQuestion(myArrayFan2);

        return allMyQuestions;
    }

    private void getAllQuestion(String[][] array){
        for(int i =0 ; i < array.length; i++){
            allMyQuestions.add(array[i][0]);
        }

    }
}
