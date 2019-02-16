package frc.robot.subsystems;

import com.revrobotics.CANDigitalInput;
import com.revrobotics.CANDigitalInput.LimitSwitchPolarity;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.RobotMap.DeadbandType;
import frc.robot.commands.defaults.Elevate;

public class Elevator extends Subsystem {
  private CANSparkMax left = new CANSparkMax(RobotMap.CANSparkMaxID.kElevatorLeft.id, MotorType.kBrushless);
  private CANSparkMax right = new CANSparkMax(RobotMap.CANSparkMaxID.kElevatorRight.id, MotorType.kBrushless);

  private CANDigitalInput bottomLimit = left.getReverseLimitSwitch(LimitSwitchPolarity.kNormallyOpen);
  private CANDigitalInput topLimit = right.getReverseLimitSwitch(LimitSwitchPolarity.kNormallyOpen);

  private LimitReset limitReset = new LimitReset();
  public ResetEncoderPosition reset = new ResetEncoderPosition(this);

  public Elevator() {
    super();
    left.follow(right, true);
    limitReset.whenActive(new ResetEncoderPosition(this));
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Elevate(this));
  }

  /*
   * Makes sure the elevator can't go any farther up when it hits the
   * upperLimitSwitch, and that it can't go any farther down when it hits the
   * lowerLimitSwitch
   */
  public void drive(double speed) {

    double output = speed;
    if (!bottomLimit.get() && Math.abs(output) < DeadbandType.kElevator.speed) {
      output = DeadbandType.kElevator.speed;
    }
    // if (topLimit.get()) {
    // output = Math.min(output, 0);
    // } // If top pressed(returning a zero value), only drive negative
    // if (bottomLimit.get()) {
    // output = Math.max(output, 0);
    // } // If bottom pressed, only drive positive
    SmartDashboard.putNumber("getElevatorEncoderPosition", getEncoderPosition());
    right.set(output);
  }

  /*
   * private void resetElevatorPosition() { // left.getEncoder().reset(); //TODO
   * not yet available } public double getEncoderPosition() { return
   * left.getEncoder().getPosition(); }
   */

  // TODO delete me when that is available
  double resetEncoderPosition = 0;

  public void resetElevatorPosition() {
    resetEncoderPosition = right.getEncoder().getPosition();
  }

  public double getEncoderPosition() {
    return right.getEncoder().getPosition() - resetEncoderPosition;
  }

  private class LimitReset extends Trigger {

    public boolean get() {
      return bottomLimit.get();
    }
  }

  public class ResetEncoderPosition extends InstantCommand {

    private Elevator elevator;

    private ResetEncoderPosition(Elevator elevator) {
      requires(elevator);
      this.elevator = elevator;
    }

    @Override
    protected void initialize() {
      elevator.resetElevatorPosition();
    }

  }

}