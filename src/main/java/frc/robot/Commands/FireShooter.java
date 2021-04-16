package frc.robot.Commands;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import frc.robot.Functions.GetRPMtalonFX;
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

        // double setableRPM = rpm;

        // setableRPM = 2048.0 * rpm / 600;

        PIDController pid = new PIDController(0.35, 0, 0.0018, 0.005);

        if(Reverse == 0)
        {
            right_shooter.set(pid.calculate(GetRPMtalonFX.GetRPMTalonFX(right_shooter), rpm));
            left_shooter.set(pid.calculate(GetRPMtalonFX.GetRPMTalonFX(right_shooter), rpm));
        }
        else
        {
            right_shooter.set(1);
            left_shooter.set(-1);
        }

    } 
    public static void StopShooter()
    {
        WPI_TalonFX right_shooter = Shooter.shooter_right;
        WPI_TalonFX left_shooter = Shooter.shooter_left;

        left_shooter.set(0);
        right_shooter.set(0);

        left_shooter.set(TalonFXControlMode.Velocity, 500);
    }   
}