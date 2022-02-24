package org.firstinspires.ftc.teamcode.Tele.untested;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;

public class AndrewLinSlide {

    static final int low = 0; //encoder values
    static final int high = 2100;

    public enum states{LOW, HIGH, TOLOW,TOHIGH,WAIT4DUMP} //states the slide can be in
    public static states state = states.LOW;
    public static double desirePower = 0;

    public static DcMotorEx LinSlideMotor = null; //declares motor

    public static void setLSMotor(DcMotorEx LSMotor){
        LinSlideMotor = LSMotor;
        LinSlideMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //LinSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LinSlideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public static void controllerInput(Gamepad gamepad1){
        moveLS(gamepad1.right_trigger == 1);
    }

    public static void moveLS(boolean nextState){
        //System.out.println(LinSlideMotor.getPower());
        switch (state){
            case LOW:
                LinSlideMotor.setPower(0);
                if(nextState && LinSlideMotor.getCurrentPosition() < high){
                    state = states.TOHIGH;
                }
                return;

            case TOHIGH:
                if(LinSlideMotor.getCurrentPosition()<high){
                    //LinSlideMotor.setPower(0.5);
                    LinSlideMotor.setVelocity(600);
                }else{
                    System.out.println(LinSlideMotor.getPower());
                    LinSlideMotor.setPower(0);
                    System.out.println(LinSlideMotor.getPower());
                    state=states.HIGH;
                }
                return;

            case HIGH:
                System.out.println(LinSlideMotor.getPower());
                LinSlideMotor.setPower(0);
                if(nextState) {
                    dump.dumpFreight();
                    state = states.WAIT4DUMP;
                }
                return;

            case WAIT4DUMP:
                dump.update();
                if(!dump.dumping){
                    state=states.TOLOW;
                }
                return;


            case TOLOW:
                if(LinSlideMotor.getCurrentPosition()>low){
                    //LinSlideMotor.setPower(0.5);
                    LinSlideMotor.setVelocity(-600);
                } else{
                    System.out.println(LinSlideMotor.getPower());
                    LinSlideMotor.setPower(0);
                    state=states.LOW;
                }
                dump.recover();
                return;

        }
    }


}
//end