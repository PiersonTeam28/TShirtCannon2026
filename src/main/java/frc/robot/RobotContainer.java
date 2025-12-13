// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.OperateCannon;
import frc.robot.commands.OperateElevator;
import frc.robot.subsystems.CannonUtil;
import frc.robot.subsystems.ElevatorUtil;


public class RobotContainer {
  /*
   * Define your Subsystems first!
   */
  private final ElevatorUtil elevatorUtil = new ElevatorUtil(Constants.ElevatorAngle.STOP);
  private final CannonUtil cannonUtil = new CannonUtil(Constants.CannonState.DEFAULT);

  /*
   * Define your Joysticks Third!
   */
  private final CommandXboxController joystick = new CommandXboxController(0);

  /*
   * Define regular variables last!
   */

  // private double MaxSpeed = TunerConstants.kSpeedAt12VoltsMps; // kSpeedAt12VoltsMps desired top speed
  private double MaxAngularRate = 1.5 * Math.PI; // 3/4 of a rotation per second max angular velocity

  public RobotContainer() {
    configureBindings();
    setDefaultCommands();
  }

  private void configureBindings() {
    joystick.y().whileTrue(new OperateElevator(elevatorUtil, Constants.ElevatorAngle.UP));
    joystick.a().whileTrue(new OperateElevator(elevatorUtil, Constants.ElevatorAngle.DOWN));
    joystick.x().onTrue(new OperateCannon(cannonUtil, Constants.CannonState.LOAD_SHORT));
    joystick.b().onTrue(new OperateCannon(cannonUtil, Constants.CannonState.LOAD_LONG));
    joystick.rightTrigger().onTrue(new OperateCannon(cannonUtil, Constants.CannonState.SHOOT));

 }

 private void setDefaultCommands(){
    cannonUtil.setDefaultCommand(new OperateCannon(cannonUtil, Constants.CannonState.DEFAULT));
    elevatorUtil.setDefaultCommand(new OperateElevator(elevatorUtil, Constants.ElevatorAngle.STOP));
 }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

}
