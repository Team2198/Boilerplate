/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.systems.*;
import frc.robot.systems.Drive.Driver;

/** Robot Boilerplate Code
 * @author Ali Shariatmadari, FOR FRC 2198
 */

public class Robot extends TimedRobot {

     /**
      * Selector Variables
      * private static final String kDefaultAuto = "Default";
      * private static final String kCustomAuto = "My Auto";
      * private String m_autoSelected;
      * private final SendableChooser<String> m_chooser = new SendableChooser<>();
      */
      
    private XboxController controller = new XboxController(0);
    private XboxController controller2 = new XboxController(1);
    private Driver drive = new Driver(controller);
    private Hatch hatch = new Hatch(controller, controller2);
    ParadigmSystem[] systems = {drive, hatch, new Shooter(controller2), new TestSystem(controller)};

    public Robot() {
        
        // Initialize Camera
        //CameraServer.getInstance().startAutomaticCapture();
    }

    @Override
    public void robotInit() { // Initialize Robot
        systems[0].enable();
        systems[1].enable();
        systems[2].enable();
        systems[3].enable();
    }

    @Override
    public void teleopInit() {
    }

    @Override
    public void teleopPeriodic() { // Teleop UPS
        systems[0].update();
        systems[1].update();
        systems[2].update();
        systems[3].update();
    }

    @Override
    public void robotPeriodic() { // UP Every "Robot Packet" / Debug output
    }

    // private Timer autoTimer;
    @Override
    public void autonomousInit() {
        // autoTimer = new Timer(); // Initialize autonomous timer
        // autoTimer.start(); // Start timer

        // m_autoSelected = m_chooser.getSelected();
        // autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
        // System.out.println("Auto selected: " + m_autoSelected)
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
        /*
         * switch (m_autoSelected) { case kCustomAuto: // Put custom auto code here
         * break; case kDefaultAuto: default:
         * 
         * // Put default auto code here break; }
         */
        teleopPeriodic();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
    }

    @Override
    public void disabledInit() { // Shutdown
        systems[0].disable();
        systems[1].disable();
        systems[2].disable();
        systems[3].disable();
    }
}