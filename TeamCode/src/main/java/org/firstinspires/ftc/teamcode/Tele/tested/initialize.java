package org.firstinspires.ftc.teamcode.Tele.tested;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Tele.untested.Carousel;
import org.firstinspires.ftc.teamcode.Tele.untested.drivechain;
import org.firstinspires.ftc.teamcode.Tele.untested.dump;
import org.firstinspires.ftc.teamcode.Tele.untested.intake;
import org.firstinspires.ftc.teamcode.Tele.untested.linSlide;

public class initialize extends LinearOpMode {

    DcMotor motorFrontLeft= null;
    DcMotor motorFrontRight = null;
    DcMotor motorBackLeft = null;
    DcMotor motorBackRight = null;
    DcMotor carouMotor = null;
    DcMotor LinSlideMotor = null;
    Servo dumpServo = null;
    CRServo intakeServo = null;


    public void setHardware(){
        motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");   //driving
        motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
        motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");
        motorBackRight = hardwareMap.dcMotor.get("motorBackRight");
        carouMotor = hardwareMap.dcMotor.get("carouMotor");           //carousel
        LinSlideMotor = hardwareMap.dcMotor.get("LinSlideMotor");     //linear slide
        dumpServo = hardwareMap.servo.get("dumpServo");               //dump servo
        intakeServo = hardwareMap.crservo.get("intakeServo");         //intake servo

    }

    public void initFunctions(){
        drivechain.setDTMotors(motorFrontLeft,motorFrontRight,motorBackLeft,motorBackRight);
        linSlide.mainLSMethod(gamepad1, 0, LinSlideMotor);
        Carousel.setCSMotor(carouMotor);
        dump.setDumpServo(dumpServo);
        intake.setIntakeServo(intakeServo);
    }

    @Override
    public void runOpMode() throws InterruptedException {

    }
}