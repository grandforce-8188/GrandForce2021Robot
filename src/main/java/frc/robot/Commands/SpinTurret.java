package frc.robot.Commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.controller.PIDController;
import frc.robot.Subsystems.Limelight;
import frc.robot.Subsystems.Turret;

public class SpinTurret 
{
    /**
     * Spin the turret left or right
     * @param LeftOrRight 0 = spin turret left, 1 = spin turret right
     */
public static void RotateTurret(Integer LeftOrRight)
{
    WPI_TalonSRX turret_motor = Turret.turret_motor;

    PIDController pid = new PIDController(0.35, 0, 0.0018);
    turret_motor.set(pid.calculate(Limelight.LimelightX, 10));
}    

/**
 * Stops the turret
 */
public static void StopTurret()
{
    WPI_TalonSRX turret_motor = Turret.turret_motor;
    turret_motor.set(0);
}
}
