package org.firstinspires.ftc.teamcode.Robot.SubSystems;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.FTC_API.Robot.SubSystems.SubSystem;

/**
 * Created by byron.nice on 9/26/2018.
 */
@Disabled
public class Arm extends SubSystem {
        private DcMotor liftMotor;
        private Servo hand;
        private Servo handLock;

        private String liftName;
        //private String handName;
        //private String handLockName;
        private final double LIFT_SPEED= 1;



        @Override
        public boolean init(HardwareMap hardwareDevices) {
            liftMotor = hardwareDevices.dcMotor.get(liftName);
            //hand = hardwareDevices.servo.get(handName);
            //handLock = hardwareDevices.servo.get(handLockName);
            liftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
            return true;
        }

        public void liftUp() {
            liftMotor.setPower(LIFT_SPEED);}
        public void stopLift() {
            liftMotor.setPower(0);}
        public void liftDown() {
            liftMotor.setPower(-LIFT_SPEED);}
        /*public void autoUp() {
            liftMotor.setPower(LIFT_SPEED),
                    wait(10000),
            liftMotor.setPower(0);
            ;}
        public void autoLiftDown() {
            liftMotor.setPower(-LIFT_SPEED),
            wait(10000),
            liftMotor.setPower(0),
             ;}
        */



        public Arm setMotorNames(String lift) {
            liftName = lift;
            return this;
        }

        public DcMotor getMotor(){
            return liftMotor;
        }
        //public Arm setServoNames(String hand, String handLock) {
            //handName = hand;
            //handLockName = handLock;
            //return this;
        //}


}
