package frc.robot.Commands;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.PWMSparkMax;
import frc.robot.Subsystems.Output;

public class SpinOutput {
    /**
     * Runs the output
     * @param Reverse 0 = normal, 1 = reverse
     */
    public static void RunOutput(Integer Reverse)
    {
        PWMSparkMax output_motor = Output.output_motor;

        if(Reverse == 0)
        {
            output_motor.set(0.5);
        }
        else if(Reverse == 1)
        {
            output_motor.set(-0.5);
        }

    }

    /**
     * Stops the output motor
     */
    public static void StopOutput()
    {
        PWMSparkMax output_motor = Output.output_motor;
        output_motor.set(0);
    }
}
