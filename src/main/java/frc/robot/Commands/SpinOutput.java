package frc.robot.Commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.Subsystems.Output;

public class SpinOutput {
    /**
     * Runs the output
     * @param Reverse 0 = normal, 1 = reverse
     */
    public static void RunOutput(Integer Reverse)
    {
        PWMSparkMax output_motor = Output.output_motor;
        WPI_TalonSRX output_slave = Output.output_slave;

        if(Reverse == 0)
        {
            output_motor.set(1);
            output_slave.set(-1);
        }
        else if(Reverse == 1)
        {
            output_motor.set(-1);
            output_slave.set(1);
            // Hello Jacob
            // you suck
        }

    }

    /**
     * Stops the output motor
     */
    public static void StopOutput()
    {
        PWMSparkMax output_motor = Output.output_motor;
        WPI_TalonSRX output_slave = Output.output_slave;
        output_motor.set(0);
        output_slave.set(0);
    }
}
