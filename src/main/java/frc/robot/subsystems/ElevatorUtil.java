// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.*;

public class ElevatorUtil extends SubsystemBase {
  /** Creates a new ElevatorUtil. */

  private TalonSRX elevator;
  
  public ElevatorUtil() {
    elevator = new TalonSRX(Constants.ELEVATOR);


  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
