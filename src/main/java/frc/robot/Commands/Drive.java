package frc.robot.Commands;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.Subsystems.DrivetrainBot;

public class Drive 
{
    /**
     * Manually drive bot
     * @param LeftPercent Drives the left side at listed percent, 1-100
     * @param LeftReversed Is the left side reversed, true or false
     * @param RightPercent Drives the right side at listed percent, 1-100
     * @param RightReversed Is the right side reversed, true or false
     */
public static void DriveTheBot(Integer LeftPercent, Boolean LeftReversed, Integer RightPercent, Boolean RightReversed)
{
SpeedControllerGroup left_motors = DrivetrainBot.left_motors;
SpeedControllerGroup right_motors = DrivetrainBot.right_motors;

if(LeftReversed == false)
{
left_motors.set(LeftPercent);
}
else
{
left_motors.set(-LeftPercent);
}

if(RightReversed == false)
{
    right_motors.set(RightPercent);
}
else
{
    right_motors.set(-RightPercent);

}

}

public static void StopDriving()
{
    SpeedControllerGroup left_motors = DrivetrainBot.left_motors;
    SpeedControllerGroup right_motors = DrivetrainBot.right_motors;

    left_motors.set(0);
    right_motors.set(0);
}

}