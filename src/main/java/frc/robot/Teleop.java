package frc.robot;

//import java.lang.FdLibm.Pow;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Commands.AimShooter;
import frc.robot.Commands.Drive;
import frc.robot.Commands.FireShooter;
import frc.robot.Commands.ShiftGears;
import frc.robot.Commands.SpinHopper;
import frc.robot.Commands.SpinIntake;
import frc.robot.Commands.SpinOutput;
import frc.robot.Commands.SpinWinch;
import frc.robot.Commands.UseIntakePistons;
import frc.robot.Periodic.Braking;
import frc.robot.Periodic.UpdateDashboard;
import frc.robot.Subsystems.DrivetrainBot;
import frc.robot.Subsystems.Limelight;
import frc.robot.Subsystems.Turret;



public class Teleop 
{
public static Integer DesiredRPM = (int) SmartDashboard.getNumber("Desired Shooter RPM", 0.0); // CHANGE ME TO DESIRED RPM, 0-6000

static XboxController DriveTrainController = Robot.DriveTrainController;
static Joystick DriveTrainJoystick = Robot.DrivetrainJoystick;
 public static void TeleopCommands()
 {
   JoystickControls();
   XboxControls();
}

 static Boolean Gearstate = false; //False = low gear, true = high gear
 static Boolean IntakeState = false; //False = raised, true = lowered
 static Boolean BrakeState = false; //False = braking enabled, True = braking disabled
 static Double ShooterState = 0.0;
 static Double ReverseState = 0.0; 

 public static void JoystickControls()
 {
    if(DriveTrainJoystick.getRawButtonPressed(11) == true)
    {
       Braking.DisableBraking();
    }
    else
    {
       Braking.EnableBraking();
    }

DrivetrainBot.Drivetrain.arcadeDrive(DriveTrainJoystick.getY(), Math.pow(-DriveTrainJoystick.getTwist(), 3)*2, true);


    if(DriveTrainJoystick.getRawButton(1) == true)
    {
       SpinIntake.RunIntake(0);
    }
    else if(DriveTrainJoystick.getRawButtonReleased(1) == true)
    {
       SpinIntake.StopIntake();
    }

    if(DriveTrainJoystick.getRawButtonPressed(6))
    {
       SpinIntake.RunIntake(1);
    }
    else if(DriveTrainJoystick.getRawButtonReleased(6))
    {
       SpinIntake.StopIntake();
    }

    if(DriveTrainJoystick.getRawButtonPressed(2))
    {
       if(Gearstate == false)
       {
          ShiftGears.ShiftDriveGears(1);
       }
       else if(Gearstate == true)
       {
          ShiftGears.ShiftDriveGears(0);
       }
    }

    if(DriveTrainJoystick.getRawButtonPressed(7))
    {
       SpinHopper.RunHopper(0);
    }
    else if(DriveTrainJoystick.getRawButtonReleased(7))
    {
       SpinHopper.StopHopper();
    }

    if(DriveTrainJoystick.getRawButtonPressed(8))
    {
       //SpinOutput.RunOutput(0);
       FireShooter.SpinShooter(100, 0);
    }
    else if(DriveTrainJoystick.getRawButtonReleased(8))
    {
       //SpinOutput.StopOutput();
       FireShooter.StopShooter();
    }
 }

 public static void XboxControls()
 {
    Boolean XboxYPressed = DriveTrainController.getYButtonPressed();

    Boolean XboxBPressed = DriveTrainController.getBButton();

    Boolean XboxXPressed = DriveTrainController.getXButton();
    Boolean XboxXReleased = DriveTrainController.getXButtonReleased();

    Boolean XboxAPressed = DriveTrainController.getAButton();
    Boolean XboxARelease = DriveTrainController.getAButtonReleased();

    Double RightTrigger = DriveTrainController.getTriggerAxis(Hand.kRight)/64;
    Double LeftTrigger = DriveTrainController.getTriggerAxis(Hand.kLeft)/64;

    Boolean XboxLeftBumperPressed = DriveTrainController.getBumper(Hand.kLeft);
    Boolean XboxLeftBumperReleased = DriveTrainController.getBumperReleased(Hand.kLeft);
    
    Boolean XboxRightBumperPressed = DriveTrainController.getBumper(Hand.kRight);
    Boolean XboxRightBumperReleased = DriveTrainController.getBumperReleased(Hand.kRight);

    Double XboxLeftJoystick = DriveTrainController.getX(Hand.kLeft);
    Double XboxRightJoystick = DriveTrainController.getY(Hand.kRight);

    if(XboxYPressed == true)
    {
      UseIntakePistons pistonBot = new UseIntakePistons();
      pistonBot.FireIntakePiston();
    }

    if(XboxXPressed == true)
    {
       //Limelight.LimelightOn();
       FireShooter.SpinShooter(DesiredRPM, 1);//Robot.DesiredRPM/6000, 1);
    }
    else if(XboxXReleased == true)
    {
       FireShooter.StopShooter();
    }

    if(XboxAPressed == true)
    {
      SpinHopper.RunHopper(1);
      //  Spin.LimelightOn();
      //  AimShooter.AimMain(Limelight.LimelightX, DesiredRPM);
    }
    else if(XboxARelease == true)
    {
      SpinHopper.StopHopper();
      //  Limelight.LimelightOff();
      //  FireShooter.StopShooter();
    }


    if(AimShooter.ShooterReady == true && RightTrigger > 0 && ShooterState > 0)
    {
      SpinOutput.RunOutput(0);
       SpinHopper.RunHopper(0);
    } 
    else if(ShooterState == 0.0 && RightTrigger == 0.0)
    {
       SpinHopper.StopHopper();
       SpinIntake.StopIntake();
    }

    if(XboxLeftBumperPressed == true)
    {
      SpinHopper.RunHopper(1);
    }
    else if(XboxLeftBumperReleased == true)
    {
       SpinHopper.StopHopper();
    }

    if(DriveTrainController.getRawButton(8))
    {
      SpinOutput.RunOutput(0);
    }
    else
    {
       SpinOutput.StopOutput();
    }

    if(XboxRightBumperPressed == true)
    {
       SpinIntake.RunIntake(0);
    }
    else if(XboxRightBumperReleased == true)
    {
       SpinIntake.RunIntake(1);
    }

    if(LeftTrigger > 0.0 && ReverseState >0)
    {
       FireShooter.SpinShooter(100, 1);
       SpinOutput.RunOutput(1);
       SpinHopper.RunHopper(1);
       SpinIntake.RunIntake(1);
    }

    if(XboxRightJoystick > 0 || XboxRightJoystick < 0)
    {
       Turret.turret_motor.set(XboxRightJoystick);
    }

    if(XboxLeftJoystick > 0 || XboxLeftJoystick < 0)
    {
       //SpinWinch.RunWinch(0, XboxLeftJoystick*100);
    }

    ShooterState = RightTrigger;
    ReverseState = LeftTrigger;
 }
}