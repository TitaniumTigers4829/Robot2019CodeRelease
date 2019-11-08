/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.beak;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * This command toggles the "neck" between opened and closed (see the "Beak" subsystem).
 * If the neck is currently extended, the "RetractNeck" command is scheduled.
 * If the neck is currently retracted, the "ExtendNeck" command is scheduled.
 */
public class ToggleNeck extends InstantCommand {
  /**
   * Add your docs here.
   */
  public ToggleNeck() {
    super();
    requires(Robot.beak);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    if(Robot.beak.neckPos) {
      RetractNeck ret = new RetractNeck(RobotMap.timeToExtend);      
      ret.start();
    } else {
      ExtendNeck ext = new ExtendNeck(RobotMap.timeToExtend);
      ext.start();
    }
  }

}
