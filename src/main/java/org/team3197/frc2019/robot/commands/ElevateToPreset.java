package org.team3197.frc2019.robot.commands;

import org.team3197.frc2019.robot.RobotMap;
import org.team3197.frc2019.robot.RobotMap.ElevatorPreset;
import org.team3197.frc2019.robot.RobotMap.MaxSpeeds;
import org.team3197.frc2019.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;

public class ElevateToPreset extends Command {

  private final ElevatorPreset target;
  private final ElevatorPreset targetWithTrigger;

  private final Trigger toggle;

  private Elevator elevator;

  private boolean finished;

  /**
   * Sets the value of the preset to the one that is intended to be moved to
   */
  public ElevateToPreset(ElevatorPreset elevatorTarget, ElevatorPreset elevatorTargetWithTrigger, Trigger toggle,
      Elevator elevator) {
    super();
    requires(elevator);
    this.target = elevatorTarget;
    this.targetWithTrigger = elevatorTargetWithTrigger;
    this.toggle = toggle;
    this.elevator = elevator;
    finished = false;
  }

  /**
   * Moves the elevator based on the number of speed, and returns the value of the
   * encoder position to the Smart Dashboard
   */
  @Override
  protected void execute() {
    double elevatorSpeed = getElevatorSpeed();

    elevator.drive(elevatorSpeed * MaxSpeeds.kElevator.forwardSpeed, true);
  }

  @Override
  protected boolean isFinished() {
    return finished;
  }

  @Override
  protected void end() {
    elevator.drive(0, true);
  }

  /**
   * Returns the speed the elevator should move at to get to the preset requested.
   * 
   * @return
   */
  private double getElevatorSpeed() {
    ElevatorPreset currentTarget = (toggle.get()) ? targetWithTrigger : target;

    double error = elevator.getEncoderPosition() - currentTarget.pos;
    finished = Math.abs(error) < RobotMap.elevatorPresetThreshold;

    double speed = -RobotMap.elevatorDegreeSensitivity * error;
    return speed;
  }
}
