package org.firstinspires.ftc.teamcode.Tele.experimental;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Tele.untested.linSlide;


@TeleOp(name="LinSlideTest", group="experimental")
public class experimentalLinSlide extends LinearOpMode {

    public DcMotor LinSlideMotor;
    String STATE = "low";

    static final int low = 0; //encoder values
    static final int high = 2100;

    public void runOpMode() throws InterruptedException {

        LinSlideMotor = hardwareMap.dcMotor.get("LinSlideMotor");
        LinSlideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LinSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

            linSlide.mainLSMethod(STATE, LinSlideMotor);
            stateCheck();

        }

    }
    public void stateCheck(){
        switch (STATE){
            case "low":
                if(gamepad1.left_trigger==1) STATE = "goingUp";
                break;
            case "high":
                if(gamepad1.right_trigger==1) STATE = "goingDown";
                break;
            case "goingUp":
                if(LinSlideMotor.getCurrentPosition()>=high) STATE = "high";
                if(gamepad1.right_trigger==1) STATE = "goingDown";
                break;
            case "goingDown":
                if(LinSlideMotor.getCurrentPosition()<=low) STATE = "low";
                if(gamepad1.left_trigger==1) STATE = "goingUp";
                break;
        }
    }

}
