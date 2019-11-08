/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
  
  //Port ID's for talons
  public static int leftFrontTalon = 11;
  public static int leftBackTalon = 0;
  public static int rightFrontTalon = 2;
  public static int rightBackTalon = 8;
  public static int elevator = 9;
  public static int liftFrontLeft = 6;
  public static int liftFrontRight = 4;
  public static int liftBackLeft = 5;
  public static int liftBackRight = 7;
  //public static int ballArm1 = 9;
  //public static int ballArm2 = 10;
  //public static int ballArm3 = 1;

  //Port ID's for joysticks
  public static int driveStick = 0;
  public static int commandStick = 1;

  //Button ID's
  public static int beakButton = 1;
  public static int neckButton = 2;
  public static int elevatorBottomButton = 5;
  public static int elevatorMiddleButton = 3;
  public static int elevatorTopButton = 4;
  public static int elevatorManualButton = 8;
  public static int cancelButton = 9;
  public static int climbButton = 10;
  public static int lineButton = 6;
  public static int level2Button = 7;
  public static int level3Button = 8;

  //Channel ID's for pneumatics
  public static int beakForwardChannel = 3;
  public static int beakReverseChannel = 2;
  public static int neckForwardChannel = 0;
  public static int neckReverseChannel = 1;

  //Time in seconds it takes to extend the neck
  public static double timeToExtend = .5;

  //Constants for elevator PID system.
  public static double elevatorPValue = 1.3;
  public static double elevatorIValue = 0;
  public static double elevatorDValue = 0;
  public static double elevatorBottomPosition = 0;
  public static double elevatorMiddlePosition = 13000;
  public static double elevatorTopPosition = 25700;
  public static int elevatorVel = 2000;
  public static int elevatorAccel = 1500;

  //Constants for lift PID system.
  public static double liftPValue = 1.3;
  public static double liftIValue = 0;
  public static double liftDValue = 0;
  public static double liftBackGroundPosition = 0;
  public static double liftBackTopPosition = 20500;
  public static double liftBackTopLevelTwoPosition = 5850;
  public static double liftFrontRaisedPosition = 0;
  public static double liftFrontGroundPosition = 3150;
  public static double liftFrontGroundPositionTwo = 3150;
  public static double liftFrontTopPosition = 23900; //22900
  public static double liftFrontTopLevelTwoPosition = 9000;
  public static int liftVel = 3500;
  public static int liftAccel = 2000;
  public static int marginOfError = 300;
  
  //Drive timings for auto
  public static double autoForwardTime1 = 1;
  public static double autoForwardTime2 = 1.5;
  public static double autoForwardTime3 = 1.25;

  //Vision constants
  public static double rotationMargin = 50;
  public static double horizontalMargin = 50;
  public static double lineWidth = 50;
  public static double imageWidth = 400;
  public static double imageCenter = imageWidth/2;
}
