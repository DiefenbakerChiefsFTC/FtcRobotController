package org.firstinspires.ftc.teamcode.Tele.experimental.LinearSlideTesting;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;


@TeleOp(name="encoderTest", group="experimental")
public class LST extends LinearOpMode {

    //declared motor as DcMotorEx to implement velocity control in run to pos method.
    public DcMotorEx LinSlideMotor = hardwareMap.get(DcMotorEx.class, "LinSlideMotor");

    public void runOpMode() throws InterruptedException {

        LinSlideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); //resets encoder value to 0 at each initialization of opmode.

        waitForStart();

        LinSlideMotor.setTargetPosition(1000); //sets a relatively low range target position to test functionality of encoder
        LinSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION); //simple P function to turn 1000 ticks from 0
        LinSlideMotor.setVelocity(100); //set velocity. Expected to stop in 10 seconds at 100 ticks/second

        if (isStopRequested()) return;

        while (opModeIsActive()) {

            telemetry.addData("Velocity", LinSlideMotor.getVelocity()); //displays velocity on driver station phone.
            telemetry.addData("Position", LinSlideMotor.getCurrentPosition()); //displays the end pos on phone.
            telemetry.addData("Target Reached", !LinSlideMotor.isBusy()); //Only shows up if the target of 1000 ticks displacement is reached.
            telemetry.update(); //updates the telemetry display with latest info.

        }
    }
}


