package frc.robot.ScriptCommands;

import frc.robot.Autonomous.GrandForce_AutoEngineCommand;
import frc.robot.Subsystems.DrivetrainBot;

public class driveCommand extends GrandForce_AutoEngineCommand
{
    static {instruction = "drive";}

    @Override
    public void run(Double parameter) {
        double newParameter = parameter;
        Long driveTime = (long) newParameter*20; //Just a guess, has not been calibrated. Time is in milliseconds

        System.out.println("driving");

        DrivetrainBot.left_motors.set(1);
        DrivetrainBot.right_motors.set(1);

        try {
            Thread.sleep(driveTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        DrivetrainBot.left_motors.set(0);
        DrivetrainBot.right_motors.set(0);
    }
}
