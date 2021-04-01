package frc.robot.Commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Subsystems.Turret;

public class SpinTurret 
{
    /**
     * Spin the turret left or right
     * @param LeftOrRight 0 = spin turret left, 1 = spin turret right
     */
public static void RotateTurret(Integer LeftOrRight)
{
    WPI_TalonSRX turret_motor = Turret.turret_motor;
    
    if(LeftOrRight==0)
    {
        turret_motor.set(-0.125);
    }
    else if(LeftOrRight == 1)
    {
        turret_motor.set(0.125);
    }
}    

/**
 * Stops the turret
 */
public static void StopTurret()
{
    WPI_TalonSRX turret_motor = Turret.turret_motor;
    turret_motor.set(0);
}
}
