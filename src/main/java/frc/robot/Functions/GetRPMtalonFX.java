package frc.robot.Functions;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class GetRPMtalonFX 
{
    /**
     * Function for getting the rpm of a TalonFX
     * @param Talon Input the talonFX motor you want to get the RPM for
     * @return and it returns the RPM
     */
    public static Double GetRPMTalonFX(WPI_TalonFX Talon)
    {
        Double RPM = Talon.getSelectedSensorVelocity();
        RPM = RPM *10;
        RPM = RPM *60;
        return RPM;
    }    
}