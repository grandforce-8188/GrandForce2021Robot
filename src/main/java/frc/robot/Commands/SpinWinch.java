package frc.robot.Commands;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Subsystems.Winch;

public class SpinWinch 
{
 
 /**
  * Run the winch
  * @param FowardOrBack 0 = Spin Foward, 1 = Spin Reverse \ Percentage to spin motor at
  */
//  public static void RunWinch(Integer FowardOrBack, Double percent)
//  {
//     WPI_TalonSRX winch_motor = Winch.winch_motor;

//     if(FowardOrBack == 1)
//     {
//         winch_motor.set(-percent);
//     }
//     else if(FowardOrBack == 0)
//     {
//         winch_motor.set(TalonSRXControlMode.PercentOutput, percent);
//     }
//  }

//  /**
//   * Stops the winch motor
//   */
//  public static void StopWinch()
//  {
//     WPI_TalonSRX winch_motor = Winch.winch_motor;
//     winch_motor.set(0);
//  }
}
