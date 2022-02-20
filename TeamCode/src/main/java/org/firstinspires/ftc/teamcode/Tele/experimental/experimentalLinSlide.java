package org.firstinspires.ftc.teamcode.Tele.experimental;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Tele.untested.linSlide;


@TeleOp(name="LinSlideTest", group="experimental")
public class experimentalLinSlide extends LinearOpMode {

    public DcMotor LinSlideMotor;

    static final int low = 0; //encoder values
    static final int high = 2100;

    public enum states{LOW, HIGH} //states the slide can be in
    static linSlide.states state = linSlide.states.LOW;

    public static void setLSMotor(float LTrigger, float RTrigger, DcMotor LSMotor){

        moveLS(LTrigger, RTrigger, LSMotor);

        if(LSMotor.getCurrentPosition() == low){
            LSMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }
    }

    public static void moveLS(float LTrig, float RTrig, DcMotor LSM){
        switch (state){
            case LOW:
                if(LTrig == 1 && LSM.getCurrentPosition() != high){
                    state = linSlide.states.HIGH;
                    LSM.setTargetPosition(high);
                    while (LSM.getCurrentPosition() != high && RTrig != 1) {
                        LSM.setPower(0.9);
                        LSM.getCurrentPosition();
                    }

                }
                LSM.setPower(0);
                break;
            case HIGH:
                if(RTrig == 1 && LSM.getCurrentPosition() != low){
                    state = linSlide.states.LOW;
                    LSM.setTargetPosition(low);
                    while (LSM.getCurrentPosition() != low && LTrig != 1) {
                        LSM.setPower(0.9);
                        LSM.getCurrentPosition();
                    }

                }
                LSM.setPower(0.1);
                break;
            default:
                break;
        }
    }

    public void runOpMode() throws InterruptedException {

        LinSlideMotor = hardwareMap.dcMotor.get("LinSlideMotor");
        LinSlideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LinSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

           setLSMotor(gamepad1.left_trigger, gamepad1.right_trigger, LinSlideMotor);
            // linSlide.setLSMotor(gamepad1.left_trigger, gamepad1.right_trigger, LinSlideMotor);

        }

    }

}
