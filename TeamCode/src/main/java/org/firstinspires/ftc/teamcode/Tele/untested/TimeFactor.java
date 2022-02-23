package org.firstinspires.ftc.teamcode.Tele.untested;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

//import org.firstinspires.ftc.robotcore.external.Telemetry;

public class TimeFactor {

    //static final int low = 0; //encoder values
    //static final int high = 2100;

    public enum states{LOW, HIGH,/*MID*/}
    static states state = states.LOW;

    public static void mainLSMethod(DcMotor LSM){//processes the info received from the opmode
            switch (state) {
                case LOW:
                    //if(state == states.LOW) {
                        //LSM.setTargetPosition(high);
                    LSM.setPower(0.8);
                    try{
                        Thread.sleep(2500);
                        LSM.setPower(0);
                        state = states.HIGH;
                    }catch(InterruptedException e){
                        return;
                    }
                    //}
                    break;
                case HIGH:
                    //if(state == states.HIGH){
                        //LSM.setTargetPosition(low);
                    LSM.setPower(0.8);
                    try{
                        Thread.sleep(2500);
                        LSM.setPower(0);
                        state = states.LOW;
                    }catch(InterruptedException e){
                        return;
                    }
                    //}
                    break;
                /*case MID:
                    if(low < LSM.getCurrentPosition() && LSM.getCurrentPosition() < high){
                        LSM.setTargetPosition(low);
                        LSM.setPower(0.8);
                    }
                    break;*/
                default:
                    break;
            }
    }
    public static void PressedLTrig(Gamepad GMP,DcMotor motor){
        if (GMP.left_trigger>0.1){
            mainLSMethod(motor);
        }
    }
}
    /*public static void stopLSMethod(DcMotor LSM){
        if(LSM.getCurrentPosition()<= low ){
            state = states.LOW;
            LSM.setPower(0);
        } else if(LSM.getCurrentPosition() >= high){
            state = states.HIGH;
            LSM.setPower(0);
        }
    }*/


