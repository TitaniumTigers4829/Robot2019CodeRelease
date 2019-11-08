/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.lift;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;

public class GroundFrontPartTwo extends TimedCommand {
  double groundPos;
  public GroundFrontPartTwo(double timeout, double pos) {
    super(Robot.lift.timeOut);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    //requires(Robot.lift);
    groundPos = pos;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.lift.groundPartTwo(groundPos);
    Robot.lift.manual();
    //Robot.lift.frontGround();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
