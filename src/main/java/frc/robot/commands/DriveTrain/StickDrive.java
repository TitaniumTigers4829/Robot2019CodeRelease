/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * This command uses the x, y, and z input from the drive joystick (see "OI") to operate the mecanum drive (see the "DriveTrain" subsystem).
 */
public class StickDrive extends Command {
  
  
  public StickDrive() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.driveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // Get the x, y, and z axes from the joystick.
    double x = Robot.oi.getX();
    double y = Robot.oi.getY();
    double z = Robot.oi.getZ();
    
    // Call mecanum drive.
    Robot.driveTrain.mecanumDrive(y,x,z);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    // Stop all drive motors.
    Robot.driveTrain.mecanumDrive(0,0,0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
