/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class FollowLine extends Command {
  
  Timer timer;
  double previousTime;
  double previousWidth;
  boolean reversed;
  
  public FollowLine() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.driveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    timer = new Timer();
    timer.start();
    previousTime = timer.get();
    if(Robot.vision.doesLineExist()) {
      previousWidth = Robot.vision.rotationOffset();
    }
    reversed = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double rot = 0;
    double hor = 0;    
    if(Robot.vision.rotationOffset() > RobotMap.rotationMargin) {
      if(timer.get()-previousTime > .4) {
        if(previousWidth - Robot.vision.rotationOffset() < 0) {
          reversed = true;
        } else {
          reversed = false;
        }
        previousTime = timer.get();
        previousWidth = Robot.vision.rotationOffset();
      }

      if(reversed) {
        rot = .5;
      } else {
        rot = -.5;
      }
    }

    if(Robot.vision.horizontalOffset() > RobotMap.horizontalMargin) {
      hor = -.5;
    } else if(Robot.vision.horizontalOffset() < -RobotMap.horizontalMargin) {
      rot = .5;
    }

    Robot.driveTrain.mecanumDrive(0, hor, rot);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.vision.doesLineExist();
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
