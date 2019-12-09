package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


/**
 * Created by Byron.Nice on 10/09/2019.
 */

public class MecanumWheelDrive{
    protected DcMotor leftFrontMotor;
    protected DcMotor rightFrontMotor;
    protected DcMotor leftBackMotor;
    protected DcMotor rightBackMotor;

    public static final String ID = "MecanumWheelDrive";

    private String leftFrontMotorName;
    private String RightFrontMotorName;
    private String leftBackMotorName;
    private String RightBackMotorName;

    @Override
    public boolean init(HardwareMap hardwareDevices) {
        leftFrontMotor = hardwareDevices.dcMotor.get("leftFrontMotor");
        rightFrontMotor = hardwareDevices.dcMotor.get("rightFrontMotor");
        leftBackMotor = hardwareDevices.dcMotor.get("leftBackMotor");
        rightBackMotor = hardwareDevices.dcMotor.get("rightBackMotor");

        leftFrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        runUsingAllEncoders();//use encoders to give more precise speed
        return true;
    }

    /**
     * @param leftPower  how fast the left motors should go
     * @param rightPower how fast the right motors should go
     */
    public void driveTank(double leftPower, double rightPower) {
        leftFrontMotor.setPower(leftPower);
        leftBackMotor.setPower(leftPower);
        rightFrontMotor.setPower(rightPower);
        rightBackMotor.setPower(rightPower);
    }

    @Override
    public void driveArcade(double forward, double turn) {
        double left = forward + turn;
        double right = forward - turn;

        driveTank(left, right);
    }


    /**
     * TODO: should dead zone joystick to insure we are not burning out motors
     *
     * @param forward how much to go forward and backwards, from -1 to 1, 1 is full forwards
     * @param rotate  how much to rotate, from -1 to 1, 1 is full right
     * @param strafe  how much to strafe, from -1 to 1, 1 is full right. left x = strafe
     */
    
    @Override
    public void driveMecanum(double forward, double rotate, double strafe) {
        double frontLeft = forward + rotate + strafe;
        double rearLeft = forward + rotate - strafe;
        double frontRight = forward - rotate - strafe;
        double rearRight = forward - rotate + strafe;

        leftFrontMotor.setPower(frontLeft);
        leftBackMotor.setPower(rearLeft);
        rightFrontMotor.setPower(frontRight);
        rightBackMotor.setPower(rearRight);

        // Where:
        // Ch1 = Right joystick X-axis
        // Ch3 = Left joystick Y-axis
        // Ch4 = Left joystick X-axis
    }
}
