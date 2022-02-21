package org.firstinspires.ftc.teamcode.Tele.untested;

import com.qualcomm.robotcore.hardware.DcMotor;

public class linSlide {

    static final int low = 0; //encoder values
    static final int high = 2100;

    public enum states{LOW, HIGH, GOUP, GODOWN} //states the slide can be in
    static states state;

    public static void mainLSMethod(int receivedState, float LTrigger, float RTrigger, DcMotor LSMotor){
        //processes the info received from the opmode

        receiveCurrentState(receivedState);
        moveLS(LTrigger, RTrigger, LSMotor);

    }

    public static void moveLS(float LTrig, float RTrig, DcMotor LSM){ //moves the lin slide by setting the motor power

        int currentEncoderValue = LSM.getCurrentPosition();
        switch (state){
            case LOW:
                if(LTrig == 1 && currentEncoderValue <= high){
                    state = states.GOUP;
                }
                LSM.setPower(0);
                System.out.println(currentEncoderValue);
                break;

            case HIGH:
                if(RTrig == 1 && currentEncoderValue >= low){
                    state = states.GODOWN;
                }
                LSM.setPower(0.1);
                System.out.println(currentEncoderValue);
                break;

            case GOUP:
                LSM.setTargetPosition(high);
                LSM.setPower(0.9);
                currentEncoderValue = LSM.getCurrentPosition();

                if (currentEncoderValue >= high) {
                    state = states.HIGH;
                }

                if (RTrig == 1){
                    state = states.GODOWN;
                }

                System.out.println(currentEncoderValue);
                break;

            case GODOWN:
                LSM.setTargetPosition(low);
                LSM.setPower(0.9);
                currentEncoderValue = LSM.getCurrentPosition();

                if (currentEncoderValue <= low) {
                    state = states.LOW;
                }

                if (LTrig == 1){
                    state = states.GOUP;
                }

                System.out.println(currentEncoderValue);
                break;

            default:
                break;
        }
    }


    public static void receiveCurrentState(int theReceivedState){
        //receives the integer value corresponding to each state and converts it into a "states" type value
        if (theReceivedState == 0) {
            state = states.LOW;
        } else if (theReceivedState == 1) {
            state = states.HIGH;
        } else if (theReceivedState == 2) {
            state = states.GOUP;
        } else state = states.GODOWN;
    }

    public static states sendStateToOPMode(){ //send the current state to the op mode to "save it"
        return state;
    }

}
//end