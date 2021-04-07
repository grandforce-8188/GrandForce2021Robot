package frc.robot.ScriptCommands;

import frc.robot.Autonomous.GrandForce_AutoEngineCommand;

public class turnRCommand extends GrandForce_AutoEngineCommand
{
    static {instruction = "turnR";}

    @Override
    public void run(Double parameter) {
        System.out.println("turning right");
        super.run(parameter);
    }
}
