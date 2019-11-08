/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.GripPipeline;
import frc.robot.RobotMap;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.cscore.VideoSource.ConnectionStrategy;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.vision.VisionThread;

/**
 * The vision system refers to the cameras on the robot.
 * There are two USB cameras on the robot. 
 * One is the drive camera, used by the drivers to help drive, especially during the sandstorm period.
 * The other is the line camera, which is used to view lines on the field to help allignment for depositing game pieces.
 */
public class Vision extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  UsbCamera driveCam;
  UsbCamera lineCam;
  VideoSink camServer;
  VisionThread visionThread;
  double centerX = 0.0;
  double lineWidth = 0.0;
  boolean lineExists = false;
  private final Object imgLock = new Object();

  public Vision() {
    driveCam = CameraServer.getInstance().startAutomaticCapture(0);
    lineCam = CameraServer.getInstance().startAutomaticCapture(1);
    camServer = CameraServer.getInstance().getServer();
    driveCam.setFPS(15);
    driveCam.setResolution(320, 240);
    lineCam.setFPS(10);
    lineCam.setResolution(160,120);
    driveCam.setConnectionStrategy(ConnectionStrategy.kKeepOpen);
    lineCam.setConnectionStrategy(ConnectionStrategy.kKeepOpen);
    /*visionThread = new VisionThread(lineCam, new GripPipeline(), pipeline -> {
      if (!pipeline.filterContoursOutput().isEmpty()) {
        Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
        lineExists = true;
        synchronized (imgLock) {
          centerX = r.x + (r.width / 2);
          lineWidth = r.width;
        }
      } else {
        lineExists = false;
      }
    });
    visionThread.start();*/
  }

  public double rotationOffset() {
    double lineWidth;
    synchronized (imgLock) {
        lineWidth = this.lineWidth;
    }
    double offset = lineWidth - RobotMap.lineWidth;
    return offset;
  }

  public double horizontalOffset() {
    double centerX;
    synchronized (imgLock) {
        centerX = this.centerX;
    }
    double offset = centerX - RobotMap.imageCenter;
    return offset;
  }

  public boolean doesLineExist() {
    boolean lineExists;
    synchronized (imgLock) {
        lineExists = this.lineExists;
    }
    return lineExists;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
