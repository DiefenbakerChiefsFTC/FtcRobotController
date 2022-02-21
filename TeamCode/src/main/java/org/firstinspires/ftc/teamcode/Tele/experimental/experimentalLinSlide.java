package org.firstinspires.ftc.teamcode.Tele.experimental;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Tele.untested.linSlide;


@TeleOp(name="LinSlideTest", group="experimental")
public class experimentalLinSlide extends LinearOpMode {

    public DcMotor LinSlideMotor;
    int STATE = 0;

    public void runOpMode() throws InterruptedException {

        LinSlideMotor = hardwareMap.dcMotor.get("LinSlideMotor");
        LinSlideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LinSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

            System.out.println(LinSlideMotor.getCurrentPosition());
            linSlide.mainLSMethod(STATE, gamepad1.left_trigger, gamepad1.right_trigger, LinSlideMotor);
            sendCurrentState();
        }

    }

    public void sendCurrentState() { //takes the state of the lin slide and saves it as a int value for the next cycle of the while loop
        if (linSlide.sendStateToOPMode() == linSlide.states.LOW) {
            STATE = 0;
        } else if (linSlide.sendStateToOPMode() == linSlide.states.HIGH) {
            STATE = 1;
        } else if (linSlide.sendStateToOPMode() == linSlide.states.GOUP) {
            STATE = 2;
        } else STATE = 3;

    }

}
