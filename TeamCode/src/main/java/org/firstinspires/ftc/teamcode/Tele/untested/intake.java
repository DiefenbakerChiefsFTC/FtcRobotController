package org.firstinspires.ftc.teamcode.Tele.untested;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

public class intake {
    static CRServo intakeServo;
    static ServoController sCont= null;
    static Servo initialServo;

    //kinda like the dump servo code, but can be controlled with gamepad

    public static void setIntakeServo(CRServo INTK, Servo IS){
        initialServo = IS;
        intakeServo = INTK;
        sCont = intakeServo.getController();
        sCont.pwmEnable();
        initialServo.setPosition(0.4);
    }

    public static void controllerInput(Gamepad gamepad1){
        if(gamepad1.b){
            rotate(0.7);
        }
        else{ rotate(0);}

    }

    public static void rotate(double power){
        intakeServo.setPower(power);
    }

}
