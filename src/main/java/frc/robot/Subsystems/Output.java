package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class Output 
{
    public static PWMSparkMax output_motor = new PWMSparkMax(0);
    public static WPI_TalonSRX output_slave = new WPI_TalonSRX(15);

    public static SpeedControllerGroup outputs = new SpeedControllerGroup(output_motor, output_slave);
}
