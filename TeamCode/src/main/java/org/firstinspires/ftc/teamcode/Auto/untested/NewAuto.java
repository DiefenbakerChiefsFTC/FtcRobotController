package org.firstinspires.ftc.teamcode.Auto.untested;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Tele.tested.initialize;
import org.firstinspires.ftc.teamcode.Tele.untested.drivechain;
import org.firstinspires.ftc.teamcode.Tele.untested.intake;

public class NewAuto extends LinearOpMode {
    initialize initializer = null;
    private ElapsedTime time;
    double startTime = 0;

    @Override
    public void runOpMode() throws InterruptedException {
        initializer = new initialize(hardwareMap);
        initializer.initDT();
        initializer.initLS();
        initializer.initDump();
        initializer.initCarou();
        initializer.initIntake();
        time = new ElapsedTime();

        waitForStart();
        intake.moveInitialServo();


    }

    public void turn90right(){
        startTime = time.time();
        drivechain.drive(0,0,1);// positive turning value to go right, negative to turn left
        while((time.time()-startTime)<1){
        }
        drivechain.drive(0,0,0);
    }

    public void turn90left(){
        startTime = time.time();
        drivechain.drive(0,0,-1);
        while((time.time()-startTime)<1){
        }
        drivechain.drive(0,0,0);
    }

}

