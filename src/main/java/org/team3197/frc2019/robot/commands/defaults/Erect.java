package org.team3197.frc2019.robot.commands.defaults;

import edu.wpi.first.wpilibj.command.Command;
import org.team3197.frc2019.robot.OI;
import org.team3197.frc2019.robot.subsystems.Erector;

public class Erect extends Command {

  private Erector erector;

  public Erect(Erector erector) {
    requires(erector);
    this.erector = erector;
  }

  /**
   * Takes the speed from OI that the climber knives should drive at, and moves
   * them.
   */
  @Override
  protected void execute() {
    double speed = OI.erectorSpeed();
    erector.drive(speed, true);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    erector.drive(0, true);
  }
}
