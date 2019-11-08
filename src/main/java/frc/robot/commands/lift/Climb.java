/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.lift;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.commands.drivetrain.GoStraight;
import frc.robot.commands.drivetrain.GoStraight2;

public class Climb extends CommandGroup {
  /**
   * Add your docs here.
   */
  public Climb() {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
    addSequential(new GroundFront());
    addParallel(new TopFront());
    addSequential(new TopBack());
    addSequential(new GoStraight(RobotMap.autoForwardTime1,.35));
    addSequential(new GroundFrontPartTwo(1,RobotMap.liftFrontGroundPositionTwo));
    addSequential(new GoStraight(RobotMap.autoForwardTime2,.35));
    //addParallel(new GroundFrontPartTwo(1,3150));
    addParallel(new GoStraight2(RobotMap.autoForwardTime3,.75));
    addSequential(new GroundBack());
  }
}
