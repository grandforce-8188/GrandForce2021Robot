package frc.robot.Autonomous;

import frc.robot.Commands.*;
import frc.robot.Subsystems.DrivetrainBot;
import frc.robot.Subsystems.Limelight;

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
            double parameter = Double.parseDouble(instruction[1]); //Parameter
            switch(command) //This is the switch logic structure, used in this instance because it's neater than an if statement.
            {
                case "drive": //To add a command here just copy what you see, case "command":
                    Long driveTime = (long)parameter*20; //Just a guess, has not been calibrated. Time is in milliseconds
                    System.out.println("Driving");
                    for(double ii = 0; ii<parameter; ii++)
                    {
                        DrivetrainBot.left_motors.set(1);
                        DrivetrainBot.right_motors.set(1);
                        try {
                            Thread.sleep(driveTime);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        DrivetrainBot.left_motors.set(0);
                        DrivetrainBot.right_motors.set(0);
                    }
                    break;

                case "turnL":
                    System.out.println("Turning Left");
                    break;

                case "turnR":
                    System.out.println("Turning Right");
                    break;

                case "reverse":
                    System.out.println("Reversing");
                    Long reverseTime = (long)parameter*20; //Just a guess, has not been calibrated. Time is in milliseconds
                    System.out.println("Driving");
                    for(double ii = 0; ii<parameter; ii++)
                    {
                        DrivetrainBot.left_motors.set(-1);
                        DrivetrainBot.right_motors.set(-1);
                        try {
                            Thread.sleep(reverseTime);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        DrivetrainBot.left_motors.set(0);
                        DrivetrainBot.right_motors.set(0);
                    }
                    break;

                case "shoot":
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
                    break;

                case "intake":
                    System.out.println("Intaking");
                    SpinIntake.RunIntake(0);
                    try {
                        Thread.sleep(1000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;

                case "drive+intake":
                    System.out.println("Driving and Intaking");
                    break;
            }
        }
    }
}
