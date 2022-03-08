package org.firstinspires.ftc.teamcode.competition.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Tele.tested.initialize;
import org.firstinspires.ftc.teamcode.Tele.untested.AndrewLinSlide;
import org.firstinspires.ftc.teamcode.Tele.untested.Carousel;
import org.firstinspires.ftc.teamcode.Tele.untested.drivechain;
import org.firstinspires.ftc.teamcode.Tele.untested.intake;


@TeleOp
public class competitionMain extends LinearOpMode {
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

        while(opModeIsActive()){
            competition_drivechain.controllerInput(gamepad1);
            competition_linSlide.controllerInput(gamepad1);
            competition_intake.controllerInput(gamepad1);
            competition_carousel.controllerInput(gamepad1);

        }

    }
}
