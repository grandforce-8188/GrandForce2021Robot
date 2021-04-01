package frc.robot.Periodic;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.Robot;
import frc.robot.Commands.Drive;
import frc.robot.Subsystems.DrivetrainBot;


public class Braking 
{
    static private WPI_TalonFX motor_zero = DrivetrainBot.motor_zero;
    static private WPI_TalonFX motor_one = DrivetrainBot.motor_one;
    static private WPI_TalonFX motor_two = DrivetrainBot.motor_two;
    static private WPI_TalonFX motor_three = DrivetrainBot.motor_three;
    static private WPI_TalonFX motor_four = DrivetrainBot.motor_four;
    static private WPI_TalonFX motor_five = DrivetrainBot.motor_five;
    static private Joystick DriveTrainJoystick = Robot.DrivetrainJoystick;

    static boolean BrakingEnabled = true;

    public static void MainBraking() 
    {
        if(BrakingEnabled == true)
        {
            Brake();
        }
        else if(BrakingEnabled == false)
        {
            StopBrake();
        }
    }

    public static void Brake()
    {
      if((DriveTrainJoystick.getY() < 0.05 && DriveTrainJoystick.getY() > -0.05) 
      && (DriveTrainJoystick.getTwist() < 0.05 && DriveTrainJoystick.getY() > -0.05))
      {
        motor_zero.setNeutralMode(NeutralMode.Brake);
        motor_one.setNeutralMode(NeutralMode.Brake);
        motor_two.setNeutralMode(NeutralMode.Brake);
        motor_three.setNeutralMode(NeutralMode.Brake);
        motor_four.setNeutralMode(NeutralMode.Brake);
        motor_five.setNeutralMode(NeutralMode.Brake);
      }
      else
      {
        motor_zero.setNeutralMode(NeutralMode.Coast);
        motor_one.setNeutralMode(NeutralMode.Coast);
        motor_two.setNeutralMode(NeutralMode.Coast);
        motor_three.setNeutralMode(NeutralMode.Coast);
        motor_four.setNeutralMode(NeutralMode.Coast);
        motor_five.setNeutralMode(NeutralMode.Coast);
      }
    }
    public static void StopBrake()
    {
        motor_zero.setNeutralMode(NeutralMode.Coast);
        motor_one.setNeutralMode(NeutralMode.Coast);
        motor_two.setNeutralMode(NeutralMode.Coast);
        motor_three.setNeutralMode(NeutralMode.Coast);
        motor_four.setNeutralMode(NeutralMode.Coast);
        motor_five.setNeutralMode(NeutralMode.Coast);
    }

    public static void EnableBraking() 
    {
        BrakingEnabled = true;
        MainBraking();
    }

    public static void DisableBraking()
    {
        BrakingEnabled = false;
        MainBraking();
    }

}
