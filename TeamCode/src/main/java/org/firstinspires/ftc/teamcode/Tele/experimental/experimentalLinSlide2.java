/*package org.firstinspires.ftc.teamcode.Tele.experimental;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Tele.tested.initialize;
import org.firstinspires.ftc.teamcode.Tele.untested.AndrewLinSlide;


public class experimentalLinSlide2 extends LinearOpMode {
    initialize initializer = null;

    @Override
    public void runOpMode() throws InterruptedException{
        initializer = new initialize(hardwareMap);
        initializer.initFunctions();

        waitForStart();
        //comments

        while(opModeIsActive()){
            AndrewLinSlide.controllerInput(gamepad1);

            telemetry.addData("linslide State: ",AndrewLinSlide.state.toString());
            telemetry.update();

        }

    }

}
*/