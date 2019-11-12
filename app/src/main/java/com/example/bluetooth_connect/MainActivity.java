package com.example.bluetooth_connect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.ObjectAnimator;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toolbar;
import android.content.Intent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

import io.palaima.smoothbluetooth.Device;
import io.palaima.smoothbluetooth.SmoothBluetooth;


public class MainActivity extends AppCompatActivity {

    private SmoothBluetooth mySmoothBluetooth;

    TextView xAxis;  //DEBUGGING PURPOSES
    TextView yAxis;  //DEBUGGING PURPOSES
    TextView zAxis;  //DEBUGGING PURPOSES
    TextView pitch;  //DEBUGGING PURPOSES
    TextView roll;   //DEBUGGING PURPOSES


    SeekBar evaluations[]; //ΠΙΝΑΚΑΣ ΓΙΑ ΝΑ ΑΠΟΘΗΚΕΥΣΕΙ ΟΛΕΣ ΤΙΣ ΜΠΑΡΕΣ !!!!

    Integer dataCounter; //USED TO RECEIVE THE DATA FROM BLUETOOTH
    Integer validShotCounter; //USED TO EVALUATE THE STARTING POSITION OF SHOTS
    Integer shotCounter; //COUNT SHOTS TAKEN

    Ball storeShots[]; //ΠΙΝΑΚΑΣ ΠΟΥ ΘΑ ΑΠΟΘΗΚΕΥΣΕΙ ΤΑ 10 ΣΟΥΤ ΤΟΥ ΠΑΙΧΤΗ

    ScrollView myScroll;


    ConstraintLayout views[];

    Float xPos; //THE X POSITION WHICH WE PASS TO THE OBJECT
    Float yPos; //THE Y POSITION WHICH WE PASS TO THE OBJECT
    Float zPos; //THE Z POSITION WHICH WE PASS TO THE OBJECT

    boolean hasShot; //USED TO EVALUATE IF THE PLAYER HAS SHOT


    List<Integer> myBuffer = new ArrayList<>(); //ισως θελει Integer

    String rawData; //USED TO RECEIVE THE DATA FROM BLUETOOTH
    String[] arrayOfStrings; //USED TO RECEIVE THE DATA FROM BLUETOOTH

    Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("CREATE","activity created!!");

        mySmoothBluetooth = new SmoothBluetooth(this); //USED TO RECEIVE BLUETOOTH DATA
        mySmoothBluetooth.setListener(myListener); //USED TO RECEIVE BLUETOOTH DATA

        mySmoothBluetooth.tryConnection(); //USED TO RECEIVE BLUETOOTH DATA

        hasShot = false;   //USED TO DETERMINE IF PLAYER HAS SHOT
        dataCounter=0;   //CREATE TO RECEIVE BLUETOOTH DATA
        validShotCounter = 0;   //CREATE TO EVALUATE STARTING SHOOTING POSITION
        shotCounter = 0;   //COUNT SHOTS TAKEN BY PLAYER
        storeShots = new Ball[10]; //STORE THE INSTANCES OF THE SHOTS THAT THE PLAYER WILL TAKE
        views = new ConstraintLayout[11]; //STORE THE LAYOUTS SO THE PLAYER CAN SCROLL
        continueButton = (Button)findViewById(R.id.continue_button); //BUTTON FOR THE NEXT SCREEN


        xAxis = (TextView) findViewById(R.id.x_axis);  ////DEBUGGING PURPOSES
        yAxis = (TextView) findViewById(R.id.y_axis);  //DEBUGGING PURPOSES
        zAxis = (TextView) findViewById(R.id.z_axis);  //DEBUGGING PURPOSES
        pitch = (TextView) findViewById(R.id.pitch);  //DEBUGGING PURPOSES
        roll = (TextView) findViewById(R.id.roll);  //DEBUGGING PURPOSES




        //ΘΑ ΤΟ ΤΣΕΚΑΡΩ ΑΥΡΙΟ !!!!!
        evaluations = new SeekBar[10]; //STORE THE SEEK BARS
        evaluations[0] = (SeekBar)findViewById(R.id.shotIndicator_0);   //ΘΑ ΤΑ ΔΟΚΙΜΑΣΩ ΑΥΡΙΟ !!!
        evaluations[1] = (SeekBar)findViewById(R.id.shotIndicator_1);
        evaluations[2] = (SeekBar)findViewById(R.id.shotIndicator_2);
        evaluations[3] = (SeekBar)findViewById(R.id.shotIndicator_3);
        evaluations[4] = (SeekBar)findViewById(R.id.shotIndicator_4);
        evaluations[5] = (SeekBar)findViewById(R.id.shotIndicator_5);
        evaluations[6] = (SeekBar)findViewById(R.id.shotIndicator_6);
        evaluations[7] = (SeekBar)findViewById(R.id.shotIndicator_7);
        evaluations[8] = (SeekBar)findViewById(R.id.shotIndicator_8);
        evaluations[9] = (SeekBar)findViewById(R.id.shotIndicator_9);



        // // //
        myScroll = (ScrollView) findViewById(R.id.scrolling); //STORE THE VIEWS SO I CAN SCROLL


        views[0] = (ConstraintLayout)findViewById(R.id.shot_0);
        views[1] = (ConstraintLayout)findViewById(R.id.shot_1);
        views[2] = (ConstraintLayout)findViewById(R.id.shot_2);
        views[3] = (ConstraintLayout)findViewById(R.id.shot_3);
        views[4] = (ConstraintLayout)findViewById(R.id.shot_4);
        views[5] = (ConstraintLayout)findViewById(R.id.shot_5);
        views[6] = (ConstraintLayout)findViewById(R.id.shot_6);
        views[7] = (ConstraintLayout)findViewById(R.id.shot_7);
        views[8] = (ConstraintLayout)findViewById(R.id.shot_8);
        views[9] = (ConstraintLayout)findViewById(R.id.shot_9);
        views[10]=(ConstraintLayout)findViewById(R.id.congrats);

      // // //

        for(int i = 0; i<=9 ;i++){
            storeShots[i] = new Ball(0,0,0);
        }

        //ΠΗΓΑΙΝΩ ΤΟ SCROLLVIEW ΤΕΡΜΑ ΚΑΤΩ
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                myScroll.fullScroll(ScrollView.FOCUS_DOWN);
            }
        };
        myScroll.post(runnable);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mySmoothBluetooth.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    private SmoothBluetooth.Listener myListener = new SmoothBluetooth.Listener() {
        @Override
        public void onBluetoothNotSupported() {
            //device does not support bluetooth
        }

        @Override
        public void onBluetoothNotEnabled() {
            //bluetooth is disabled, probably call Intent request to enable bluetooth
        }

        @Override
        public void onConnecting(Device device) {
            //called when connecting to particular device

        }

        @Override
        public void onConnected(Device device) {
            //called when connected to particular device


        }

        @Override
        public void onDisconnected() {

        }

        @Override
        public void onConnectionFailed(Device device) {
            //called when connection failed to particular device

        }

        @Override
        public void onDiscoveryStarted() {
            //called when discovery is started
        }

        @Override
        public void onDiscoveryFinished() {
            //called when discovery is finished
        }

        @Override
        public void onNoDevicesFound() {
            //called when no devices found
        }

        @Override
        public void onDevicesFound(final List<Device> deviceList,
                                   final SmoothBluetooth.ConnectionCallback connectionCallback) {
            //receives discovered devices list and connection callback
            //you can filter devices list and connect to specific one
            //connectionCallback.connectTo(deviceList.get(position));

            connectionCallback.connectTo(deviceList.get(0));
        }

        @Override

        public void onDataReceived(int data) { //διπλα απο τα data, ειχα int !!!
            //receives all bytes

            int counting;

            myBuffer.add(data);

            if(myBuffer.isEmpty()){

            }


            if( !myBuffer.isEmpty())   //data==62 &&
            {
                StringBuilder sb = new StringBuilder();
                for(int integer : myBuffer){
                    sb.append((char)integer);
                }


                if(sb.charAt(dataCounter)==' '){     //η συνθηκη θα ισχυεο οταν βρουμε κενο χαρακτηρα " "

                    sb.deleteCharAt(dataCounter);
                    rawData = sb.toString();     //θετω το string builder ως String και το θετω σε μια μεταβλητη
                   arrayOfStrings = rawData.split("/");     //"σπαω" την μεταβλητη στο "/"

                                                    //παίρνω τους 3 πρώτους πνακες που θα είναι οι αριθμοί και τους θέτω στα 3 TextViews

                    xPos = Float.parseFloat(arrayOfStrings[0]);
                    yPos = Float.parseFloat(arrayOfStrings[1]);
                    zPos = Float.parseFloat(arrayOfStrings[2]);

                    storeShots[shotCounter].setX(xPos); //ΠΡΟΣΟΧΗ !!! ΙΣΩΣ ΔΕΝ ΕΙΝΑΙ ΣΩΣΤΟ
                    storeShots[shotCounter].setY(yPos); //ΠΡΟΣΟΧΗ !!! ΙΣΩΣ ΔΕΝ ΕΙΝΑΙ ΣΩΣΤΟ
                    storeShots[shotCounter].setZ(zPos); //ΠΡΟΣΟΧΗ !!! ΙΣΩΣ ΔΕΝ ΕΙΝΑΙ ΣΩΣΤΟ

                    storeShots[shotCounter].calculatePitch();
                    storeShots[shotCounter].calculateRoll();

                    xAxis.setText(String.valueOf(storeShots[shotCounter].getX()));  //DEBUGGING PURPOSES
                    yAxis.setText(String.valueOf(storeShots[shotCounter].getY()));  //DEBUGGING PURPOSES
                    zAxis.setText(String.valueOf(storeShots[shotCounter].getZ()));  //DEBUGGING PURPOSES
                    pitch.setText(String.valueOf(Math.round(storeShots[shotCounter].getPitch())));  //DEBUGGING PURPOSES
                    roll.setText(String.valueOf(Math.round(storeShots[shotCounter].getRoll())));   //DEBUGGING PURPOSES


                    //ΕΔΩ ΘΕΛΕΙ ΑΛΛΑΓΕΣ !!!!!
                    int pitchProgress = 200 + Math.round(((storeShots[shotCounter].getPitch()-(-30))*(-200))/60);  //

                    evaluations[shotCounter].setProgress(pitchProgress);

                    //ΑΡΧΙΖΩ ΝΑ ΑΞΙΟΛΟΓΩ ΤΟ ΣΟΥΤ ΤΟΥ ΠΑΙΧΤΗ ΤΩΡΑ !!! //

                    boolean checkRoll = storeShots[shotCounter].startingPositionShot();

                    if(checkRoll){
                        validShotCounter = validShotCounter+1;
                    }

                    if(!checkRoll && validShotCounter !=0){

                         hasShot = storeShots[shotCounter].hasShot();
                    }

                    if(hasShot && validShotCounter !=0){
                        storeShots[shotCounter].setEvaluation(evaluations[shotCounter].getProgress());
                        shotCounter = shotCounter+1;

                        myScroll.smoothScrollTo(0,views[shotCounter].getTop()-230);

                        validShotCounter = 0;
                    }

                    //SOS ΚΑΤΙ ΠΑΙΖΕΙ ΜΕ ΤΟ 10ο ΣΟΥΤ !!!!

                    hasShot = false;


                    if(shotCounter == 10){
                        mySmoothBluetooth.disconnect();
                    }


                    //ENDING SHOT EVALUATION

                    dataCounter = -1;      //ξαναθέτω το counter ως 0 για να αρχίσω να ξαναδιαβάζω δεδομένα
                                            //καθαρίζω το buffer
                    myBuffer.clear();
                }

                dataCounter++;
            }
        }
    };

    public void onClickNextScreen(View view){
        Intent intent = new Intent(this, MadeShots.class);
        Bundle bundle = new Bundle();  ////
        bundle.putSerializable("SHOTS", (Serializable)storeShots);  /////
        intent.putExtra("BUNDLE",bundle); /////
        startActivity(intent);

    }
}
