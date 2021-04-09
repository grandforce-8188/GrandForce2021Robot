package frc.robot.Commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import frc.robot.Teleop;
import frc.robot.Functions.GetRPMtalonFX;
import frc.robot.Subsystems.Shooter;

public class AimShooter {
    static Integer max_shooter_rpm = Teleop.DesiredRPM;
    static WPI_TalonFX shooter_right = Shooter.shooter_right;

    public static void AimMain(Double LimelightX, double RequiredRPM) {
        AimTurret(LimelightX, RequiredRPM);
    }

    public static void AimTurret(Double LimelightX, double RequiredRPM) {
        Double limelightOffset = 0.0;
        if (LimelightX.equals(limelightOffset)) {
            RegulateRPM(RequiredRPM);
        } else if (LimelightX < 0) {
            SpinTurret.RotateTurret(1);
            AimMain(LimelightX, RequiredRPM);
        } else if (LimelightX > 0) {
            SpinTurret.RotateTurret(0);
            AimMain(LimelightX, RequiredRPM);
        }
    }

    public static void RegulateRPM(double RequiredRPM) {
    FireShooter.SpinShooter(((RequiredRPM / max_shooter_rpm) / 10), 0);
    try {
        Thread.sleep(250l);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    FireShooter.SpinShooter(((RequiredRPM / max_shooter_rpm) / 10)*2, 0);
    try {
        Thread.sleep(250l);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    
    FireShooter.SpinShooter(((RequiredRPM / max_shooter_rpm) / 10)*3, 0);
    try {
        Thread.sleep(250l);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    FireShooter.SpinShooter(((RequiredRPM / max_shooter_rpm) / 10)*4, 0);
    try {
        Thread.sleep(250l);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    FireShooter.SpinShooter(((RequiredRPM / max_shooter_rpm) / 10)*5, 0);
    try {
        Thread.sleep(250l);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    FireShooter.SpinShooter(((RequiredRPM / max_shooter_rpm) / 10)*6, 0);
    try {
        Thread.sleep(250l);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    FireShooter.SpinShooter(((RequiredRPM / max_shooter_rpm) / 10)*7, 0);
    try {
        Thread.sleep(250l);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    FireShooter.SpinShooter(((RequiredRPM / max_shooter_rpm) / 10)*8, 0);
    try {
        Thread.sleep(250l);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    FireShooter.SpinShooter(((RequiredRPM / max_shooter_rpm) / 10)*9, 0);
    try {
        Thread.sleep(250l);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    FireShooter.SpinShooter(((RequiredRPM / max_shooter_rpm) / 10)*10, 0);
    try {
        Thread.sleep(250l);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

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
