package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Tiny")
public class TinyTeleop extends OpMode {
    private Servo left = null;
    private Servo right = null;

    @Override
    public void init() {
        left = hardwareMap.servo.get("left");
        right = hardwareMap.servo.get("right");
    }

    @Override
    public void loop() {
        left.setPosition(0.5 - (-gamepad1.left_stick_y * 0.5));
        right.setPosition(0.5 - (-gamepad1.right_stick_y * 0.5));
    }
}
