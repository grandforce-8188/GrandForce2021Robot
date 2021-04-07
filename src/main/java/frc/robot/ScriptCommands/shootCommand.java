package frc.robot.ScriptCommands;

import frc.robot.Autonomous.GrandForce_AutoEngineCommand;
import frc.robot.Commands.*;
import frc.robot.Subsystems.Limelight;

public class shootCommand extends GrandForce_AutoEngineCommand
{
    static {instruction = "shoot";}

    @Override
    public void run(Double parameter) {
        System.out.println("Shooting");
        Limelight.LimelightOn();
        AimShooter.AimMain(Limelight.LimelightX, Limelight.DesiredRPM);
        while(AimShooter.ShooterReady == false)
        {

        }
        SpinHopper.RunHopper(0);
        SpinOutput.RunOutput(0);
        try { //This may or may not work, it depends on whether or not motors spin while the thread is put to sleep, not able to test at this point -Dimitri.
            Thread.sleep(10000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SpinHopper.StopHopper();
        SpinIntake.StopIntake();
        FireShooter.StopShooter();
        Limelight.LimelightOff();
    }
}
