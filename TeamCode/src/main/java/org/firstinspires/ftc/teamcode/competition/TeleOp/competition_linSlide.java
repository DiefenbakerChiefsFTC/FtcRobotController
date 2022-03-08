package org.firstinspires.ftc.teamcode.competition.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;


public class competition_linSlide {


    static final double low = 0; //rotations
    static final double high = 4.1;

    public enum states{LOW, HIGH, TOLOW,TOHIGH,WAIT4DUMP} //states the slide can be in
    public static states state = states.LOW;
    private static competition_PID LSPID;


    public static DcMotorEx LinSlideMotor; //declares motor

    public static void setLSMotor(DcMotorEx LSMotor){
        LinSlideMotor = LSMotor;
        LinSlideMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LinSlideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LinSlideMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LinSlideMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        state= states.LOW;
        LSPID = new competition_PID(2.4,0.1,0.07);
    }

    public static void controllerInput(Gamepad gamepad1){
        moveLS(gamepad1.right_trigger >= 0.8);
    }

    public static void moveLS(boolean nextState){
        //System.out.println(LinSlideMotor.getPower());
        switch (state){
            case LOW:
                LinSlideMotor.setPower(0);
                if(nextState){
                    state = states.TOHIGH;
                    LSPID.setGoal(high);
                }
                return;

            case TOHIGH:
                LinSlideMotor.setPower(LSPID.power(LinSlideMotor.getCurrentPosition()));
                if(Math.abs(LSPID.checkDist())<20){
                    LinSlideMotor.setPower(0);
                    state= states.HIGH;
                }
                return;

            case HIGH:
                LinSlideMotor.setPower(0);
                if(nextState) {
                    competition_dump.dumpFreight();
                    state = states.WAIT4DUMP;
                }
                return;

            case WAIT4DUMP:
                competition_dump.update();
                if(!competition_dump.dumping){
                    state= states.TOLOW;
                    LSPID.setGoal(low);
                }
                return;


            case TOLOW:
                LinSlideMotor.setPower(LSPID.power(LinSlideMotor.getCurrentPosition()));
                if(Math.abs(LSPID.checkDist())<20){
                    LinSlideMotor.setPower(0);
                    state= states.LOW;
                }
                competition_dump.recover();
                return;

        }
    }
}
