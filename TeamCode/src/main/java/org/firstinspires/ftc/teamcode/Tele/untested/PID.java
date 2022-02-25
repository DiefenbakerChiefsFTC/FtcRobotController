package org.firstinspires.ftc.teamcode.Tele.untested;

import com.qualcomm.robotcore.util.ElapsedTime;

public class PID {
    private double kP;
    private double kD;
    private double kI;
    final double ticksPerRot = 537.7;

    private double prevTime;

    private double desiredPos;
    public double prevError;
    private double errorSum;
    private ElapsedTime time;

    public void setGoal(double desired){
        desiredPos=desired;
        errorSum=0;
        prevTime=time.time();
    }

    public PID(double KP, double KD, double KI){
        kP=KP;
        kD=KD;
        kI=KI;
        time = new ElapsedTime();
        prevTime = time.time();
        errorSum=0;
    }

    public double checkDist(){
        return prevError*ticksPerRot;
    }


    public double power(double encoder){
        double currentTime=time.time();
        double currentPos=encoder/ticksPerRot;
        double error = desiredPos-currentPos;
        if(Math.abs(error)<2) {
            errorSum += error * (currentTime - prevTime);
        }
        double p =  kP*error;
        double d = kD*((error-prevError)/(currentTime-prevTime));
        double i = kI*errorSum;
        double result = p+d+i;

        prevTime = currentTime;
        prevError = error;
        System.out.println(prevError);
        return result;
    }

}
