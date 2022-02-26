package org.firstinspires.ftc.teamcode.Tele.untested.LinearSlide;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class LinSlideProgram {

    static final int low = 0; //encoder values
    static final int high = 2100;

    public enum states{LOW, HIGH,MID}
    static states state = states.LOW;

    public static void mainLSMethod(DcMotor LSM){//processes the info received from the opmode

            switch (state) {
                case LOW:
                    LSM.setPower(0.8);

                    return;

                case HIGH:

                    return;
                case MID:


                default:
                    return;
            }



    }

    public static void PressedLTrig(Gamepad GMP,DcMotor motor){
        if (GMP.left_trigger>0.1){
            mainLSMethod(motor);
        }
        return;
    }



}