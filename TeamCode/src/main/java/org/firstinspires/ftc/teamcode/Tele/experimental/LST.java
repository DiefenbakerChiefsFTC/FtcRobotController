package org.firstinspires.ftc.teamcode.Tele.experimental;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.Tele.untested.linSlide;


@TeleOp(name="encoderTest", group="experimental")
public class LST extends LinearOpMode {

    public DcMotor LinSlideMotor;
    public void runOpMode() throws InterruptedException {

        LinSlideMotor = hardwareMap.dcMotor.get("LinSlideMotor");
        LinSlideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LinSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        double CurrentPos = LinSlideMotor.getCurrentPosition(); //comment this line and uncomment line 28 if reading still returns 0

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

            LinSlideMotor.setPower(.5);
            LinSlideMotor.setTargetPosition(1000);
            //CurrentPos = LinSlideMotor.getCurrentPosition(); //uncomment this line and comment line 18 if reading returns 0
            System.out.println(CurrentPos);

        }
    }
}


