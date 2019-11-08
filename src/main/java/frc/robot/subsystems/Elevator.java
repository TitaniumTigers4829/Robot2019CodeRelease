/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * This subsystem is the elevator that the beak is mounted on.
 * The elevator uses a PID system to go to certain setpoints.
 * goBottom() sets the setpoint to the bottom level.
 * goMiddle() sets the setpoint to the middle level.
 * goTop() sets the setpoint to the top level.
 * goManual() lets the driver control the height from the joystick.
 */
public class Elevator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  WPI_TalonSRX elevator;
  public int offset = 0;

  public Elevator() {
    elevator = new WPI_TalonSRX(RobotMap.elevator);
    //elevator.setSafetyEnabled(true);
    //elevator.setExpiration(.65);
    elevator.setInverted(true);
    elevator.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    elevator.setSensorPhase(false);
    elevator.config_kP(0, RobotMap.elevatorPValue);
    elevator.config_kI(0, RobotMap.elevatorIValue);
    elevator.config_kD(0, RobotMap.elevatorDValue);
    elevator.configMotionCruiseVelocity(RobotMap.elevatorVel);
		elevator.configMotionAcceleration(RobotMap.elevatorAccel);
    elevator.configNominalOutputForward(0);
		elevator.configNominalOutputReverse(0);
		elevator.configPeakOutputForward(1);
    elevator.configPeakOutputReverse(-1);
    elevator.configAllowableClosedloopError(0, 0, 30);
    elevator.setSelectedSensorPosition(0);
    SmartDashboard.putString("Elevator Position", "Bottom");
  
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

  }

  public void goBottom() {
    elevator.set(ControlMode.MotionMagic, RobotMap.elevatorBottomPosition + offset);
    SmartDashboard.putString("Elevator Position", "Bottom");
  }

  public void goMiddle() {
    elevator.set(ControlMode.MotionMagic, RobotMap.elevatorMiddlePosition + offset);
    SmartDashboard.putString("Elevator Position", "Middle");
  }

  public void goTop() {
    elevator.set(ControlMode.MotionMagic, RobotMap.elevatorTopPosition + offset);
    SmartDashboard.putString("Elevator Position", "Top");
  }

  public void manual() {
    elevator.set(.5 * Robot.oi.commandGetY());
    System.out.println(elevator.getSelectedSensorPosition());
    SmartDashboard.putString("Elevator Position", "Manual");
  }
}
