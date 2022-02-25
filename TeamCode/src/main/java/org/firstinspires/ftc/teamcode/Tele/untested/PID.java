package org.firstinspires.ftc.teamcode.Tele.untested;

public class PID {
    private double kP;
    private double kD;
    private double kI;

    private double prevPos;

    private double desiredPos;

    public void setGoal(double desired){
        desiredPos=desired;
    }

    public PID(double KP, double KD, double KI){
        kP=KP;
        kD=KD;
        kI=KI;
    }

    public void update(double currentPos){
        prevPos = currentPos;
    }

    public double power(){
        double error = desiredPos-prevPos;
        kP
        return
    }

}
