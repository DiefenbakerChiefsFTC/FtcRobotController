package org.firstinspires.ftc.teamcode.competition.TeleOp;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Tele.untested.AndrewLinSlide;
import org.firstinspires.ftc.teamcode.Tele.untested.Carousel;
import org.firstinspires.ftc.teamcode.Tele.untested.drivechain;
import org.firstinspires.ftc.teamcode.Tele.untested.dump;
import org.firstinspires.ftc.teamcode.Tele.untested.intake;

public class competition_initialize {
    private DcMotor motorFrontLeft= null;
    private DcMotor motorFrontRight = null;
    private DcMotor motorBackLeft = null;
    private DcMotor motorBackRight = null;
    private DcMotor carouMotor = null;
    private DcMotorEx LinSlideMotor = null;
    private CRServo intakeServo = null;
    private Servo initServo= null;
    Servo dumpServo = null;

    HardwareMap hardwareMap= null;


    public competition_initialize(HardwareMap HRDWRMAP){
        hardwareMap = HRDWRMAP;
    }
    public void initDT(){
        motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
        motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
        motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");
        motorBackRight = hardwareMap.dcMotor.get("motorBackRight");
        competition_drivechain.setDTMotors(motorFrontLeft,motorFrontRight,motorBackLeft,motorBackRight);
    }
    public void initLS(){
        LinSlideMotor = (DcMotorEx) hardwareMap.dcMotor.get("LinSlideMotor");
        competition_linSlide.setLSMotor(LinSlideMotor);
    }
    public void initCarou(){
        carouMotor = hardwareMap.dcMotor.get("carouMotor");
        competition_carousel.setCSMotor(carouMotor);
    }
    public void initIntake(){
        initServo = hardwareMap.servo.get("initServo");
        intakeServo = hardwareMap.crservo.get("intakeServo");
        competition_intake.setIntakeServo(intakeServo, initServo);
    }
    public void initDump(){
        dumpServo = hardwareMap.servo.get("dumpServo");
        competition_dump.setDumpServo(dumpServo);
    }

}
