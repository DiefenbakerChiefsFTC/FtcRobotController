package org.firstinspires.ftc.teamcode.Tele.experimental;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Tele.tested.initialize;
import org.firstinspires.ftc.teamcode.Tele.untested.AndrewLinSlide;
import org.firstinspires.ftc.teamcode.Tele.untested.dump;
import org.firstinspires.ftc.teamcode.Tele.untested.intake;

@TeleOp
public class experimentalLinSlide2 extends LinearOpMode {
    initialize initializer = null;

    @Override
    public void runOpMode() throws InterruptedException{
        initializer = new initialize(hardwareMap);
        initializer.initLS();
        initializer.initDump();
        initializer.initIntake();

        waitForStart();
        //comments

        while(opModeIsActive()){
            AndrewLinSlide.controllerInput(gamepad1);
            intake.controllerInput(gamepad1);

            telemetry.addData("linslide State: ",AndrewLinSlide.state.toString());
            telemetry.addData("linslide encoder: ",AndrewLinSlide.LinSlideMotor.getCurrentPosition());
            telemetry.addData("linslide power: ",AndrewLinSlide.LinSlideMotor.getPower());
            telemetry.update();

        }

    }

}
