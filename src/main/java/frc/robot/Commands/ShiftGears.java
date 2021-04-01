package frc.robot.Commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Subsystems.Gearshifter;

public class ShiftGears 
{
    /**
     * Shift the drivetrain gear
     * @param UpOrDown as integer, 0 = shift down, 1 = shift up
     */
    public static void ShiftDriveGears(Integer UpOrDown)
    {
        Gearshifter.GearShifter.toggle();
        System.out.println("Gear Shifter");
    }

    public static void ResetShifters()
    {
        Gearshifter.GearShifter.set(Value.kReverse);
    }
}
