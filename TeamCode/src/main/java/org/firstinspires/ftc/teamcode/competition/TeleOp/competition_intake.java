package org.firstinspires.ftc.teamcode.competition.TeleOp;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

public class competition_intake {
    static CRServo intakeServo;
    static ServoController sCont= null;
    static Servo initialServo;
    static ServoController ServoController1;

    //kinda like the dump servo code, but can be controlled with gamepad

    public static void setIntakeServo(CRServo INTK, Servo IS){
        initialServo = IS;
        ServoController1 = initialServo.getController();
        ServoController1.pwmEnable();
        intakeServo = INTK;
        sCont = intakeServo.getController();
        sCont.pwmEnable();
        initialServo.setPosition(0.5);//starting position

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
