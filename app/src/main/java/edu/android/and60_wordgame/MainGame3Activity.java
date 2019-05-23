package edu.android.and60_wordgame;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainGame3Activity extends AppCompatActivity {
    private static final String TAG = "tag";
    public static final String CORRECT_SCORE = "correct_score";
    public static final String TOTAL_Q = "total_question";

    private TextView textFirst, textSecond, textCorrect, textTotal;
    private int[] color_array = {R.color.colorBlack, R.color.colorBlue, R.color.colorRed, R.color.colorWhite,
                R.color.colorGreen, R.color.colorYellow, R.color.colorPurple, R.color.colorOrange};
    private String[] string_array;

    private int count = 0; // 맞힌 갯수
    private int total = 0; // 전체 문제 수


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3_main);

        getWindow().setStatusBarColor(getResources().getColor(R.color.colorDarkBlue));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorDarkBlue)));

        textFirst = findViewById(R.id.textFirst);
        textSecond = findViewById(R.id.textSecond);
        textCorrect = findViewById(R.id.textCorrect);
        textTotal = findViewById(R.id.textTotal);


        string_array = getResources().getStringArray(R.array.text_color);

        setTextQuestion();
    } // end onCreate()

    public void setScore(){

        textCorrect.setText(count+"");
        textTotal.setText(total+"");
    } // end setScore()

    public void onClickYes(View view) {
        String color =  textFirst.getText().toString(); // 왼쪽 textView 글자
        int color_right = textSecond.getCurrentTextColor();   // 오른쪽 textView 글자 색

        switch (color) {
            case "검정":
                if (color_right == getResources().getColor(R.color.colorBlack)){
                    showAlertDialogAnswer();
                    count++;
                    setScore();
                } else {
                    showAlertDialogWrongAnswer();
                }
                break;
            case "파랑":
                if(color_right == getResources().getColor(R.color.colorBlue)) {
                    showAlertDialogAnswer();
                    count++;
                    setScore();
                } else {
                    showAlertDialogWrongAnswer();
                }
                break;
            case "빨강":
                if(color_right == getResources().getColor(R.color.colorRed)) {
                    showAlertDialogAnswer();
                    count++;
                    setScore();
                } else {
                    showAlertDialogWrongAnswer();
                }
                break;
            case "노랑":
                if(color_right == getResources().getColor(R.color.colorYellow)) {
                    showAlertDialogAnswer();
                    count++;
                    setScore();
                } else {
                    showAlertDialogWrongAnswer();
                }
                break;
            case "초록":
                if(color_right == getResources().getColor(R.color.colorGreen)) {
                    showAlertDialogAnswer();
                    count++;
                    setScore();
                } else {
                    showAlertDialogWrongAnswer();
                }
                break;
            case "보라":
                if(color_right == getResources().getColor(R.color.colorPurple)) {
                    showAlertDialogAnswer();
                    count++;
                    setScore();
                } else {
                    showAlertDialogWrongAnswer();
                }
                break;
            case "주황":
                if(color_right == getResources().getColor(R.color.colorOrange)) {
                    showAlertDialogAnswer();
                    count++;
                    setScore();
                } else {
                    showAlertDialogWrongAnswer();
                }
                break;
            case "하얀":
                if (color_right == getResources().getColor(R.color.colorWhite)){
                    showAlertDialogAnswer();
                    count++;
                    setScore();
                } else {
                    showAlertDialogWrongAnswer();
                }
                break;

        } // end switch(color)
    } // end onClickYes()

    public void onClickNo(View view) {
        String color =  textFirst.getText().toString(); // 왼쪽 textView 글자
        int color_right = textSecond.getCurrentTextColor();   // 오른쪽 textView 글자 색

        switch (color) {
            case "검정":
                if (color_right != getResources().getColor(R.color.colorBlack)){
                    showAlertDialogAnswer();
                    count++;
                    setScore();
                } else {
                    showAlertDialogWrongAnswer();
                }
                break;
            case "파랑":
                if(color_right != getResources().getColor(R.color.colorBlue)) {
                    showAlertDialogAnswer();
                    count++;
                    setScore();
                } else {
                    showAlertDialogWrongAnswer();
                }
                break;
            case "빨강":
                if(color_right != getResources().getColor(R.color.colorRed)) {
                    showAlertDialogAnswer();
                    count++;
                    setScore();
                } else {
                    showAlertDialogWrongAnswer();
                }
                break;
            case "노랑":
                if(color_right != getResources().getColor(R.color.colorYellow)) {
                    showAlertDialogAnswer();
                    count++;
                    setScore();
                } else {
                    showAlertDialogWrongAnswer();
                }
                break;
            case "초록":
                if(color_right != getResources().getColor(R.color.colorGreen)) {
                    showAlertDialogAnswer();
                    count++;
                    setScore();
                } else {
                    showAlertDialogWrongAnswer();
                }
                break;
            case "보라":
                if(color_right != getResources().getColor(R.color.colorPurple)) {
                    showAlertDialogAnswer();
                    count++;
                    setScore();
                } else {
                    showAlertDialogWrongAnswer();
                }
                break;
            case "주황":
                if(color_right != getResources().getColor(R.color.colorOrange)) {
                    showAlertDialogAnswer();
                    count++;
                    setScore();
                } else {
                    showAlertDialogWrongAnswer();
                }
                break;
            case "하얀":
                if(color_right != getResources().getColor(R.color.colorWhite)) {
                    showAlertDialogAnswer();
                    count++;
                    setScore();
                } else {
                    showAlertDialogWrongAnswer();
                }
                break;

        } // end switch(color)

    } // end onClickNo()

    public void setTextQuestion() {

        Random random = new Random();

        int index_text_first = random.nextInt(string_array.length - 1); // 1번 스케치북 텍스트뷰
        int index_text_second = random.nextInt(string_array.length - 1); // 2번 스케치북 텍스트뷰

        int index_color_first = random.nextInt(color_array.length - 1);  //1번 텍스트 컬러
        int index_color_second = random.nextInt(color_array.length - 1); // 2번 텍스트 컬러

        int index_back_first = random.nextInt(color_array.length - 1);   // 1번 스케치북 배경
        int index_back_second = random.nextInt(color_array.length - 1); // 2번 스케치북 배경

        textFirst.setText(string_array[index_text_first]);
        textFirst.setTextColor(getResources().getColor(color_array[index_color_first]));

        textSecond.setText(string_array[index_text_second]);
        textSecond.setTextColor((getResources().getColor(color_array[index_color_second])));

        while (true) {
            if (index_back_first == index_color_first) {
                index_back_first = random.nextInt(color_array.length - 1);
            }else if (index_back_second == index_color_second) {
                index_back_second = random.nextInt(color_array.length - 1);
            } else if(index_back_first != index_color_first && index_back_second != index_color_second){
                break;
            }
        } // end while


        setScore();
        total++;
        textFirst.setBackgroundColor(getResources().getColor(color_array[index_back_first]));

        textSecond.setBackgroundColor(getResources().getColor(color_array[index_back_second]));
    } // end setTextQuestion()

    public void showAlertDialogAnswer() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        alertDialog.setTitle("정답입니다");
        alertDialog.setMessage("다음 문제로 넘어가시겠습니까?")
                .setCancelable(false)
                .setPositiveButton("예",
                        new DialogInterface.OnClickListener() {
                            public void onClick(
                                    DialogInterface dialog, int id) {
                                setTextQuestion();
                            }
                        })
                .setNegativeButton("아니오",
                        new DialogInterface.OnClickListener() {
                            public void onClick(
                                    DialogInterface dialog, int id) {
                                Intent intent = new Intent(MainGame3Activity.this, ResultGame3Activity.class);
                                intent.putExtra(CORRECT_SCORE, count);
                                intent.putExtra(TOTAL_Q, total);
                                startActivity(intent);
                                finish();
                            }
                        });
        alertDialog.create();
        alertDialog.show();
    } // end showAlertDialogAnswer()

    public void showAlertDialogWrongAnswer(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        alertDialog.setTitle("오답입니다");
        alertDialog.setMessage("다음 문제로 넘어가시겠습니까?")
                .setCancelable(false)
                .setPositiveButton("예",
                        new DialogInterface.OnClickListener() {
                            public void onClick(
                                    DialogInterface dialog, int id) {
                                setTextQuestion();
                            }
                        })
                .setNegativeButton("끝내기",
                        new DialogInterface.OnClickListener() {
                            public void onClick(
                                    DialogInterface dialog, int id) {
                                Intent intent = new Intent(MainGame3Activity.this, ResultGame3Activity.class);
                                intent.putExtra(CORRECT_SCORE, count);
                                intent.putExtra(TOTAL_Q, total);
                                startActivity(intent);
                                finish();
                            }
                        });
        alertDialog.create();
        alertDialog.show();
    } // end showAlertDialogWrongAnswer()

} // end class MainGame3Activity
