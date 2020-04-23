package com.example.himachalgkquiz;

public class Modal {
    String question;
    String[] option;
    String correct;
    boolean givenAnswer;

    public Modal(String question, String[] option, String correct, boolean givenAnswer) {
        this.question = question;
        this.option = option;
        this.correct = correct;
        this.givenAnswer = givenAnswer;
    }
}
