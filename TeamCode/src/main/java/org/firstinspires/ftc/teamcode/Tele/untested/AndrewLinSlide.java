package org.firstinspires.ftc.teamcode.Tele.untested;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

public class AndrewLinSlide {

    static final double low = 0; //rotations
    static final double high = 4.1;

    public enum states{LOW, HIGH, TOLOW,TOHIGH,WAIT4DUMP} //states the slide can be in
    public static states state = states.LOW;
    private static PID LSPID;


    public static DcMotorEx LinSlideMotor; //declares motor

    public static void setLSMotor(DcMotorEx LSMotor){
        LinSlideMotor = LSMotor;
        LinSlideMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LinSlideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LinSlideMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LinSlideMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        state=states.LOW;
        LSPID = new PID(2.4,0.1,0.07);
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
                if(Math.abs(LSPID.checkDist())<5){
                    LinSlideMotor.setPower(0);
                    state=states.HIGH;
                }
                return;

            case HIGH:
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
                    LSPID.setGoal(low);
                }
                return;


            case TOLOW:
                LinSlideMotor.setPower(LSPID.power(LinSlideMotor.getCurrentPosition()));
                if(Math.abs(LSPID.checkDist())<5){
                    LinSlideMotor.setPower(0);
                    state=states.LOW;
                }
                dump.recover();
                return;

        }
    }


}
//end