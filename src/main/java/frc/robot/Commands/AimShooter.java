package frc.robot.Commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.Teleop;
import frc.robot.Functions.GetRPMtalonFX;
import frc.robot.Subsystems.Shooter;

public class AimShooter 
{
    static Integer max_shooter_rpm = Teleop.DesiredRPM;
    static WPI_TalonFX shooter_right = Shooter.shooter_right;
    static WPI_TalonFX shooter_left = Shooter.shooter_left;

public static void AimMain(Double LimelightX, double RequiredRPM)
{
AimTurret(LimelightX, RequiredRPM);
}   

public static void AimTurret(Double LimelightX, double RequiredRPM)
{
    if(LimelightX == 0)
    {
        RegulateRPM(RequiredRPM);
    }
}

public static void RegulateRPM(double RequiredRPM)
{
    FireShooter.SpinShooter(RequiredRPM/max_shooter_rpm, 0);
    if(TestRPM(RequiredRPM)+50<=RequiredRPM && TestRPM(RequiredRPM)-50>=RequiredRPM)
    {
        ShooterReady = true;
    }
    else
    {
        ShooterReady = false;
    }
}
public static Boolean ShooterReady = false;
public static double TestRPM(double RequiredRPM)
{

    if(RequiredRPM == GetRPMtalonFX.GetRPMTalonFX(shooter_right) || 
    (GetRPMtalonFX.GetRPMTalonFX(shooter_right) < RequiredRPM+40 && GetRPMtalonFX.GetRPMTalonFX(shooter_right) > RequiredRPM -40))
    {
        ShooterReady = true;
    }
    else
    {
        ShooterReady = false;
        if(RequiredRPM>GetRPMtalonFX.GetRPMTalonFX(shooter_right))
        {
            RequiredRPM -= 10;
            RegulateRPM(RequiredRPM);
        }
        else if(RequiredRPM < GetRPMtalonFX.GetRPMTalonFX(shooter_right))
        {
            RequiredRPM += 10;
        }
    }
    return RequiredRPM;
}
}
