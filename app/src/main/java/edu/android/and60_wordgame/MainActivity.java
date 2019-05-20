package edu.android.and60_wordgame;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textFirst, textSecond;
    private int[] color_array = {R.color.colorBlack, R.color.colorBlue, R.color.colorRed, R.color.colorWhite,
                R.color.colorGreen, R.color.colorYellow, R.color.colorPurple, R.color.colorOrange};
    private String[] string_array;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textFirst = findViewById(R.id.textFirst);
        textSecond = findViewById(R.id.textSecond);

        string_array = getResources().getStringArray(R.array.text_color);

        setTextQuestion();
    } // end onCreate()

    public void onClickYes(View view) {
        String color =  textFirst.getText().toString(); // 왼쪽 textView 글자
        int color_right = textSecond.getCurrentTextColor();   // 오른쪽 textView 글자 색

        switch (color) {
            case "검정":
                if (color_right == Color.BLACK){
                    Toast.makeText(this, "정답입니다", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show();
                }
                break;
            case "파랑":
                if(color_right == Color.BLUE) {
                    Toast.makeText(this, "정답입니다", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show();
                }
                break;
            case "빨강":
                if(color_right == Color.RED) {
                    Toast.makeText(this, "정답입니다", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show();
                }
                break;
            case "노랑":
                if(color_right == Color.YELLOW) {
                    Toast.makeText(this, "정답입니다", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show();
                }
                break;
            case "초록":
                if(color_right == Color.GREEN) {
                    Toast.makeText(this, "정답입니다", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show();
                }
                break;
        } // end switch(color)
    } // end onClickYes()

    public void onClickNo(View view) {
        String color =  textFirst.getText().toString(); // 왼쪽 textView 글자
        int color_right = textSecond.getCurrentTextColor();   // 오른쪽 textView 글자 색

        switch (color) {
            case "검정":
                if (color_right != Color.BLACK){
                    Toast.makeText(this, "정답입니다", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show();
                }
                break;
            case "파랑":
                if(color_right != Color.BLUE) {
                    Toast.makeText(this, "정답입니다", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show();
                }
                break;
            case "빨강":
                if(color_right != Color.RED) {
                    Toast.makeText(this, "정답입니다", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show();
                }
                break;
            case "노랑":
                if(color_right != Color.YELLOW) {
                    Toast.makeText(this, "정답입니다", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show();
                }
                break;
            case "초록":
                if(color_right != Color.GREEN) {
                    Toast.makeText(this, "정답입니다", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show();
                }
                break;
        } // end switch(color)

    } // end onClickNo()

    public void setTextQuestion() {

        Random random = new Random();

        int index_text_first = random.nextInt(string_array.length - 1);
        int index_text_second = random.nextInt(string_array.length - 1);

        int index_color_first = random.nextInt(color_array.length -1);
        int index_color_second = random.nextInt(color_array.length -1);




        textFirst.setText(string_array[index_text_first]);
        textFirst.setTextColor(getResources().getColor(color_array[index_color_first]));


        textSecond.setText(string_array[index_text_second]);
        textSecond.setTextColor(color_array[index_color_second]);
    } // end setTextQuestion()

    public void onClickNext(View view) {
        setTextQuestion();

    } // end onClickNext()
} // end class MainActivity
