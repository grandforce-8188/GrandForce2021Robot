package frc.robot.Commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import frc.robot.Subsystems.Shooter;

public class FireShooter
{
    /**
     * 
     * @param rpm Percent to spin the shooter at
     * @param Reverse 0 = Fire normally, 1 = reverse to clear jam
     */

    public static void SpinShooter(double rpm, Integer Reverse)
    {
        WPI_TalonFX right_shooter = Shooter.shooter_right;
        WPI_TalonFX left_shooter = Shooter.shooter_left;

        if(Reverse == 0)
        {
            right_shooter.set(rpm);
            left_shooter.set(-rpm);
        }
        else
        {
            right_shooter.set(-1);
            left_shooter.set(1);
        }

    } 
    public static void StopShooter()
    {
        WPI_TalonFX right_shooter = Shooter.shooter_right;
        WPI_TalonFX left_shooter = Shooter.shooter_left;

        left_shooter.set(0);
        right_shooter.set(0);
    }   
}