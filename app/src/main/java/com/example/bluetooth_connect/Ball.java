package com.example.bluetooth_connect;

import java.io.Serializable;

public class Ball implements Serializable { //SOS ///
    private float pitch;
    private float roll;


    private float xAngle;
    private float yAngle;
    private float zAngle;

    private int shotEvaluation;

    private boolean made;

    public Ball(float xvalue, float yValue, float zValue){

        xAngle = xvalue;
        yAngle = yValue;
        zAngle = zValue;

        made=false;
    }

    void calculatePitch(){

        double pitchX = Math.atan(-1 * xAngle / Math.sqrt(Math.pow(yAngle, 2) + Math.pow(zAngle, 2))) * 180 /Math.PI;
         pitch = (float)pitchX;
    }

    void calculateRoll(){

        double rollX = Math.atan(yAngle / Math.sqrt(Math.pow(xAngle, 2) + Math.pow(zAngle, 2))) * 180 / Math.PI; //αυτο μαλλον θα το κανει η κλαση του σουτ που θα δημιουργησω //
        roll = (float)rollX;

    }

    public void setMade(boolean shot){made = shot;}
   public boolean getMade(){return made;}

    public void setEvaluation(int evaluation){
        shotEvaluation = evaluation;
    }

    public int getEvaluation(){
        return shotEvaluation;
    }

    public void setX(float gotX){
        xAngle = gotX;
    }

    public void setY(float gotY){
        yAngle = gotY;
    }

    public void setZ(float gotZ){
        zAngle = gotZ;
    }

    public float getX(){
        return xAngle;
    }

    public float getY(){
        return yAngle;
    }

    public float getZ(){
        return zAngle;
    }

    public float getRoll(){
        return roll;
    }

    public float getPitch(){
        return pitch;
    }

    public boolean hasShot(){
        if ((roll > 5 &&roll  < 50) && (zAngle > -1.05 && zAngle<-0.7)&&( yAngle > 0&& yAngle<0.70)&&(xAngle > -0.65 && xAngle <0.2))    //  if ((roll > 5 &&roll  < 50) && (zAngle > -1.06 && zAngle<-0.5)&&(yAngle<0.70)&&(xAngle > -0.70 && xAngle>-0.7))
        {   //kai edv tha allaxoun oi times
            return true;
        }else{
            return false;
        }
    }

    public boolean startingPositionShot()
    {
        if((roll >= 55 && roll<=80) && (zAngle >=-0.8)&&(yAngle >0.60)&&(xAngle < 0.20 && xAngle >-0.65)) //if((roll >= 55 && roll<=80) && (zAngle<=-0.1 && zAngle >=-0.45)&&(yAngle < 0.90 && yAngle >0.75)&&(xAngle > -0.70 && xAngle>-0.7))
        {
            return true;
        }
        else{
            return false;
        }
    }
}
