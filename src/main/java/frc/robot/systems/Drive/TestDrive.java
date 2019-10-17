package frc.robot.systems.Drive;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.systems.ParadigmSystem;

public class TestDrive extends ParadigmSystem {

    private final double TURN_SENSE = 0.55;

    BandAidDrive drive;

    public TestDrive(XboxController controller) {
        super("Test Drive 1.0", controller);
    }

    @Override
    public void update() {
        double speed = controller.getY(Hand.kRight);
        double curve = controller.getX(Hand.kLeft);

        if (speed > Math.abs(0.1)){
            drive.curvatureDriveRamped(speed, curve);
        } else {
            drive.tankDrive(curve * TURN_SENSE, -curve * TURN_SENSE);
        }
    }

    @Override
    public void enable() {
        VictorSP top_right = new VictorSP(DriveConstants.TOP_RIGHT);
        VictorSP top_left = new VictorSP(DriveConstants.TOP_LEFT);
        VictorSP bottom_right = new VictorSP(DriveConstants.BOTTOM_RIGHT);
        VictorSP bottom_left = new VictorSP(DriveConstants.BOTTOM_LEFT);
        SpeedControllerGroup leftSide = new SpeedControllerGroup(top_left, bottom_left);
        SpeedControllerGroup rightSide = new SpeedControllerGroup(top_right, bottom_right);
        // Instantiate Drive
        drive = new BandAidDrive(leftSide, rightSide);
        super.enable();
    }
}