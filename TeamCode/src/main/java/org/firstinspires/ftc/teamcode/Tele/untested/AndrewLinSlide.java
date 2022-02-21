package org.firstinspires.ftc.teamcode.Tele.untested;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class AndrewLinSlide {

    static final int low = 0; //encoder values
    static final int high = 2100;

    public enum states{LOW, HIGH, TOLOW,TOHIGH,WAIT4DUMP} //states the slide can be in
    static states state = states.LOW;

    static DcMotor LinSlideMotor = null; //declares motor

    public static void setLSMotor(DcMotor LSMotor){
        LinSlideMotor = LSMotor;
        LinSlideMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LinSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        if(LSMotor.getCurrentPosition() == low){
            LSMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }
    }

    public static void controllerInput(Gamepad gamepad1){
        moveLS(gamepad1.right_trigger == 1);
    }

    public static void moveLS(boolean nextState){
        switch (state){
            case LOW:
                LinSlideMotor.setPower(0);
                if(nextState && LinSlideMotor.getCurrentPosition() < high){
                    state = states.TOHIGH;
                }
                break;

            case TOHIGH:
                if(LinSlideMotor.getCurrentPosition()<high){
                    LinSlideMotor.setPower(0.9);
                }else{
                    LinSlideMotor.setPower(0);
                    state=states.HIGH;
                }
                break;

            case HIGH:
                LinSlideMotor.setPower(0);
                if(nextState) {
                    dump.dumpFreight();
                    state = states.WAIT4DUMP;
                }
                break;

            case WAIT4DUMP:
                dump.update();
                if(!dump.dumping){
                    state=states.TOLOW;
                }
                break;


            case TOLOW:
                dump.recover();
                if(LinSlideMotor.getCurrentPosition()>low){
                    LinSlideMotor.setPower(-0.9);
                } else{
                    LinSlideMotor.setPower(0);
                    state=states.LOW;
                }
                break;

            default:
                break;
        }
    }

}
//end