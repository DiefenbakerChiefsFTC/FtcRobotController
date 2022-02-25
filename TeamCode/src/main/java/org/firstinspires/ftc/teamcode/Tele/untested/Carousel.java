package org.firstinspires.ftc.teamcode.Tele.untested;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;


public class Carousel {

    static DcMotor carouMotor = null;

    public static void setCSMotor(DcMotor CM){
        carouMotor = CM;
    }

    public static void controllerInput(Gamepad gamepad1){
        if(gamepad1.y){
            spin(1);
        }
        else{
            spin(0);
        }
    }

    public static void spin(double power){
        carouMotor.setPower(power);
    }

}