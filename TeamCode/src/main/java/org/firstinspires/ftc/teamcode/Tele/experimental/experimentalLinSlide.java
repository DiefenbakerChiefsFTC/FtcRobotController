package org.firstinspires.ftc.teamcode.Tele.experimental;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.Tele.untested.linSlide;


@TeleOp(name="LinSlideTest", group="experimental")
public class experimentalLinSlide extends LinearOpMode {

    public DcMotor LinSlideMotor;

    public void runOpMode() throws InterruptedException {

        LinSlideMotor = hardwareMap.dcMotor.get("LinSlideMotor");

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

            linSlide.mainLSMethod(gamepad1, System.currentTimeMillis(), LinSlideMotor);

        }

    }

}


