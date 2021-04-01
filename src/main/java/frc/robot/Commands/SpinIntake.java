package frc.robot.Commands;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Subsystems.Intake;

public class SpinIntake 
{
    /**
     *  Spins the intake
     * @param FowardOrBack 0 = spin foward, 1 = spin back
     */
 public static void RunIntake(Integer FowardOrBack)
 {
    WPI_VictorSPX intake_motor = Intake.intake_motor;

    if(FowardOrBack == 0)
    {
        intake_motor.set(1);
    }
    else if(FowardOrBack == 1)
    {
        intake_motor.set(-1);
    }
 }   

 /**
  * Stops the intake
  */
 public static void StopIntake()
 {
    WPI_VictorSPX intake_motor = Intake.intake_motor;
    intake_motor.set(0);
 }
}
