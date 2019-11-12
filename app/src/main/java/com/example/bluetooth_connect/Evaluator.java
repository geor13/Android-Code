package com.example.bluetooth_connect;

public class Evaluator {

   private Ball shotsToEvaluate[];

    Evaluator(Ball shotsTaken[]){
        shotsToEvaluate = shotsTaken;
    }

    public int getMadeShots(){

        Integer shotCounter = 0;
        for (int i=0; i<=9; i++){
            if(shotsToEvaluate[i].getMade()){
                shotCounter = shotCounter +1;
            }
        }
        return  shotCounter;
    }

    public int getTechniqueAverage(){

        Integer totalTechnique = 0;
        Integer techniqueAverage;

        for(int i=0; i<=9; i++){
            totalTechnique = totalTechnique +shotsToEvaluate[i].getEvaluation();
        }

        techniqueAverage = totalTechnique /10;
        return techniqueAverage;
    }

    public int getGoodTechniqueShots(){
        Integer goodTechniqueCounter =0;
        for(int i =0; i<=9 ;i++){
            if(shotsToEvaluate[i].getEvaluation()>79 && shotsToEvaluate[i].getEvaluation()<121){
                goodTechniqueCounter = goodTechniqueCounter +1;
            }
        }
        return goodTechniqueCounter;
    }

    public int getTotalXPpoints(){

        Integer totalPoints = 0;

        for(int i=0; i<=9; i++){
            if(shotsToEvaluate[i].getEvaluation()>79 && shotsToEvaluate[i].getEvaluation()<121){
                totalPoints = totalPoints + 40;
                if(shotsToEvaluate[i].getMade()){
                    totalPoints = totalPoints + 20;
                }
            }
            if(shotsToEvaluate[i].getEvaluation()>=0 && shotsToEvaluate[i].getEvaluation()<31){
                totalPoints = totalPoints + 10;
                if(shotsToEvaluate[i].getMade()){
                    totalPoints = totalPoints + 5;
                }
            }

            if(shotsToEvaluate[i].getEvaluation()>30 && shotsToEvaluate[i].getEvaluation()<81){
                totalPoints = totalPoints + 20;
                if(shotsToEvaluate[i].getMade()){
                    totalPoints = totalPoints + 10;
                }
            }

            if(shotsToEvaluate[i].getEvaluation()>120 && shotsToEvaluate[i].getEvaluation()<167){
                totalPoints = totalPoints + 20;
                if(shotsToEvaluate[i].getMade()){
                    totalPoints = totalPoints + 10;
                }
            }

            if(shotsToEvaluate[i].getEvaluation()>166 && shotsToEvaluate[i].getEvaluation()<=200){
                totalPoints = totalPoints + 10;
                if(shotsToEvaluate[i].getMade()){
                    totalPoints = totalPoints + 5;
                }
            }

        }

        totalPoints = totalPoints + getGoodTechniqueShots()*2;
        return totalPoints;
    }

    public int getConsecutiveMadeShots(){
        Integer consecutiveMade = 0;
        Integer maxConsecutive = 0;

        for(int i = 0; i<=9; i++){
            if(shotsToEvaluate[i].getMade()){
                consecutiveMade = consecutiveMade+1;
            } else{
                consecutiveMade = 0;
            }

            if(maxConsecutive < consecutiveMade){
                maxConsecutive = consecutiveMade;
            }
        }

        return maxConsecutive;
    }

    public int getConsecutiveGoodShots(){

        Integer cosecutiveGood = 0;
        Integer maxCosnecutiveGood = 0;

        for(int i =0; i<=9; i++){
            if(shotsToEvaluate[i].getEvaluation()>79 && shotsToEvaluate[i].getEvaluation()<121){
                cosecutiveGood = cosecutiveGood +1;
            }else{
                cosecutiveGood = 0;
            }

            if(maxCosnecutiveGood < cosecutiveGood){
                maxCosnecutiveGood = cosecutiveGood;
            }
        }

        return maxCosnecutiveGood;
    }

    public boolean checkForGold(){
        if((getTechniqueAverage()>50 && getTechniqueAverage() < 140)&&(getMadeShots()>=6)){ // (getTechniqueAverage()>50 && getTechniqueAverage() < 140)&&(getMadeShots()>=6)
            return true;
        } else{
            return false;
        }
    }

    public  boolean chechForSilver(){
        if((getTechniqueAverage()>30 && getTechniqueAverage()<167)&&(getMadeShots()>=5)){
            return true;
        } else{
            return false;
        }
    }

    public boolean checkForBronze(){
        if((getTechniqueAverage()>10 && getTechniqueAverage()<190)&&(getMadeShots()>=3)){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkForPearl(){
        if((getTechniqueAverage()>70 && getTechniqueAverage()<130)&&(getMadeShots()>=8)){
            return true;
        } else{
            return false;
        }
    }

    public boolean checkGoodTechniqueShot(){
        if(getGoodTechniqueShots()>=1){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkFiveConsecGoodShots(){
        if(getConsecutiveGoodShots()>=5){
            return true;
        } else{
            return false;
        }
    }



}
