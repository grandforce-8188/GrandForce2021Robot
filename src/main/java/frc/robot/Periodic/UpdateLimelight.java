package frc.robot.Periodic;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.Subsystems.Limelight;

public class UpdateLimelight 
{
    static NetworkTable NetTable = NetworkTableInstance.getDefault().getTable("limelight");

    public static void UpdateLimelightX()
    {
        NetworkTableEntry Limelight_ty = NetTable.getEntry("tv"); //Degrees Off Y
        NetworkTableEntry Limelight_tx = NetTable.getEntry("tx"); //Degrees Off X
        NetworkTableEntry Limelight_tv = NetTable.getEntry("ty"); //Has Target?
        NetworkTableEntry Limelight_tl = NetTable.getEntry("tl"); //Ping

        Limelight.LimelightX = Limelight_tx.getDouble(0);
        Limelight.LimelightY = Limelight_ty.getDouble(0);
        Limelight.LimelightHasTarget = Limelight_tv.getDouble(0);
    }
}
