package frc.robot.ScriptCommands;

import frc.robot.Autonomous.GrandForce_AutoEngineCommand;
import frc.robot.Commands.SpinHopper;
import frc.robot.Commands.SpinIntake;
import frc.robot.Commands.SpinOutput;
import frc.robot.Subsystems.DrivetrainBot;

public class driveAndintakeCommand extends GrandForce_AutoEngineCommand
{
    static {instruction = "drive+intake";}

    @Override
    public void run(Double parameter) {
        double newParameter = parameter;
        Long driveTime = (long) newParameter*20; //Just a guess, has not been calibrated. Time is in milliseconds

        System.out.println("driving and intaking");

        DrivetrainBot.left_motors.set(1);
        DrivetrainBot.right_motors.set(1);
        SpinIntake.RunIntake(0);
        SpinHopper.RunHopper(0);
        try {
            Thread.sleep(driveTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        DrivetrainBot.left_motors.set(0);
        DrivetrainBot.right_motors.set(0);
        SpinIntake.StopIntake();
        SpinOutput.StopOutput();
    }
}
