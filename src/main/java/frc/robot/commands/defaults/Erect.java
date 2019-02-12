package frc.robot.commands.defaults;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.subsystems.Erector;

public class Erect extends Command {

  private Erector erector;

  public Erect(Erector erector) {
    requires(erector);
    this.erector = erector;
  }

  @Override
  protected void execute() {
    double speed = OI.erectorSpeed();
    erector.drive(speed);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    erector.drive(0);
  }
}