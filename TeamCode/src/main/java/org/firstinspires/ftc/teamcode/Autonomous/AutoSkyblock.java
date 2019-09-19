package org.firstinspires.ftc.teamcode.Autonomous;

import org.firstinspires.ftc.teamcode.Autonomous.Modules.EncoderDrive;
import org.firstinspires.ftc.teamcode.Autonomous.Modules.Wait;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.AutonomousBase;
import org.firstinspires.ftc.teamcode.FTC_API.Autonomous.Modules.Module;
import org.firstinspires.ftc.teamcode.Robot.CompRobot;

import static org.firstinspires.ftc.teamcode.Utilitys.Constants.DEFAULT_SPEED;
import static org.firstinspires.ftc.teamcode.Utilitys.Constants.turn;

public class AutoSkyblock extends AutonomousBase {
    private CompRobot bot = new CompRobot();
    private final Module[][] steps = new Module[][]{
            {new Wait().setWaitTime(500)},
            //scan for skyblock in 3 of the 6 blocks
            {
                    turn(-15),
                    new EncoderDrive().setDistances(24, 24).setSpeed(DEFAULT_SPEED),
                    turn(15),
            },
            {
                    new EncoderDrive().setDistances(25,25).setSpeed(DEFAULT_SPEED),
                    //grab block
                    new EncoderDrive().setDistances(25,25).setSpeed(DEFAULT_SPEED),
            },
            {
                    //grab block
                    turn(-115),
                    //grab Block
            },
            {
                    turn(-90),
                    new EncoderDrive().setDistances(40,40).setSpeed(DEFAULT_SPEED),
                    turn(-120),
            },
            {
                    new EncoderDrive().setDistances(40,40).setSpeed(DEFAULT_SPEED),
                    turn(15),
                    new EncoderDrive().setDistances(40,40).setSpeed(DEFAULT_SPEED),
            },
            {
                    turn(15),
                    new Wait().setWaitTime(100),
                    turn(15),
            },
    };

    @Override
    public void init() {
        init(hardwareMap,bot,steps);
    }

    @Override
    public void tick(){
        telemetry.addLine("Left" + bot.drive.getLeftSideMotors()[0].getCurrentPosition() +";"+bot.drive.getLeftSideMotors()[1].getCurrentPosition());
        telemetry.addLine("Right" + bot.drive.getRightSideMotors()[0].getCurrentPosition() +";"+bot.drive.getRightSideMotors()[1].getCurrentPosition());
    }
}




