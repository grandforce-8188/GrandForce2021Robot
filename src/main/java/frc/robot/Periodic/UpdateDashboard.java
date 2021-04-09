package frc.robot.Periodic;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Teleop;
import frc.robot.Functions.GetRPMtalonFX;
import frc.robot.Subsystems.Shooter;

public class UpdateDashboard 
{
    private static final String CompetitionAuto = "Comp";

    private final static String GalacticSearch1Blue = "Galactic Search Path 1 Blue";
    private final static String GalacticSearch1Red = "Galactic Search Path 1 Red";
    private final static String GalacticSearch2Blue = "Galactic Search Path 2 Blue";
    private final static String GalacticSearch2Red = "Galactic Search Path 2 Red";
  
    private final static String BarrelRoll = "Barrel Racing";
    private final static String Slalom = "Slalom";
    private final static String Bounce = "Bounce";

    private final static SendableChooser<String> auto_chooser = new SendableChooser<>();

    public static String SelectedAuto;
    public static String ShooterAtRPM = "Shooter not at RPM";

    public static Double ShooterRPM = 6000.0;

    public static void DashboardInit()
    {
        SmartDashboard.putNumber("Desired Shooter RPM", ShooterRPM);
    }

    public static void RunUpdateDashboard() 
    {
        auto_chooser.setDefaultOption("Competition Auto", CompetitionAuto);
        auto_chooser.addOption("Galactic Search Path 1 Blue", GalacticSearch1Blue);
        auto_chooser.addOption("Galactic Search Path 1 Red", GalacticSearch1Red);
        auto_chooser.addOption("Galactic Search Path 2 Blue", GalacticSearch2Blue);
        auto_chooser.addOption("Galactic Search Path 2 Red", GalacticSearch2Red);
        auto_chooser.addOption("Barrel Roll", BarrelRoll);
        auto_chooser.addOption("Slalom", Slalom);
        auto_chooser.addOption("Bounce", Bounce);
        
        if(GetRPMtalonFX.GetRPMTalonFX(Shooter.shooter_left) < Teleop.DesiredRPM+40 && 
        GetRPMtalonFX.GetRPMTalonFX(Shooter.shooter_left) > Teleop.DesiredRPM -40)
        {
            ShooterAtRPM = "Shooter is at RPM";
        }
        else
        {
            ShooterAtRPM = "Shooter is not at RPM";
        }

        SmartDashboard.putData("Autonomous Options", auto_chooser);
        SelectedAuto = auto_chooser.getSelected();
    }
}
