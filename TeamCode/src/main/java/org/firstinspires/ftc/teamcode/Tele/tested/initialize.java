package org.firstinspires.ftc.teamcode.Tele.tested;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Tele.untested.Carousel;
import org.firstinspires.ftc.teamcode.Tele.untested.drivechain;
import org.firstinspires.ftc.teamcode.Tele.untested.dump;
import org.firstinspires.ftc.teamcode.Tele.untested.intake;
import org.firstinspires.ftc.teamcode.Tele.untested.AndrewLinSlide;

public class initialize {

    DcMotor motorFrontLeft= null;
    DcMotor motorFrontRight = null;
    DcMotor motorBackLeft = null;
    DcMotor motorBackRight = null;
    DcMotor carouMotor = null;
    DcMotor LinSlideMotor = null;
    Servo dumpServo = null;
    CRServo intakeServo = null;
    HardwareMap hardwareMap= null;


    public initialize(HardwareMap HRDWRMAP){
        hardwareMap = HRDWRMAP;
    }
    public void initDT(){
        motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
        motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
        motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");
        motorBackRight = hardwareMap.dcMotor.get("motorBackRight");
        drivechain.setDTMotors(motorFrontLeft,motorFrontRight,motorBackLeft,motorBackRight);
    }
    public void initLS(){
        LinSlideMotor = hardwareMap.dcMotor.get("LinSlideMotor");
        AndrewLinSlide.setLSMotor(LinSlideMotor);
    }
    public void initCarou(){
        carouMotor = hardwareMap.dcMotor.get("carouMotor");
        Carousel.setCSMotor(carouMotor);
    }
    public void initIntake(){
        intakeServo = hardwareMap.crservo.get("intakeServo");
        intake.setIntakeServo(intakeServo);
    }
    public void initDump(){
        dumpServo = hardwareMap.servo.get("dumpServo");
        dump.setDumpServo(dumpServo);
    }


    public void initFunctions(){
        drivechain.setDTMotors(motorFrontLeft,motorFrontRight,motorBackLeft,motorBackRight);
        Carousel.setCSMotor(carouMotor);
        dump.setDumpServo(dumpServo);
        intake.setIntakeServo(intakeServo);
    }


}