package frc.robot.Commands;

import frc.robot.Subsystems.Turret;

public class TuneTurret 
{

/**
 * Procedure for refining the turrets aim
 * @param LimelightX input the number of degrees off target from the limelight
 */
public static void RefineTurret(Integer LimelightX)
{

if(LimelightX > 0)
{
SpinTurret.RotateTurret(1);
}
else if(LimelightX < 0)
{
SpinTurret.RotateTurret(0);
}
else
{
Turret.turret_motor.set(0);
}
}    

}
