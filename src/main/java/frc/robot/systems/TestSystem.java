package frc.robot.systems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;

public class TestSystem extends ParadigmSystem {

    TalonSRX shooter;

    public TestSystem(XboxController controller) {
        super("Test System 1.0", controller);
    }

    @Override
    public void update() {
        double speed = controller.getY(Hand.kRight);
        log("speed=" + speed); // Sample output: <Test System 1.0> speed=1.0
        shooter.set(ControlMode.PercentOutput, speed);
    }

    @Override
    public void enable() {
        shooter = new TalonSRX(0);
        super.enable();
    }

}