package edu.android.and60_wordgame;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textFirst, textSecond;
    private static final String[] COLOR_TEXT= {"검정", "파랑", "빨강", "노랑", "초록"};
//    private static final String[] COLOR_MEAN = {"검정", "파랑", "빨강", "노랑",  "초록"};
    private static final int[] COLOR = {Color.BLACK, Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textFirst = findViewById(R.id.textFirst);
        textSecond = findViewById(R.id.textSecond);

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

    public void setTextQuestion(){
        Random random = new Random();
        int index = random.nextInt(COLOR.length - 1);
        int index2 = random.nextInt(COLOR.length -1);
        int index3 = random.nextInt(COLOR.length -1);
        int index4 = random.nextInt(COLOR.length -1);
       textFirst.setTextColor(COLOR[index]);
       textFirst.setText(COLOR_TEXT[index2]);

       textSecond.setText(COLOR_TEXT[index3]);
       textSecond.setTextColor(COLOR[index4]);
    } // end setTextQuestion()

    public void onClickNext(View view) {
        setTextQuestion();

    } // end onClickNext()
} // end class MainActivity
