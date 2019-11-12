package com.example.bluetooth_connect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

public class finalActivity extends AppCompatActivity {

    Ball ratedShots[];



    TextView shotsMade;
    SeekBar averageTechnique;
    TextView testingAverage;
    TextView totalPointsEarned;
    TextView testRows;

    TableRow emptyRow;
    TableLayout badgeTable;

    Evaluator evaluateShots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        shotsMade = (TextView) findViewById(R.id.final_made_shots);
        averageTechnique = (SeekBar) findViewById(R.id.technique_average);
        testingAverage = (TextView)findViewById(R.id.average_testing);
        totalPointsEarned = (TextView)findViewById(R.id.earning_points);
        testRows = (TextView) findViewById(R.id.testing);
        badgeTable = (TableLayout) findViewById(R.id.tableLayout);





        ratedShots = new Ball[10];



        Intent intent = this.getIntent();
        Bundle bundle = intent.getBundleExtra("BUNDLE");

        ratedShots = (Ball[])bundle.getSerializable("SHOTS");
        evaluateShots = new Evaluator(ratedShots);


        averageTechnique.setProgress(evaluateShots.getTechniqueAverage());

        shotsMade.setText(String.valueOf(evaluateShots.getMadeShots())); /// ΣΟΣ !!! ΜΠΟΡΕΙ ΝΑ ΜΗΝ ΕΙΝΑΙ ΣΩΣΤΟ

        testingAverage.setText(String.valueOf(evaluateShots.getTechniqueAverage()));  /// ΣΟΣ !!! ΜΠΟΡΕΙ ΝΑ ΜΗΝ ΕΙΝΑΙ ΣΩΣΤΟ

        totalPointsEarned.setText(String.valueOf(evaluateShots.getTotalXPpoints()));


        ////////// SOS //////////
        LayoutInflater inflater = getLayoutInflater();

        //CHECK FOR BRONZE
        if(evaluateShots.checkForBronze()){
            View bronzeLayout = inflater.inflate(R.layout.bronze_badge,getEmptyRow(),false);
            getEmptyRow().addView(bronzeLayout);
        }

        //CHECK FOR SILVER
        if(evaluateShots.chechForSilver()){
            View silverLayout = inflater.inflate(R.layout.silver_badge,getEmptyRow(),false);
            getEmptyRow().addView(silverLayout);
        }

        if(evaluateShots.checkForGold()){
            View goldLayout = inflater.inflate(R.layout.golden_badge,getEmptyRow(),false);
            getEmptyRow().addView(goldLayout);
        }

        if(evaluateShots.checkForPearl()){
            View pearlLayout = inflater.inflate(R.layout.pearl_badge,getEmptyRow(),false);
            getEmptyRow().addView(pearlLayout);
        }

        if(evaluateShots.checkGoodTechniqueShot()){
            View goodTechnique = inflater.inflate(R.layout.good_technique, getEmptyRow(),false);
            getEmptyRow().addView(goodTechnique);
        }

        if(evaluateShots.checkFiveConsecGoodShots()){
            View fiveConsecutive = inflater.inflate(R.layout.five_consecutive,getEmptyRow(),false);
            getEmptyRow().addView(fiveConsecutive);
        }




        averageTechnique.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {   //TESTING PURPOSES "LISTENING" TO SEEKBAR
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                testingAverage.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public TableRow getEmptyRow(){
        // ΜΑΣ ΕΠΙΣΤΡΕΦΕΙ ΤΗΝ ΣΕΙΡΑ ΠΟΥ ΕΧΕΙ ΚΕΝΗ ΘΕΣΗ
        for(int i =0; i<=2; i++){
            TableRow testingRow = (TableRow)badgeTable.getChildAt(i);

            if(testingRow.getChildCount()<3){
                emptyRow = testingRow;
                break;
            }
        }
        return emptyRow;
    }

}
