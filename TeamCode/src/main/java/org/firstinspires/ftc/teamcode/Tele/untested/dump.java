package org.firstinspires.ftc.teamcode.Tele.untested;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;
import com.qualcomm.robotcore.util.ElapsedTime;

public class dump {
    static Servo dumpServo = null;
    static final double startPos = 0.3;
    static final double dumpPos = 1;
    static ServoController sCont = null;
    static boolean dumping = false;
    static double dumpTime = 0;
    static ElapsedTime runTime = null;



    public static void setDumpServo(Servo DS){
        dumpServo = DS;
        dumpServo.setPosition(startPos);
        sCont = dumpServo.getController();
        sCont.pwmEnable();//enables PWM. It's supposed to be on by default, but I'm just gonna turn it on again just in case.
        runTime = new ElapsedTime();
    }

    //just add this function to state high in the linear slide, or whatever state it will be when the servo should be activated
    public static void dumpFreight(){//when you add this to the linear slide make sure it will stay at that spot for long enough
        dumpServo.setPosition(dumpPos);
        if(!dumping){
            dumping=true;
            dumpTime= runTime.time();
        }
    }
    public static void update(){//checks if enough time has passed that we can say the dumping mechanism finished its task
        if(dumping&&(runTime.time()-dumpTime)>=1){
            dumping = false;
        }
    }

    //run this in the state when the linear slide is going back down returns dumping mechanism to starting position
    public static void recover(){
        dumpServo.setPosition(startPos);
    }

}