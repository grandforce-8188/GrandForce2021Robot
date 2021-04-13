package frc.robot.Commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.controller.PIDController;
import frc.robot.Subsystems.Limelight;
import frc.robot.Subsystems.Turret;
import frc.robot.Teleop;
import frc.robot.Functions.GetRPMtalonFX;
import frc.robot.Subsystems.Shooter;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class AimShooter {
    static Double max_shooter_rpm = Teleop.DesiredRPM;
    static WPI_TalonFX shooter_right = Shooter.shooter_right;
    static Double LimelightX = Limelight.LimelightX;

    public static boolean AimMain(Double RequiredRPM) {
        Limelight.LimelightOn();
         try {
             Thread.sleep(250l);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

         SpinTurret.RotateTurret();

        if(Limelight.LimelightX == 15)
        {
            FireShooter.SpinShooter(RequiredRPM, 0);
            return true;
        }
        else
        {
            return false;
        }
    }
}