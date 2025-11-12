package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class Cannon extends SubsystemBase {
    private TalonSRX solenoid;
    private TalonSRX trigger;
    private TalonSRX elevator;
    private boolean loading = false;
    private boolean loaded = false;

    public Cannon() {
        solenoid = new TalonSRX(20);
        trigger = new TalonSRX(16);
        elevator = new TalonSRX(15);
    }

    public InstantCommand moveUp() {
        return new InstantCommand(() -> elevator.set(TalonSRXControlMode.PercentOutput, 1));
    }

    public InstantCommand moveDown() {
        return new InstantCommand(() -> elevator.set(TalonSRXControlMode.PercentOutput, -1));
    }

    public InstantCommand stopElevator() {
        return new InstantCommand(() -> elevator.set(TalonSRXControlMode.PercentOutput, 0));
    }

    public SequentialCommandGroup loadLongShot() {
        if (!loading && !loaded) {
            return new InstantCommand(() -> {
                solenoid.set(TalonSRXControlMode.PercentOutput, 1);
                loading = true;
            }).andThen(new WaitCommand(1.5)).andThen(() -> {
                solenoid.set(TalonSRXControlMode.PercentOutput, 0);
                loading = false;
                loaded = true;
            });
        } else return new SequentialCommandGroup(new InstantCommand());
    }

    public SequentialCommandGroup loadShortShot() {
        if (!loading && !loaded) {
            return new InstantCommand(() -> {
                solenoid.set(TalonSRXControlMode.PercentOutput, 1);
                loading = true;
            }).andThen(new WaitCommand(1)).andThen(() -> {
                solenoid.set(TalonSRXControlMode.PercentOutput, 0);
                loading = false;
                loaded = true;
            });
        } else return new SequentialCommandGroup(new InstantCommand());
    }

    public InstantCommand shoot(Trigger leftTrigger) {
        return new InstantCommand(() -> {
            if (leftTrigger.getAsBoolean() && loaded) {
                trigger.set(TalonSRXControlMode.PercentOutput, 1);
            }
        });
    }
    
    public InstantCommand stopShooting() {
        loaded = false;
        return new InstantCommand(() -> trigger.set(TalonSRXControlMode.PercentOutput, 0));
    }
}
