/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.beak.ToggleBeak;
import frc.robot.commands.beak.ToggleNeck;
import frc.robot.commands.drivetrain.FollowLine;
import frc.robot.commands.elevator.ElevatorGoBottom;
import frc.robot.commands.elevator.ElevatorGoMiddle;
import frc.robot.commands.elevator.ElevatorGoTop;
import frc.robot.commands.lift.Cancel;
import frc.robot.commands.lift.Climb;
import frc.robot.commands.lift.GroundFront;
import frc.robot.commands.lift.SetLevel2;
import frc.robot.commands.lift.SetLevel3;
import frc.robot.commands.lift.TopBack;
import frc.robot.commands.lift.TopFront;
import frc.robot.commands.elevator.ElevatorGoManual;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  Joystick driveStick = new Joystick(RobotMap.driveStick);
  Joystick commandStick = new Joystick(RobotMap.commandStick);

  Button beakButton = new JoystickButton(commandStick, RobotMap.beakButton);
  Button neckButton = new JoystickButton(commandStick, RobotMap.neckButton);

  Button elevatorBottomButton = new JoystickButton(commandStick, RobotMap.elevatorBottomButton);
  Button elevatorMiddleButton = new JoystickButton(commandStick, RobotMap.elevatorMiddleButton);
  Button elevatorTopButton = new JoystickButton(commandStick, RobotMap.elevatorTopButton);
  //Button elevatorManualButton = new JoystickButton(commandStick, RobotMap.elevatorManualButton);

  Button climbButton = new JoystickButton(commandStick, RobotMap.climbButton);
  Button cancelButton = new JoystickButton(commandStick, RobotMap.cancelButton);
  Button level2Button = new JoystickButton(commandStick, RobotMap.level2Button);
  Button level3Button = new JoystickButton(commandStick, RobotMap.level3Button);

  Button lineButton = new JoystickButton(commandStick, RobotMap.lineButton);
  
  public OI() {
    beakButton.whenPressed(new ToggleBeak());
    neckButton.whenPressed(new ToggleNeck());
    elevatorBottomButton.whenPressed(new ElevatorGoBottom());
    elevatorMiddleButton.whenPressed(new ElevatorGoMiddle());
    elevatorTopButton.whenPressed(new ElevatorGoTop());
    climbButton.whenPressed(new Climb());
    cancelButton.whenPressed(new Cancel());
    //elevatorManualButton.toggleWhenPressed(new ElevatorGoManual());
    lineButton.toggleWhenPressed(new FollowLine());
    level2Button.whenPressed(new SetLevel2());
    level3Button.whenPressed(new SetLevel3());
  }

  // ButtonThere are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
  
  // Returns x-axis of the drive stick.
  public double getX(){
    return driveStick.getX();
  }

  // Returns y-axis of the drive stick.
  public double getY(){
    return -driveStick.getY();
  }

  // Returns z-rotation of the drive stick.
  public double getZ(){
    return driveStick.getRawAxis(3);
  }

  public double commandGetY() {
    return -commandStick.getY();
  }
}
