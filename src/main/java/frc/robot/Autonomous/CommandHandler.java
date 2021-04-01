package frc.robot.Autonomous;

public class CommandHandler
{
    //This is an example of the command handler. In this new way of doing autonomous the engine does all the reading of JSON files and you then pass the resulting array into the command
    //handler, where it breaks up and actually executes the instruction. In the resources folder there is attached a default version of this class.
    public static void handleCommands(String[] tableOfInstructions) //This is the void procedure that actually runs the instructions
    {
        for(int i = 0; i<tableOfInstructions.length; i++) //For each instruction in the array given to this void
        {
            String[] instruction = tableOfInstructions[i].split("/"); //Split instruction into the command to be run, and the parameter to run the command with,
            String command = instruction[0]; //Command
            Double parameter = Double.valueOf(instruction[1]); //Parameter

            switch(command) //This is the switch logic structure, used in this instance because it's neater than an if statement.
            {
                case "drive": //To add a command here just copy what you see, case "command":
                    System.out.println("Driving");
                    break;

                case "turnL":
                    System.out.println("Turning Left");
                    break;

                case "turnR":
                    System.out.println("Turning Right");
                    break;

                case "reverse":
                    System.out.println("Reversing");
                    break;

                case "shoot":
                    System.out.println("Shooting");
                    break;

                case "intake":
                    System.out.println("Intaking");
                    break;

                case "drive+intake":
                    System.out.println("Driving and Intaking");
                    break;
            }
        }
    }
}
