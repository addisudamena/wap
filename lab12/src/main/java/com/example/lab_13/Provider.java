package com.example.lab_13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Provider {

    private static List<Quiz> quizzes= new ArrayList<Quiz>();



    public static List<Quiz> getQuize(){

        quizzes.add(new Quiz("1,2,3,4,5","6"));
        quizzes.add(new Quiz("1,1,2,3,5","8"));
        quizzes.add(new Quiz("1,4,9,16,25","36"));
        quizzes.add(new Quiz("1,3,6,10,15","21"));//triangular number
        quizzes.add(new Quiz("1,2,4,7,11","16"));//max n cut
        quizzes.add(new Quiz("1,11,21,1211,111221,312211","13112221"));
        Collections.shuffle(quizzes);
        return quizzes;

    }

}
