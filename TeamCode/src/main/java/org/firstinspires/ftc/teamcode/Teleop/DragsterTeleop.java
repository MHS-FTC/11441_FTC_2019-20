package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot.SubSystems.TwoWheelDrive;

@TeleOp(name = "Dragster Teleop")
public class DragsterTeleop extends OpMode {
    private TwoWheelDrive robot = new TwoWheelDrive();
    private float speedL = 0;
    private float speedR = 0;

    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {
        robot.tick();

        if(Math.abs(gamepad1.left_stick_y) >= 0.3) {
            speedL += -gamepad1.left_stick_y * 0.01;
        }else{
            speedL -= speedL * 0.2;
        }

        if(Math.abs(gamepad1.right_stick_y) >= 0.3) {
            speedR += -gamepad1.right_stick_y * 0.01;
        }else{
            speedR -= speedR * 0.2;
        }

        robot.driveTank(speedL, speedR);

        telemetry.addData("speedL", speedL);
        telemetry.addData("speedR", speedR);
    }
}
