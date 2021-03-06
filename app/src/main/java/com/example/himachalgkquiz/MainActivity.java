package com.example.himachalgkquiz;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvQuestion;
    TextView tvError;
    TextView tvPercent;
    TextView tvResult;

    RadioGroup rgOption;
    RadioButton question1;
    RadioButton question2;
    RadioButton question3;
    RadioButton question4;
    ScrollView parent;
    Button btnPrevious;
    Button btnSubmit;
    Button btnNext;
    Button btnReset;

    LinearLayout resultParent;
    LinearLayout quizlayout;
    LinearLayout checkbox;
    LinearLayout textBox;
    LinearLayout quiz;

    EditText etResponse;

    CheckBox cbOption1;
    CheckBox cbOption2;
    CheckBox cbOption3;
    CheckBox cbOption4;

    int index = 0;
    QuizData quizData;
    ArrayList<Modal> listOfQuesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findIds();
        quizlayout.setVisibility(View.VISIBLE);
        quizData = new QuizData();
        listOfQuesion = quizData.QuizData();

        if (index == 0) {

            initialValueOfQuiz();
        }
        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
        btnReset.setOnClickListener(this);

    }

    private void setValueOfQuiz() {

        if (index == 8) {
            quiz.setVisibility(View.GONE);
            checkbox.setVisibility(View.VISIBLE);
            textBox.setVisibility(View.GONE);
            tvQuestion.setText(listOfQuesion.get(index).question + " " + getResources().getString(R.string.moreans));
            cbOption1.setText(listOfQuesion.get(index).option[0]);
            cbOption2.setText(listOfQuesion.get(index).option[1]);
            cbOption3.setText(listOfQuesion.get(index).option[2]);
            cbOption4.setText(listOfQuesion.get(index).option[3]);
        } else if (index == 14) {
            quiz.setVisibility(View.GONE);
            checkbox.setVisibility(View.GONE);
            textBox.setVisibility(View.VISIBLE);
            tvQuestion.setText("Who is called as the Pahadi Gandhi?");
        } else {
            quiz.setVisibility(View.VISIBLE);
            checkbox.setVisibility(View.GONE);
            textBox.setVisibility(View.GONE);
            tvQuestion.setText(listOfQuesion.get(index).question);
            question1.setText(listOfQuesion.get(index).option[0]);
            question2.setText(listOfQuesion.get(index).option[1]);
            question3.setText(listOfQuesion.get(index).option[2]);
            question4.setText(listOfQuesion.get(index).option[3]);
        }
    }

    private void initialValueOfQuiz() {
        quiz.setVisibility(View.VISIBLE);
        checkbox.setVisibility(View.GONE);
        textBox.setVisibility(View.GONE);
        tvQuestion.setText(listOfQuesion.get(0).question);
        question1.setText(listOfQuesion.get(0).option[0]);
        question2.setText(listOfQuesion.get(0).option[1]);
        question3.setText(listOfQuesion.get(0).option[2]);
        question4.setText(listOfQuesion.get(0).option[3]);
    }

    private void findIds() {
        tvError = findViewById(R.id.tvError);
        tvQuestion = findViewById(R.id.tvQuestion);
        rgOption = findViewById(R.id.rgOptions);
        question1 = findViewById(R.id.question1);
        question2 = findViewById(R.id.question2);
        question3 = findViewById(R.id.question3);
        question4 = findViewById(R.id.question4);
        btnPrevious = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);
        btnSubmit = findViewById(R.id.btnSubmit);
        parent = findViewById(R.id.parentLayout);
        tvPercent = findViewById(R.id.tvPercent);
        tvResult = findViewById(R.id.tvResult);
        resultParent = findViewById(R.id.resultparent);
        quizlayout = findViewById(R.id.quizlayout);
        btnReset = findViewById(R.id.btnReset);

        cbOption1 = findViewById(R.id.cbOption1);
        cbOption2 = findViewById(R.id.cbOption2);
        cbOption3 = findViewById(R.id.cbOption3);
        cbOption4 = findViewById(R.id.cbOption4);

        checkbox = findViewById(R.id.checkBox);
        textBox = findViewById(R.id.textBox);
        quiz = findViewById(R.id.quiz);

        etResponse = findViewById(R.id.etResponse);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnNext:
                tvError.setVisibility(View.GONE);
                index++;
                if (index < listOfQuesion.size()) {
                    setValueOfQuiz();
                } else if (index == listOfQuesion.size()) {
                    showResult();
                } else {
                    index--;
                }
                break;
            case R.id.btnPrevious:
                tvError.setVisibility(View.GONE);
                index--;
                if (index >= 0) {
                    setValueOfQuiz();
                } else {
                    index++;
                }
                break;
            case R.id.btnSubmit:
                onQuizSubmit();
                break;
            case R.id.btnReset:
                resetQuiz();
                break;
        }
    }

    private void resetQuiz() {
        resultParent.setVisibility(View.GONE);
        quizlayout.setVisibility(View.VISIBLE);
        index = 0;
        initialValueOfQuiz();
    }

    private void showResult() {
        resultParent.setVisibility(View.VISIBLE);
        quizlayout.setVisibility(View.GONE);
        int correctans = 0;
        double percent = 0.0;
        for (int i = 0; i < listOfQuesion.size(); i++) {
            if (listOfQuesion.get(i).givenAnswer) {
                correctans++;
            }
        }
        if (correctans > 0) {
            percent = (Double.valueOf(correctans) / Double.valueOf(listOfQuesion.size())) * 100.00;
        }
        Log.e("percentage", String.valueOf(percent));
        tvPercent.setText(String.valueOf(percent) + " %");
        String result = "";

        if (percent > 90.0) {
            result = "Excillent";
        } else if (percent < 90.0 && percent > 70) {
            result = "Good";
        } else if (percent < 70 && percent > 60) {
            result = "Average";
        } else {
            result = "No Good";
        }

        tvResult.setText(result);
    }

    private void onQuizSubmit() {

        if (index == 14) {
            textBoxResponse();

        } else if (index == 8) {

            checkBoxResponse();
        } else {
            radioButtonOption();
        }
    }

    private void checkBoxResponse() {

        if (cbOption1.isChecked() && cbOption3.isChecked() && cbOption4.isChecked()) {
            tvError.setVisibility(View.VISIBLE);
            tvError.setText(R.string.correct);
            tvError.setTextColor(getResources().getColor(R.color.white));
            listOfQuesion.get(index).givenAnswer = true;
        } else {
            tvError.setVisibility(View.VISIBLE);
            tvError.setText(R.string.incorrect);
            tvError.setTextColor(getResources().getColor(R.color.red));
            listOfQuesion.get(index).givenAnswer = false;
        }
    }

    private void radioButtonOption() {
        int selectedId = rgOption.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton selectedButton = findViewById(selectedId);
            String selectedText = selectedButton.getText().toString();
            if (selectedText.trim() == listOfQuesion.get(index).correct) {
                tvError.setVisibility(View.VISIBLE);
                tvError.setText(R.string.correct);
                tvError.setTextColor(getResources().getColor(R.color.white));
                listOfQuesion.get(index).givenAnswer = true;
            } else {
                tvError.setVisibility(View.VISIBLE);
                tvError.setText(R.string.incorrect);
                tvError.setTextColor(getResources().getColor(R.color.red));
                listOfQuesion.get(index).givenAnswer = false;
            }
        } else {
            Snackbar snackbar = Snackbar.make(parent, "Please Select a Answer", Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }

    private void textBoxResponse() {
        String response = etResponse.getText().toString().trim();
        if (response.equals("Baba Kanshiram")) {
            tvError.setVisibility(View.VISIBLE);
            tvError.setText(R.string.correct);
            tvError.setTextColor(getResources().getColor(R.color.white));
            listOfQuesion.get(index).givenAnswer = true;
        } else {
            tvError.setVisibility(View.VISIBLE);
            tvError.setText(R.string.incorrect);
            tvError.setTextColor(getResources().getColor(R.color.red));
            listOfQuesion.get(index).givenAnswer = false;
        }
    }
}
