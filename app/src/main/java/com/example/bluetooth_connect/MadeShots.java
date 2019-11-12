package com.example.bluetooth_connect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.io.Serializable;

public class MadeShots extends AppCompatActivity {

    Ball takenShots[];
    SeekBar performances[];

    Button madeShotsCounter;
    Integer shotsCounter;

    Integer buttonCounter_1;
    Integer buttonCounter_2;
    Integer buttonCounter_3;
    Integer buttonCounter_4;
    Integer buttonCounter_5;
    Integer buttonCounter_6;
    Integer buttonCounter_7;
    Integer buttonCounter_8;
    Integer buttonCounter_9;
    Integer buttonCounter_10;


    Button button1 ;
    Button button2 ;
    Button button3 ;
    Button button4 ;
    Button button5 ;
    Button button6 ;
    Button button7;
    Button button8 ;
    Button button9;
    Button button10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_made_shots);

        takenShots = new Ball[10];
        performances = new SeekBar[10];
        madeShotsCounter = (Button)findViewById(R.id.counter_button);
        shotsCounter = 0;


        buttonCounter_1 = 1;
        buttonCounter_2 = 1;
        buttonCounter_3 = 1;
        buttonCounter_4 = 1;
        buttonCounter_5 = 1;
        buttonCounter_6 = 1;
        buttonCounter_7 = 1;
        buttonCounter_8 = 1;
        buttonCounter_9 = 1;
        buttonCounter_10 = 1;




        Intent intent = this.getIntent(); /////
        Bundle bundle = intent.getBundleExtra("BUNDLE"); ////

        takenShots = (Ball[])bundle.getSerializable("SHOTS"); ///// AYTO XREIAZOMAI !!!!

        performances[0] = (SeekBar)findViewById(R.id.indicator_1);
        performances[1] = (SeekBar)findViewById(R.id.indicator_2);
        performances[2] = (SeekBar)findViewById(R.id.indicator_3);
        performances[3] = (SeekBar)findViewById(R.id.indicator_4);
        performances[4] = (SeekBar)findViewById(R.id.indicator_5);
        performances[5] = (SeekBar)findViewById(R.id.indicator_6);
        performances[6] = (SeekBar)findViewById(R.id.indicator_7);
        performances[7] = (SeekBar)findViewById(R.id.indicator_8);
        performances[8] = (SeekBar)findViewById(R.id.indicator_9);
        performances[9] = (SeekBar)findViewById(R.id.indicator_10);

         button1 = (Button) findViewById(R.id.made_1);
         button2 = (Button) findViewById(R.id.made_2);
         button3 = (Button) findViewById(R.id.made_3);
         button4 = (Button) findViewById(R.id.made_4);
         button5 = (Button) findViewById(R.id.made_5);
        button6 = (Button) findViewById(R.id.made_6);
         button7 = (Button) findViewById(R.id.made_7);
         button8 = (Button) findViewById(R.id.made_8);
        button9= (Button) findViewById(R.id.made_9);
        button10 = (Button) findViewById(R.id.made_10);




        for(int i=0; i<=9; i++){
            performances[i].setProgress(takenShots[i].getEvaluation());
        }



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonCounter_1 % 2 ==0){
                    button1.setBackgroundResource(R.drawable.made_button);
                    button1.setTextColor(Color.parseColor("#02D487"));
                    shotsCounter = shotsCounter-1;
                    madeShotsCounter.setText(String.valueOf(shotsCounter));
                    takenShots[0].setMade(false);

                }
                else {


                    button1.setBackgroundResource(R.drawable.button_made_clicked);
                    button1.setTextColor(Color.WHITE);
                    shotsCounter = shotsCounter+1;
                    madeShotsCounter.setText(String.valueOf(shotsCounter));
                    takenShots[0].setMade(true);
                }

                buttonCounter_1 = buttonCounter_1 +1;
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonCounter_2 % 2 ==0){
                    button2.setBackgroundResource(R.drawable.made_button);
                    button2.setTextColor(Color.parseColor("#02D487"));
                    shotsCounter = shotsCounter-1;
                    madeShotsCounter.setText(String.valueOf(shotsCounter));
                    takenShots[1].setMade(false);
                }
                else {


                    button2.setBackgroundResource(R.drawable.button_made_clicked);
                    button2.setTextColor(Color.WHITE);
                    shotsCounter = shotsCounter+1;
                    madeShotsCounter.setText(String.valueOf(shotsCounter));
                    takenShots[1].setMade(true);
                }

                buttonCounter_2 = buttonCounter_2 +1;
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonCounter_3 % 2 ==0){
                    button3.setBackgroundResource(R.drawable.made_button);
                    button3.setTextColor(Color.parseColor("#02D487"));
                    shotsCounter = shotsCounter-1;
                    madeShotsCounter.setText(String.valueOf(shotsCounter));
                    takenShots[2].setMade(false);
                }
                else {


                    button3.setBackgroundResource(R.drawable.button_made_clicked);
                    button3.setTextColor(Color.WHITE);
                    shotsCounter = shotsCounter+1;
                    madeShotsCounter.setText(String.valueOf(shotsCounter));
                    takenShots[2].setMade(true);
                }

                buttonCounter_3 = buttonCounter_3 +1;
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonCounter_4 % 2 ==0){
                    button4.setBackgroundResource(R.drawable.made_button);
                    button4.setTextColor(Color.parseColor("#02D487"));
                    shotsCounter = shotsCounter-1;
                    madeShotsCounter.setText(String.valueOf(shotsCounter));
                    takenShots[3].setMade(false);
                }
                else {

                    button4.setBackgroundResource(R.drawable.button_made_clicked);
                    button4.setTextColor(Color.WHITE);
                    shotsCounter = shotsCounter+1;
                    madeShotsCounter.setText(String.valueOf(shotsCounter));
                    takenShots[3].setMade(true);
                }

                buttonCounter_4 = buttonCounter_4 +1;
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonCounter_5 % 2 ==0){
                    button5.setBackgroundResource(R.drawable.made_button);
                    button5.setTextColor(Color.parseColor("#02D487"));
                    shotsCounter = shotsCounter-1;
                    madeShotsCounter.setText(String.valueOf(shotsCounter));
                    takenShots[4].setMade(false);
                }
                else {


                    button5.setBackgroundResource(R.drawable.button_made_clicked);
                    button5.setTextColor(Color.WHITE);
                    shotsCounter = shotsCounter+1;
                    madeShotsCounter.setText(String.valueOf(shotsCounter));
                    takenShots[4].setMade(true);
                }

                buttonCounter_5 = buttonCounter_5 +1;
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonCounter_6 % 2 ==0){
                    button6.setBackgroundResource(R.drawable.made_button);
                    button6.setTextColor(Color.parseColor("#02D487"));
                    shotsCounter = shotsCounter-1;
                    madeShotsCounter.setText(String.valueOf(shotsCounter));
                    takenShots[5].setMade(false);
                }
                else {


                    button6.setBackgroundResource(R.drawable.button_made_clicked);
                    button6.setTextColor(Color.WHITE);
                    shotsCounter = shotsCounter+1;
                    madeShotsCounter.setText(String.valueOf(shotsCounter));
                    takenShots[5].setMade(true);
                }

                buttonCounter_6 = buttonCounter_6 +1;
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonCounter_7 % 2 ==0){
                    button7.setBackgroundResource(R.drawable.made_button);
                    button7.setTextColor(Color.parseColor("#02D487"));
                    shotsCounter = shotsCounter-1;
                    madeShotsCounter.setText(String.valueOf(shotsCounter));
                    takenShots[6].setMade(false);
                }
                else {


                    button7.setBackgroundResource(R.drawable.button_made_clicked);
                    button7.setTextColor(Color.WHITE);
                    shotsCounter = shotsCounter+1;
                    madeShotsCounter.setText(String.valueOf(shotsCounter));
                    takenShots[6].setMade(true);
                }

                buttonCounter_7 = buttonCounter_7 +1;
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonCounter_8 % 2 ==0){
                    button8.setBackgroundResource(R.drawable.made_button);
                    button8.setTextColor(Color.parseColor("#02D487"));
                    shotsCounter = shotsCounter-1;
                    madeShotsCounter.setText(String.valueOf(shotsCounter));
                    takenShots[7].setMade(false);
                }
                else {


                    button8.setBackgroundResource(R.drawable.button_made_clicked);
                    button8.setTextColor(Color.WHITE);
                    shotsCounter = shotsCounter+1;
                    madeShotsCounter.setText(String.valueOf(shotsCounter));
                    takenShots[7].setMade(true);
                }

                buttonCounter_8 = buttonCounter_8 +1;
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonCounter_9 % 2 ==0){
                    button9.setBackgroundResource(R.drawable.made_button);
                    button9.setTextColor(Color.parseColor("#02D487"));
                    shotsCounter = shotsCounter-1;
                    madeShotsCounter.setText(String.valueOf(shotsCounter));
                    takenShots[8].setMade(false);


                }
                else {
                    button9.setBackgroundResource(R.drawable.button_made_clicked);
                    button9.setTextColor(Color.WHITE);
                    shotsCounter = shotsCounter+1;
                    madeShotsCounter.setText(String.valueOf(shotsCounter));
                    takenShots[8].setMade(true);
                }

                buttonCounter_9 = buttonCounter_9 +1;
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonCounter_10 % 2 ==0){
                    button10.setBackgroundResource(R.drawable.made_button);
                    button10.setTextColor(Color.parseColor("#02D487"));
                    shotsCounter = shotsCounter-1;
                    madeShotsCounter.setText(String.valueOf(shotsCounter));
                    takenShots[9].setMade(false);
                }
                else {

                    button10.setBackgroundResource(R.drawable.button_made_clicked);
                    button10.setTextColor(Color.WHITE);
                    shotsCounter = shotsCounter+1;
                    madeShotsCounter.setText(String.valueOf(shotsCounter));
                    takenShots[9].setMade(true);
                }

                buttonCounter_10 = buttonCounter_10 +1;
            }
        });
    }

    public void onClickFinalScreen(View view){
        Intent intent = new Intent(this, finalActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("SHOTS",(Serializable) takenShots);
        intent.putExtra("BUNDLE",bundle);
        startActivity(intent);
    }

}
