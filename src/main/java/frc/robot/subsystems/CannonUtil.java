// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CannonUtil extends SubsystemBase {
  /** Creates a new CannonUtil. */
  private TalonSRX solenoid;
  private TalonSRX trigger;

  public CannonUtil() {
    solenoid = new TalonSRX(Constants.SOLENOID);    // yankees suck
    trigger = new TalonSRX(Constants.TRIGGER);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
