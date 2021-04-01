package frc.robot.Autonomous;

import frc.robot.Teleop;
import frc.robot.Commands.AimShooter;
import frc.robot.Commands.Drive;
import frc.robot.Subsystems.Limelight;

public class Comp 
{
    static Integer CompAutoCycle = 0;
    public static void CompAuto()
    {
        if(CompAutoCycle <= 50)
        {
            Drive.DriveTheBot(75, true, 75, true);
        }
        else if(CompAutoCycle == 51)
        {
            Drive.StopDriving();
            //Limelight.LimelightOn();
        }
        else if(CompAutoCycle > 52 && CompAutoCycle < 150)
        {
            //AimShooter.AimMain(Limelight.LimelightX, Teleop.DesiredRPM);
        }
        else if(CompAutoCycle == 150)
        {
            //Limelight.LimelightOff();
        }
        CompAutoCycle ++;
        CompAuto();
    }    
}
