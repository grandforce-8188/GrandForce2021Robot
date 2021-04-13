package frc.robot.Subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight 
{
    public static Double LimelightX = 0.0;
    public static Double LimelightY = 0.0;
    public static Double LimelightHasTarget = 0.0;
    public static Double DesiredRPM = 4000.0;

    public static NetworkTable NetTable = NetworkTableInstance.getDefault().getTable("limelight");
    static NetworkTableEntry LimelightLED = NetTable.getEntry("ledMode");

    public static void LimelightOn() 
    {
        LimelightLED.setDouble(3);
    }
    public static void LimelightOff()
    {
        LimelightLED.setDouble(1);
    }
}
