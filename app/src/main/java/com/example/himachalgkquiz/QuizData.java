package com.example.himachalgkquiz;

import java.util.ArrayList;

public class QuizData {


    ArrayList<Modal> QuizData() {
        ArrayList<Modal> quizData = new ArrayList<Modal>();
        String question1[] = {"12", "13", "10", "14"};
        String question2[] = {"Mandi", "Kangra", "Shimla", "Solan"};
        String question3[] = {"Kalraj Mishra", "Bhandaru Datatreya", "Jai Ram Thakur", "Acharya Devvrat"};
        String question4[] = {"Y.S. Parmar", "Raja Anand Chand", "Ram Lal Thakur", "Jai Ram Thakur"};
        String question5[] = {"Virbhadra Singh", "Jai Ram Thakur", "Prem Kumar Dhumal", "Ram Lal Thakur"};
        String question6[] = {"25 Jan 1971", "15 Aug 1947", "15 April 1948", "26 Jan 1950"};
        String question7[] = {"Renuka Lake", "Govind Sagar Lake", "Dal Lake", "Paung Lake"};
        String question8[] = {"Satluj", "Ravi", "Chenab", "Yamuna"};
        String question9[] = {"Mahasu", "Bilaspur", "Sirmaur", "Chamba"};
        String question10[] = {"Mandi", "Kullu", "Lahaul and Sapiti", "Chamba"};
        String question11[] = {"Mandi", "Kullu", "Lahaul and Sapiti", "Chamba"};
        String question12[] = {"55,673", "50,000", "40,987", "45,098"};
        String question13[] = {"68,48,602", "55,673,456", "60,67,655", "60,54,567"};
        String question14[] = {"Suket", "Theog", "Mahasu", "Kehlur"};
        String question15[] = {"1 July 1956", "1 July 1954", "1 July 1955", "1 July 1950"};
        quizData.add(new Modal("How many districts in Himachal Pradesh ?", question1, "12", false));
        quizData.add(new Modal("What is capital city of Himachal Pradesh ?", question2, "Shimla", false));
        quizData.add(new Modal("Who is Governor Of Himachal Praesh ?", question3, "Bhandaru Datatreya", false));
        quizData.add(new Modal("Who is first Cheif Minister of Himachal Pradesh", question4, "Y.S. Parmar", false));
        quizData.add(new Modal("Who is current Cheif Minister of Himachal Pradesh?", question5, "Jai Ram Thakur", false));
        quizData.add(new Modal("When did Himachal come into existance", question6, "15 April 1948", false));
        quizData.add(new Modal("Which of the following is the Largest Artificial Lake in Himachal Pradesh ?", question7, "Govind Sagar Lake", false));
        quizData.add(new Modal("Which is largest river in the Himachal Pradesh ?", question8, "Satluj", false));
        quizData.add(new Modal("Which of the following are included in himachal at time of independence?", question9, "Shilla", false));
        quizData.add(new Modal("Shikari Devi is located in which of the Districts ?", question10, "Mandi", false));
        quizData.add(new Modal("Which of the following has the highest area ?", question11, "Lahaul and Sapiti", false));
        quizData.add(new Modal("What is area of the Himachal Pradesh?", question12, "55,673", false));
        quizData.add(new Modal("What is population of Himachal Pradesh according census 2011 ?", question13, "68,48,602", false));
        quizData.add(new Modal("Which is first princely state to be included in Himachal after independence ?", question14, "Theog", false));
        quizData.add(new Modal("When did Bilaspur included in Himachal Pradesh?", question15, "1 July 1954", false));
        return quizData;
    }
}
