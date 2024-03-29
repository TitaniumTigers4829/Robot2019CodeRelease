/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * This command sets the elevator to the top position (see the "Elevator" subsystem).
 */
public class ElevatorGoTop extends InstantCommand {
  /**
   * Add your docs here.
   */
  public ElevatorGoTop() {
    super();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.elevator);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    Robot.elevator.goTop();
  }

}
