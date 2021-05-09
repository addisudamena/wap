package com.example.lab_13;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz {
    private String question;
    private String answer;

    public Quiz(String question,String answer){
        this.question=question;
        this.answer=answer;
    }

    public String getQuestion() {
        return question;
    }




    public boolean isAnswer(String answer) {
        return this.answer.equals(answer);
    }
}
