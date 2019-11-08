/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.drivetrain.StickDrive;

/**
 * The drive train refers to the main driving system of the robot.
 * This drive train is a mecanum drive, meaning it can go forwards and backwards, strafe left and right, and rotate left and right.
 * mecanumDrive(y, x, z) drives the robot forward y, horizontal x, and rotates z.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  WPI_TalonSRX leftFront;
  WPI_TalonSRX leftBack;
  WPI_TalonSRX rightFront;
  WPI_TalonSRX rightBack;
  MecanumDrive mecanumDrive;

  // Called when the subsystem is constructed.
  public DriveTrain(){
    // Initialize Talons and mecanum drive.
    leftFront = new WPI_TalonSRX(RobotMap.leftFrontTalon);
    leftBack = new WPI_TalonSRX(RobotMap.leftBackTalon);
    rightFront = new WPI_TalonSRX(RobotMap.rightFrontTalon);
    rightBack = new WPI_TalonSRX(RobotMap.rightBackTalon);
    leftFront.configFactoryDefault();
    leftBack.configFactoryDefault();
    rightFront.configFactoryDefault();
    rightBack.configFactoryDefault();
    mecanumDrive = new MecanumDrive(leftFront, leftBack, rightFront, rightBack);
  }

  public void mecanumDrive(double y, double x, double z){
    // Drive with the given x, y, and z inputs, and the gyro for relative to field driving.
    mecanumDrive.driveCartesian(x, y, z);
    
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command to driving with the joysticks.
    setDefaultCommand(new StickDrive());
  }
}
