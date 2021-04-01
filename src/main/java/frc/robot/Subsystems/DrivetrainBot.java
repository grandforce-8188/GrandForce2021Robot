package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DrivetrainBot 
{
   // Right Side Motors
   public static WPI_TalonFX motor_zero = new WPI_TalonFX(0); // Top Right
   public static WPI_TalonFX motor_one = new WPI_TalonFX(1); // Middle Right
   public static WPI_TalonFX motor_two = new WPI_TalonFX(2); // Bottom Right
   public static SpeedControllerGroup right_motors = new SpeedControllerGroup(motor_zero, motor_one, motor_two);
 
   // Left Side Motors
   public static WPI_TalonFX motor_three = new WPI_TalonFX(3); // Top Left
   public static WPI_TalonFX motor_four = new WPI_TalonFX(4); // Middle Left
   public static WPI_TalonFX motor_five = new WPI_TalonFX(5); // Bottom Left
   public static SpeedControllerGroup left_motors = new SpeedControllerGroup(motor_three, motor_four, motor_five);
 
   // Create A Differential Drive
   public static DifferentialDrive Drivetrain = new DifferentialDrive(left_motors, right_motors);   
}
