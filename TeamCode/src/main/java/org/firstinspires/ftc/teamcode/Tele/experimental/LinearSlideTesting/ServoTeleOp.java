package org.firstinspires.ftc.teamcode.Tele.experimental.LinearSlideTesting;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import java.util.concurrent.TimeUnit;

import org.firstinspires.ftc.teamcode.Tele.tested.initialize;
import org.firstinspires.ftc.teamcode.Tele.untested.intake;

@TeleOp
public class ServoTeleOp extends LinearOpMode {
    initialize initializer;
    @Override
    public void runOpMode() throws InterruptedException {
        initializer = new initialize(hardwareMap);
        initializer.initIntake();
        waitForStart();

        try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (Exception e) {
        }
        while(opModeIsActive()){
            intake.rotate(0.5);
        }
    }
}
