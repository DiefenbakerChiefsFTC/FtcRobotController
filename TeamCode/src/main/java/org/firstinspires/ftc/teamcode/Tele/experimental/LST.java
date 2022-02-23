package org.firstinspires.ftc.teamcode.Tele.experimental;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;


@TeleOp(name="encoderTest", group="experimental")
public class LST extends LinearOpMode {

    public DcMotorEx LinSlideMotor = hardwareMap.get(DcMotorEx.class, "LinSlideMotor");

    public void runOpMode() throws InterruptedException {

        LinSlideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        waitForStart();

        LinSlideMotor.setTargetPosition(1000);
        LinSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LinSlideMotor.setVelocity(100);

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            telemetry.addData("Velocity", LinSlideMotor.getVelocity());
            telemetry.addData("Position", LinSlideMotor.getCurrentPosition());
            telemetry.addData("Target Reached", !LinSlideMotor.isBusy());
            telemetry.update();

        }
    }
}


