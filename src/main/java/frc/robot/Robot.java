// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Autonomous.GrandForce_AutoEngine;
import frc.robot.Autonomous.GrandForce_AutoEngineCommandHandler;
import frc.robot.Commands.ShiftGears;
import frc.robot.Commands.UseIntakePistons;
import frc.robot.Periodic.Braking;
import frc.robot.ScriptCommands.*;
import frc.robot.Periodic.UpdateDashboard;
import frc.robot.Scripts.Auto.*;
import frc.robot.Subsystems.Limelight;
import frc.robot.Subsystems.Turret;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public final static XboxController DriveTrainController = new XboxController(0);
  public static final Joystick DrivetrainJoystick = new Joystick(1);
  public static Integer DesiredRPM = 2000; // CHANGE ME TO DESIRED RPM, 0-6000 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  public Compressor RobotCompressor = new Compressor(55);

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() 
  {
    UpdateDashboard.DashboardInit();
    ShiftGears.ShiftDriveGears(0);

    UseIntakePistons.ResetPiston();
    ShiftGears.ResetShifters();

    Limelight.LimelightOff();
    Turret.turret_motor.setNeutralMode(NeutralMode.Brake);

    RobotCompressor.setClosedLoopControl(true);
    }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() 
  {
    Braking.MainBraking();
    UpdateDashboard.RunUpdateDashboard();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit()
  {
    String SelectedAuto = UpdateDashboard.SelectedAuto;
    GrandForce_AutoEngine autoEngine = new GrandForce_AutoEngine();

    GrandForce_AutoEngineCommandHandler commandHandler = new GrandForce_AutoEngineCommandHandler();

    driveCommand drive = new driveCommand();
    driveAndintakeCommand driveAndIntake = new driveAndintakeCommand();
    reverseCommand reverse = new reverseCommand();
    shootCommand shoot = new shootCommand();
    turnLCommand turnL = new turnLCommand();
    turnRCommand turnR = new turnRCommand();

    commandHandler.add(drive);
    commandHandler.add(driveAndIntake);
    commandHandler.add(reverse);
    commandHandler.add(shoot);
    commandHandler.add(turnL);
    commandHandler.add(turnR);

    ArrayList<String> commands = new ArrayList<String>();
    String script = "";

    switch (SelectedAuto)
    {
      case "Comp":
        script = AutoScriptComp.script;
        break;

      case "Galactic Search Path 1 Blue" :
        script = AutoScriptGSB1.script;
        break;

      case  "Galactic Search Path 1 Red" :
        script = AutoScriptGSR1.script;
        break;

      case "Galactic Search Path 2 Blue" :
        script = AutoScriptGSB2.script;
        break;

      case "Galactic Search Path 2 Red" :
        script = AutoScriptGSR2.script;
        break;

      case "Barrel Racing":
        script = AutoScriptNavBarrel.script;
        break;

      case "Slalom" :
        script = AutoScriptNavSlalom.script;
        break;

      case "Bounce" :
        script = AutoScriptNavBounce.script;
        break;
    }

    try {
      commands = (ArrayList<String>) Arrays.asList(autoEngine.runEngine(script));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() 
  {

  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit()
  {

  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() 
  {
    Teleop.TeleopCommands();
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() 
  {
    RobotCompressor.close();
  }

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic()
  {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit()
  {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic()
  {}
}
