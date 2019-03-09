package org.team3197.frc2019.robot;

public class RobotMap {

  public static enum CANSparkMaxID {
    kFrontLeft(14, "FrontLeft"), kBackLeft(15, "BackLeft"), kFrontRight(1, "FrontRight"), kBackRight(16, "BackRight"),
    kElevatorLeft(2, "ElevatorLeft"), kElevatorRight(13, "ElevatorRight"), kWrist(12, "Wrist"), kElbow(3, "Elbow"),
    kCargoManipulator(11, "CargoManipulator"), kHatch(10, "Hatch"), kErectorLeft(5, "ErectorLeft"),
    kErectorRight(4, "ErectorRight"), kLiftVertical(17, "LiftVertical"), kLiftHorizontal(18, "LiftHorizontal");

    public final int id;
    public final String name;

    private CANSparkMaxID(int id, String name) {
      this.id = id;
      this.name = name;
    }
  };

  public static enum ElbowPreset {
    kHatchOne(77), kHatchTwo(196), kHatchThree(196), kCargoOne(196), kCargoTwo(196), kCargoThree(196), kCargoShip(196);
    public double elbowPos;

    private ElbowPreset(double elbowPos) {
      this.elbowPos = elbowPos;
    }
  }

  public static enum ElevatorPreset {
    kHatchLevelOne(-27), kHatchLevelTwo(-12.5), kHatchLevelThree(28), kCargoLevelOne(20), kCargoLevelTwo(20),
    kCargoLevelThree(53), kCargoLoadingLevel(7.85), kCargoShipCargo(25);
    public double pos;

    private ElevatorPreset(double pos) {
      this.pos = pos;
    }
  }

  public static enum DeadbandType {
    kElevator(0.03), kElbow(0.06), kWrist(0.06), kDrive(0.08);
    public double speed;

    private DeadbandType(double speed) {
      this.speed = speed;
    }
  }

  public static enum DriveTrainSide {
    LEFT, RIGHT, BOTH;
  }

  public static enum CANSparkPID {
    P(0), I(0), D(0), F(0);

    public final double val;

    private CANSparkPID(double val) {
      this.val = val;
    }
  };

  public static enum ElevatorPID {
    P(0), I(0), D(0), F(0);

    public final double val;

    private ElevatorPID(double val) {
      this.val = val;
    }
  };

  public static enum Channel {
    kDriveGyro(0), kWristGyro(1);
    public final int channel;

    private Channel(int channel) {
      this.channel = channel;
    }
  };

  public static enum GyroSensitivity {
    kDrive(0.01), kArm(0.0175);
    public double val;

    private GyroSensitivity(double val) {
      this.val = val;
    }
  };

  public static enum MaxSpeeds {
    kElevator(.7, -.5), kArm(.6), kWrist(.45), kHatch(1), kCargo(1), kClimberVertical(.5), kClimberHorizontal(.5);

    public double forwardSpeed;
    public double reverseSpeed;

    private MaxSpeeds(double forwardSpeed, double reverseSpeed) {
      this.forwardSpeed = forwardSpeed;
      this.reverseSpeed = reverseSpeed;
    }

    private MaxSpeeds(double speed) {
      this.forwardSpeed = speed;
      this.reverseSpeed = -speed;
    }
  }

  // TODO this is bad
  public static final RobotType current = RobotType.B;

  public static enum RobotType {
    A, B;
  }

  public static final double elevatorPresetThreshold = 1.5;

  public static final double wristPresetThreshold = .5;

  public static final double elbowPresetThreshold = 1.5;

  public static final double elevatorDegreeSensitivity = 0.15;

  public static final double wristDegreeSensitivity = 0.15;

  public static final double elbowDegreeSensitivity = 0.15;

  public static final double elevatorExponent = 0.5;

  public static final double wristExponent = 0.5;

  public static final double elbowExponent = 0.5;

  public static final double elevatorSpeedMultiplier = 0.5;

  public static final double elbowSpeedMultiplier = 0.5;

  public static final double wristSpeedMultiplier = 0.5;

  public static final int gyroChannel = 0;

  public static final double xMax = 640;

  public static final double visionTargetX = .5;

  public static final double visionTargetArea = 32000;
}
