package frc.robot.Commands;

import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator.Validity;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Subsystems.IntakePiston;


public class UseIntakePistons 
{
/**
* Lowers the intake
*/

 public static void FireIntakePiston()
 { 
    System.out.println("Intake: " + IntakePiston.intake_solenoid.get());
    IntakePiston.intake_solenoid.toggle();
 }   

 public static void ResetPiston()
 {
    IntakePiston.intake_solenoid.set(Value.kForward);
 }
}
