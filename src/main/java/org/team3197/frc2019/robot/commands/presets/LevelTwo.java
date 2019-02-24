package org.team3197.frc2019.robot.commands.presets;

import org.team3197.frc2019.robot.RobotMap.ArmPreset;
import org.team3197.frc2019.robot.RobotMap.ElevatorPreset;
import org.team3197.frc2019.robot.commands.ArticulateToPreset;
import org.team3197.frc2019.robot.commands.ElevateToPreset;
import org.team3197.frc2019.robot.subsystems.Arm;
import org.team3197.frc2019.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class LevelTwo extends CommandGroup {

  public LevelTwo(Elevator elevator, Arm arm, Trigger toggle) {
    addParallel(new ElevateToPreset(ElevatorPreset.kHatchLevelTwo, ElevatorPreset.kCargoLevelTwo, toggle, elevator));
    addSequential(new ArticulateToPreset(ArmPreset.kHatchTwo, ArmPreset.kCargoTwo, toggle, arm));
  }
}