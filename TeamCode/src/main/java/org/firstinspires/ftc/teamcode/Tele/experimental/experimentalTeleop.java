package org.firstinspires.ftc.teamcode.Tele.experimental;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Tele.tested.initialize;
import org.firstinspires.ftc.teamcode.Tele.untested.AndrewLinSlide;
import org.firstinspires.ftc.teamcode.Tele.untested.Carousel;
import org.firstinspires.ftc.teamcode.Tele.untested.drivechain;
import org.firstinspires.ftc.teamcode.Tele.untested.intake;

@TeleOp
public class experimentalTeleop  extends LinearOpMode {
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
            drivechain.controllerInput(gamepad1);
            AndrewLinSlide.controllerInput(gamepad1);
            intake.controllerInput(gamepad1);
            Carousel.controllerInput(gamepad1);

        }

    }
}

