/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * The entire "beak" subsystem refers to the part of the robot designed to grab hatch panels.
 * open() and close() open and close the grabbing mechanism for hatch panels (the "beak").
 * extend() and retract() extend and retract the arm that the grabbing mechanism is mounted on (the "neck").
 * beakPos should be true if the beak is opened, and false if the beak is closed. The beak should start closed.
 * neckPos should be true if the neck is extended, and false if the neck is retracted. The neck should start retracted.
 */
public class Beak extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  DoubleSolenoid beakSol;
  DoubleSolenoid neckSol;
  public boolean beakPos;
  public boolean neckPos;

  public Beak() {
    beakSol = new DoubleSolenoid(RobotMap.beakForwardChannel, RobotMap.beakReverseChannel);
    neckSol = new DoubleSolenoid(RobotMap.neckForwardChannel, RobotMap.neckReverseChannel);
    beakPos = true;
    neckPos = false;
    beakSol.set(DoubleSolenoid.Value.kForward);
    SmartDashboard.putString("Beak Position", "Open");
    SmartDashboard.putString("Neck Position", "Closed");
  }

  public void Open() {
    beakSol.set(DoubleSolenoid.Value.kForward);
    beakPos = true;
    SmartDashboard.putString("Beak Position", "Open");
  }

  public void Close() {
    beakSol.set(DoubleSolenoid.Value.kReverse);
    beakPos = false;
    SmartDashboard.putString("Beak Position", "Closed");
  }

  public void Extend() {
    neckSol.set(DoubleSolenoid.Value.kForward);
    neckPos = true;
    SmartDashboard.putString("Neck Position", "Extended");
  }

  public void Retract() {
    neckSol.set(DoubleSolenoid.Value.kReverse);
    neckPos = false;
    SmartDashboard.putString("Neck Position", "Retracted");
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
