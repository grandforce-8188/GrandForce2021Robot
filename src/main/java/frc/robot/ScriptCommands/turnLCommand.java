package frc.robot.ScriptCommands;

import frc.robot.Autonomous.GrandForce_AutoEngineCommand;

public class turnLCommand extends GrandForce_AutoEngineCommand
{
    static {instruction = "turnL";}

    @Override
    public void run(Double parameter) {
        System.out.println("turning left");
        super.run(parameter);
    }
}
