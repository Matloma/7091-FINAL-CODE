// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {

  WPI_TalonSRX FL, BL, FR, BR;

  MotorControllerGroup leftMotors, rightMotors;

  DifferentialDrive driveTrain;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    FL = new WPI_TalonSRX(Constants.front_left_motor_port);
    BL = new WPI_TalonSRX(Constants.back_left_motor_port);
    FR = new WPI_TalonSRX(Constants.front_right_motor_port);
    BR = new WPI_TalonSRX(Constants.back_right_motor_port);

    BL.setInverted(true);
    BR.setInverted(true);

    leftMotors = new MotorControllerGroup(FL, BL);
    rightMotors = new MotorControllerGroup(FR, BR);

    driveTrain = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void arcadeDrive(Joystick stick){
    driveTrain.arcadeDrive(stick.getY(), stick.getX());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
