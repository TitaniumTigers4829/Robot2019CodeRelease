/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  WPI_TalonSRX liftFrontLeft;
  WPI_TalonSRX liftFrontRight;
  WPI_TalonSRX liftBackLeft;
  WPI_TalonSRX liftBackRight;
  double frontTopPos;
  double backTopPos;
  double frontGroundPos;
  public double timeOut;
  public double timeForward;

  public Lift() {
    liftFrontLeft = new WPI_TalonSRX(RobotMap.liftFrontLeft);
    liftFrontRight = new WPI_TalonSRX(RobotMap.liftFrontRight);
    liftBackLeft = new WPI_TalonSRX(RobotMap.liftBackLeft);
    liftBackRight = new WPI_TalonSRX(RobotMap.liftBackRight);
    liftFrontLeft.configFactoryDefault();
    liftBackLeft.configFactoryDefault();
    liftFrontLeft.follow(liftFrontRight);
    liftBackLeft.follow(liftBackRight);
    initTalons(liftFrontRight);
    initTalons(liftBackRight);
    liftBackRight.configMotionCruiseVelocity(1450);
    
    liftFrontRight.configMotionCruiseVelocity(1650);
    liftFrontRight.setSensorPhase(false);
    liftFrontRight.setInverted(true);
    liftBackRight.setInverted(false);
    liftBackLeft.setInverted(true);
    frontTopPos = RobotMap.liftFrontTopLevelTwoPosition;
    backTopPos = RobotMap.liftBackTopLevelTwoPosition;
    frontGroundPos = RobotMap.liftFrontGroundPosition;
    timeOut = 1.25;
    timeForward = .75;
    SmartDashboard.putString("Lift Setting", "Level 2");
  }

  public void initTalons(WPI_TalonSRX motor) {
    motor.setInverted(false);
    motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    motor.setSensorPhase(false);
    motor.config_kP(0, RobotMap.liftPValue);
    motor.config_kI(0, RobotMap.liftIValue);
    motor.config_kD(0, RobotMap.liftDValue);
    motor.configMotionCruiseVelocity(RobotMap.liftVel);
		motor.configMotionAcceleration(RobotMap.liftAccel);
    motor.configNominalOutputForward(0);
		motor.configNominalOutputReverse(0);
		motor.configPeakOutputForward(1);
    motor.configPeakOutputReverse(-1);
    motor.configAllowableClosedloopError(0, 0, 30);
    motor.setSelectedSensorPosition(0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void frontRaised() {
    liftFrontRight.set(ControlMode.MotionMagic, RobotMap.liftFrontRaisedPosition);
    SmartDashboard.putString("Lift Front Position", "Raised");
  }

  public void frontGround() {
    liftFrontRight.set(ControlMode.MotionMagic, frontGroundPos);
    SmartDashboard.putString("Lift Front Position", "Ground");
  }

  public void frontTop() {
    liftFrontRight.set(ControlMode.MotionMagic, frontTopPos);
    SmartDashboard.putString("Lift Front Position", "Top");
  }

  public void backGround() {
    liftBackRight.set(ControlMode.MotionMagic, RobotMap.liftBackGroundPosition);
    SmartDashboard.putString("Lift Back Position", "Ground");
  }

  public void backTop() {
    liftBackRight.set(ControlMode.MotionMagic, backTopPos);
    SmartDashboard.putString("Lift Back Position", "Top");
  }

  public void manual() {
    liftFrontRight.set(ControlMode.PercentOutput, -1);
    liftFrontLeft.set(ControlMode.PercentOutput, -1);
    //liftBackLeft.set(ControlMode.PercentOutput, Robot.oi.getY());
    //liftBackRight.set(ControlMode.PercentOutput, Robot.oi.getY());
    
  }

  public boolean frontIsGround() {
    return (liftFrontRight.getSelectedSensorPosition() < frontGroundPos + RobotMap.marginOfError && liftFrontRight.getSelectedSensorPosition() > frontGroundPos - RobotMap.marginOfError);
  }

  public boolean frontIsTop() {
    return (liftFrontRight.getSelectedSensorPosition() < frontTopPos + RobotMap.marginOfError && liftFrontRight.getSelectedSensorPosition() > frontTopPos - RobotMap.marginOfError);
  }

  public boolean backIsTop() {
    return (liftBackRight.getSelectedSensorPosition() < backTopPos + RobotMap.marginOfError && liftBackRight.getSelectedSensorPosition() > backTopPos - RobotMap.marginOfError);
  }

  public boolean backIsGround() {
    return (liftBackRight.getSelectedSensorPosition() < RobotMap.liftBackGroundPosition + RobotMap.marginOfError && liftBackRight.getSelectedSensorPosition() > RobotMap.liftBackGroundPosition - RobotMap.marginOfError);
  }

  public void groundPartTwo(double pos) {
    frontGroundPos = pos;
  }

  public void setLevel2() {
    frontTopPos = RobotMap.liftFrontTopLevelTwoPosition;
    backTopPos = RobotMap.liftBackTopLevelTwoPosition;
    timeOut = 1.25;
    timeForward = .75;
    SmartDashboard.putString("Lift Setting", "Level 2");
  }

  public void setLevel3() {
    frontTopPos = RobotMap.liftFrontTopPosition;
    backTopPos = RobotMap.liftBackTopPosition;
    timeOut = 2.2;
    timeForward = 2;
    SmartDashboard.putString("Lift Setting", "Level 3");
  }

}
