package org.firstinspires.ftc.teamcode.Tele.experimental;

import static com.qualcomm.robotcore.hardware.DcMotor.*;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name="encoderTest", group="experimental")
public class LST extends LinearOpMode {

    public DcMotor LinSlideMotor;
    public void runOpMode() throws InterruptedException {

        LinSlideMotor = hardwareMap.dcMotor.get("LinSlideMotor");
        LinSlideMotor.setMode(RunMode.STOP_AND_RESET_ENCODER);
        LinSlideMotor.setMode(RunMode.RUN_TO_POSITION);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            LinSlideMotor.setTargetPosition(1000);
            //CurrentPos = LinSlideMotor.getCurrentPosition(); //uncomment this line and comment line 18 if reading returns 0
            telemetry.addData("Encoder Value", LinSlideMotor.getCurrentPosition());
            telemetry.update(); //updates telemetry each cycle.

        }
    }
}


