package org.firstinspires.ftc.teamcode.Auto.untested;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Tele.tested.initialize;
import org.firstinspires.ftc.teamcode.Tele.untested.Carousel;
import org.firstinspires.ftc.teamcode.Tele.untested.drivechain;
import org.firstinspires.ftc.teamcode.Tele.untested.intake;

@Autonomous
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
        turn90left();
        turn90left();//turn around,
        move(2,0,0.5,0);//move right
        Carousel.spin(0.8);//turn the carousel
        timer(3);//do it for 3 seconds
        Carousel.spin(0);//stop
        turn90left();//turn left to face warehouse
        move(3,0.6,0,0);//take 3 seconds to enter the warehouse

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
    public void move(double seconds, double forwardPWR, double sidewaysPWR,double turnPWR){
        startTime = time.time();
        while(time.time()-seconds<seconds){
            drivechain.drive(forwardPWR,sidewaysPWR,turnPWR);
        }
        drivechain.drive(0,0,0);
    }
    public void timer(double seconds){
        startTime=time.time();
        while(time.time()-startTime<seconds){
            System.out.println("waiting");
        }
        return;
    }

}

