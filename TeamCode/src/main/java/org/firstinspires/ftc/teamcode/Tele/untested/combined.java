package org.firstinspires.ftc.teamcode.Tele.untested;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Tele.tested.initialize;

public class combined  extends LinearOpMode {
    private initialize initializer;

    @Override
    public void runOpMode() throws InterruptedException {
        initializer = new initialize(hardwareMap);
        initializer.initDT();
        initializer.initLS();
        initializer.initDump();
        initializer.initIntake();
        initializer.initCarou();

        waitForStart();
        intake.moveInitialServo();

        while(opModeIsActive()){
            drivechain.controllerInput(gamepad1);
            AndrewLinSlide.controllerInput(gamepad1);
            intake.controllerInput(gamepad1);
            Carousel.controllerInput(gamepad1);

            telemetry.addData("Linslide encoder",AndrewLinSlide.LinSlideMotor.getCurrentPosition());

        }

    }
}
