package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PWMSparkMax;

public class Output 
{
    public final static PWMSparkMax output_motor = new PWMSparkMax(0);
}
