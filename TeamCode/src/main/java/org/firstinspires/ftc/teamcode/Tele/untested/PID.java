package org.firstinspires.ftc.teamcode.Tele.untested;

public class PID {
    private double kP;
    private double kD;
    private double kI;
    final double ticksPerRot = 577.7;

    private double currentPos;

    private double desiredPos;
    private double prevError;
    private double errorSum;

    public void setGoal(double desired){
        desiredPos=desired;
    }

    public PID(double KP, double KD, double KI){
        kP=KP;
        kD=KD;
        kI=KI;
    }

    public void update(double currentPosit){
        currentPos = currentPosit;
    }

    public double power(){
        double error = desiredPos-currentPos;
        double p =  kP*error;
        double d = kD*(error-prevError);
        double i = kI*errorSum;
        double result = p+d+i;
        return result;
    }

}
