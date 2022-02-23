package org.firstinspires.ftc.teamcode.Tele.experimental;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Tele.untested.linSlide;


@TeleOp(name="encoderTest", group="experimental")
public class LST extends LinearOpMode {

    public DcMotor LinSlideMotor;
    double CurrentPosition;
    public void runOpMode() throws InterruptedException {

        LinSlideMotor = hardwareMap.dcMotor.get("LinSlideMotor");
        LinSlideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LinSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

            LinSlideMotor.setPower(.1);
            LinSlideMotor.setTargetPosition(100);
            CurrentPosition = LinSlideMotor.getCurrentPosition();
            System.out.println(CurrentPosition);

        }
    }
}


