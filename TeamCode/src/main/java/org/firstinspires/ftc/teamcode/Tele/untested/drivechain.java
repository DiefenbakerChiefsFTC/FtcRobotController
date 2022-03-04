package org.firstinspires.ftc.teamcode.Tele.untested;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class drivechain {
    static DcMotor motorFrontLeft = null;
    static DcMotor motorFrontRight = null;
    static DcMotor motorBackLeft = null;
    static DcMotor motorBackRight = null;

    public static void setDTMotors(DcMotor FL,DcMotor FR,DcMotor BL,DcMotor BR){
        motorFrontLeft=FL;
        motorFrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorFrontRight=FR;
        motorFrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBackLeft = BL;
        motorBackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBackRight = BR;
        motorBackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }


    public static void controllerInput(Gamepad gamepad1){
        double x = gamepad1.left_stick_x;
        double y = gamepad1.left_stick_y;
        double rX = gamepad1.right_stick_x;
        double rY = gamepad1.right_stick_y;

        double absoluteDist= Math.sqrt(x*x + y*y );
        double absoluteDistR = Math.sqrt(rX*rX + rY* rY );


        if(absoluteDist<0.2){
            x = 0;
            y=0;
        }
        if(absoluteDistR<0.2){
            rX=0;
            rY=0;
        }
        drive(x, y, rX);
    }

    public static void drive(double y, double x, double turning){
        double rx = turning;
        x = x * 1.1;

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        motorFrontLeft.setPower(frontLeftPower);
        motorBackLeft.setPower(backLeftPower);
        motorFrontRight.setPower(frontRightPower);
        motorBackRight.setPower(backRightPower);

    }


}