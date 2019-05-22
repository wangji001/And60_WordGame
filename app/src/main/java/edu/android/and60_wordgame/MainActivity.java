package edu.android.and60_wordgame;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
//TODO
// 1) 색 중복제거
// 2) 정답/오답 경우 처리
public class MainActivity extends AppCompatActivity {

    private TextView textFirst, textSecond;
    private int[] color_array = {R.color.colorBlack, R.color.colorBlue, R.color.colorRed, R.color.colorWhite,
                R.color.colorGreen, R.color.colorYellow, R.color.colorPurple, R.color.colorOrange};
    private String[] string_array;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(getResources().getColor(R.color.colorDarkBlue));

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
                    showAlertDialog();
                } else {
                    Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show();
                }
                break;
            case "파랑":
                if(color_right == Color.BLUE) {
                    Toast.makeText(this, "정답입니다", Toast.LENGTH_SHORT).show();
                    showAlertDialog();
                } else {
                    Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show();
                }
                break;
            case "빨강":
                if(color_right == Color.RED) {
                    Toast.makeText(this, "정답입니다", Toast.LENGTH_SHORT).show();
                    showAlertDialog();
                } else {
                    Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show();
                }
                break;
            case "노랑":
                if(color_right == Color.YELLOW) {
                    Toast.makeText(this, "정답입니다", Toast.LENGTH_SHORT).show();
                    showAlertDialog();
                } else {
                    Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show();
                }
                break;
            case "초록":
                if(color_right == Color.GREEN) {
                    Toast.makeText(this, "정답입니다", Toast.LENGTH_SHORT).show();
                    showAlertDialog();
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
                    showAlertDialog();
                } else {
                    Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show();
                }
                break;
            case "파랑":
                if(color_right != Color.BLUE) {
                    Toast.makeText(this, "정답입니다", Toast.LENGTH_SHORT).show();
                    showAlertDialog();
                } else {
                    Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show();
                }
                break;
            case "빨강":
                if(color_right != Color.RED) {
                    Toast.makeText(this, "정답입니다", Toast.LENGTH_SHORT).show();
                    showAlertDialog();
                } else {
                    Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show();
                }
                break;
            case "노랑":
                if(color_right != Color.YELLOW) {
                    Toast.makeText(this, "정답입니다", Toast.LENGTH_SHORT).show();
                    showAlertDialog();
                } else {
                    Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show();
                }
                break;
            case "초록":
                if(color_right != Color.GREEN) {
                    Toast.makeText(this, "정답입니다", Toast.LENGTH_SHORT).show();
                    showAlertDialog();
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
        int index_back_first = random.nextInt(color_array.length -1);

        int index_color_first = random.nextInt(color_array.length -1);
        int index_color_second = random.nextInt(color_array.length -1);
        int index_back_second = random.nextInt(color_array.length -1);

        textFirst.setText(string_array[index_text_first]);
        textFirst.setTextColor(getResources().getColor(color_array[index_color_first]));


        textSecond.setText(string_array[index_text_second]);
        textSecond.setTextColor(color_array[index_color_second]);
        while (true) {
            if (index_back_first == index_color_first) {
                if ( index_back_first > color_array.length -1) {
                    index_back_first = index_back_first - 1;
                } else if (index_back_first < 0 ) {
                    index_back_first = index_back_first +1;
                }


            } else if (index_back_second == index_color_second) {
                if (index_back_second > color_array.length -1){
                    index_back_second = index_back_second -1;
                } else if (index_back_second < 0) {
                    index_back_second = index_back_second +1;
                }

            } else {
                break;
            }
            break;
        }


        textFirst.setBackgroundColor(getResources().getColor(color_array[index_back_first]));

        textSecond.setBackgroundColor(getResources().getColor(color_array[index_back_second]));
    } // end setTextQuestion()

    public void showAlertDialog(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        alertDialog.setTitle("정답입니다");
        alertDialog .setMessage("다음 문제로 넘어가시겠습니까?")
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
                                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                                startActivity(intent);
                            }
                        });

      alertDialog.create();

        alertDialog.show();


    }

    public void onClickNext(View view) {
        setTextQuestion();

    } // end onClickNext()
} // end class MainActivity
