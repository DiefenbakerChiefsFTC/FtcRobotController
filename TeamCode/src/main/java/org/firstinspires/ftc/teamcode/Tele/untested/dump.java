package org.firstinspires.ftc.teamcode.Tele.untested;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

public class dump {
    static Servo dumpServo = null;
    static final double startPos = 0.3;
    static final double dumpPos = 1;
    static ServoController sCont = null;


    public static void setDumpServo(Servo DS){
        dumpServo = DS;
        dumpServo.setPosition(startPos);
        sCont = dumpServo.getController();
        sCont.pwmEnable();
    }

    //just add this function to state high in the linear slide, or whatever state it will be when the servo should be activated
    public static void dump(){//when you add this to the linear slide make sure it will stay at that spot for long enough
        dumpServo.setPosition(dumpPos);
    }

    //run this in the state when the linear slide is going back down
    public static void recover(){
        dumpServo.setPosition(startPos);
    }

}