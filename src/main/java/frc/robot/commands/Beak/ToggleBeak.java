/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.beak;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * This command toggles the "beak" between opened and closed (see the "Beak" subsystem).
 * If the beak is currently opened, the "CloseBeak" command is scheduled.
 * If the beak is currently closed, the "OpenBeak" command is scheduled.
 */
public class ToggleBeak extends InstantCommand {
  /**
   * Add your docs here.
   */
  public ToggleBeak() {
    super();
    requires(Robot.beak);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    if(Robot.beak.beakPos) {
      CloseBeak clo = new CloseBeak();      
      clo.start();
    } else {
      OpenBeak ope = new OpenBeak();
      ope.start();
    }
  }

}
