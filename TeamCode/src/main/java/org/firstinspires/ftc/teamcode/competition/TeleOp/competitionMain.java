package org.firstinspires.ftc.teamcode.competition.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp (name= "competitionTeleOp")
public class competitionMain extends LinearOpMode {
    private competition_initialize initializer;

    @Override
    public void runOpMode() throws InterruptedException {
        initializer = new competition_initialize(hardwareMap);
        initializer.initDT();
        initializer.initLS();
        initializer.initDump();
        initializer.initIntake();
        initializer.initCarou();

        waitForStart();

        while(opModeIsActive()){
            competition_drivechain.controllerInput(gamepad1);
            competition_linSlide.controllerInput(gamepad1);
            competition_intake.controllerInput(gamepad1);
            competition_carousel.controllerInput(gamepad1);

        }

    }
}
