package frc.robot.Commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Subsystems.Hopper;

public class SpinHopper 
{
    public final static WPI_TalonSRX hopper_motor = Hopper.hopper_motor;
    
    /**
     * Spin the hopper
     * @param Reverse, 0 = normal, 1 = reverse
     */
    public static void RunHopper(Integer Reverse)
    {
        if(Reverse == 0)
        {
            hopper_motor.set(-0.5);
        }
        else if(Reverse == 1)
        {
            hopper_motor.set(0.5);
        }
    }

    /**
     * Stops the hopper
     */
    public static void StopHopper()
    {
        hopper_motor.set(0);
    }
}
