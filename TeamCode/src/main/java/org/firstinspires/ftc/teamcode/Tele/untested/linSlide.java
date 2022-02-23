package org.firstinspires.ftc.teamcode.Tele.untested;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class linSlide {

    static final double totalTimeFromTopToBottom = 1000;

    static double lastStateChangeTime;
    static double timeMoving;

    public enum states{LOW, HIGH, GOUP, GODOWN}
    static states state = states.LOW;

    public static void mainLSMethod(Gamepad GMP, double elapsedTime, DcMotor LSM){//processes the info received from the opmode

        boolean LTrig = GMP.left_trigger == 1;
        boolean RTrig = GMP.right_trigger == 1;

        switch (state){
            case LOW:
                if(LTrig) {
                    state = states.GOUP;
                    lastStateChangeTime = elapsedTime;
                    timeMoving = totalTimeFromTopToBottom;
                }
                LSM.setPower(0);
                break;

            case HIGH:
                if(RTrig) {
                    state = states.GODOWN;
                    lastStateChangeTime = elapsedTime;
                    timeMoving = totalTimeFromTopToBottom;
                }
                LSM.setPower(0.05);
                break;

            case GOUP:
                if(RTrig){
                    state = states.GODOWN;
                    timeMoving = elapsedTime - lastStateChangeTime;
                    lastStateChangeTime = elapsedTime;
                }
                else if (elapsedTime - lastStateChangeTime > totalTimeFromTopToBottom || elapsedTime - lastStateChangeTime > timeMoving){
                    state = states.HIGH;
                }
                LSM.setPower(0.9);
                break;

            case GODOWN:
                if(LTrig){
                    state = states.GOUP;
                    timeMoving = elapsedTime - lastStateChangeTime;
                    lastStateChangeTime = elapsedTime;
                }
                else if (elapsedTime - lastStateChangeTime > totalTimeFromTopToBottom || elapsedTime - lastStateChangeTime > timeMoving){
                    state = states.LOW;
                }
                LSM.setPower(-0.9);
                break;

            default:
                break;
        }

    }

}



/*
package org.firstinspires.ftc.teamcode.Tele.untested;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class linSlide {

    static final int low = 0; //encoder values
    static final int high = 2100;

    public enum states{LOW, HIGH, GOUP, GODOWN}
    static states state = states.LOW;

    public static void mainLSMethod(Gamepad GMP, DcMotor LSM){//processes the info received from the opmode

        boolean LTrig = GMP.left_trigger == 1;
        boolean RTrig = GMP.right_trigger == 1;

        switch (state){
            case LOW:
                if(LTrig && LSM.getCurrentPosition() < high) state = states.GOUP;
                System.out.println(LSM.getCurrentPosition());

                LSM.setPower(0);
                return;

            case HIGH:
                if(RTrig && LSM.getCurrentPosition() > low) state = states.GODOWN;
                System.out.println(LSM.getCurrentPosition());

                LSM.setPower(0.1);
                return;

            case GOUP:
                if(LSM.getCurrentPosition() > high) state = states.HIGH;
                if(RTrig) state = states.GODOWN;
                System.out.println(LSM.getCurrentPosition());

                LSM.setPower(0.9);
                return;

            case GODOWN:
                if(LSM.getCurrentPosition() <= low) state = states.LOW;
                if(LTrig) state = states.GOUP;
                System.out.println(LSM.getCurrentPosition());

                LSM.setPower(-0.9);
                return;

            default:
                return;
        }


    }


}

 */