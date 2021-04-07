package frc.robot.Autonomous;

import java.util.ArrayList;

public class GrandForce_AutoEngineCommandHandler
{
    ArrayList<GrandForce_AutoEngineCommand> tableOfCommands = new ArrayList();

    public void add(GrandForce_AutoEngineCommand command)
    {
        this.tableOfCommands.add(command);
    }

    public void handleCommands(String[] tableOfInstructions) //This is the void procedure that actually runs the instructions
    {
        for(int i = 0; i<tableOfInstructions.length; i++) //For each instruction in the array given to this void
        {
            String[] instruction = tableOfInstructions[i].split("/"); //Split instruction into the command to be run, and the parameter to run the command with,
            String command = instruction[0]; //Command
            Double parameter = Double.valueOf(instruction[1]); //Parameter

            for(int ii = 0; i<tableOfCommands.size(); i++)
            {
                if(command.equals(tableOfCommands.get(ii).instruction))
                {
                    tableOfCommands.get(ii).run(parameter);
                }
            }
        }
    }
}
