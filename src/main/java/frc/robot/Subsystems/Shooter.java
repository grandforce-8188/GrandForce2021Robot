package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class Shooter 
{
  // Shooter Motors
  public final static WPI_TalonFX shooter_right = new WPI_TalonFX(9);
  public final static WPI_TalonFX shooter_left = new WPI_TalonFX(10);    
}
