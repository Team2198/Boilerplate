/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.systems.*;

/**
 * @author Ali Shariatmadari, Arianne Rull, Benhur Alula
 * FOR FRC 2020 Infinite Recharge
 */

public class Robot extends TimedRobot {

    // Selector vars                   
    /*private static final String kDefaultAuto = "Default";
    private static final String kCustomAuto = "My Auto";
    private String m_autoSelected;
    private final SendableChooser<String> m_chooser = new SendableChooser<>();*/

    private XboxController controller = new XboxController(0);
    private XboxController controller2 = new XboxController(1);
    /*private Driver drive = new Driver(controller);
    private Hatch hatch = new Hatch(controller, controller2);*/
    //private Climb climb = new Climb(controller2);
    //ParadigmSystem[] systems = {drive, hatch, /*new Ramp(controller2),*/ /*new Shooter(controller2)climb*/};

    public Robot()
    {
        CameraServer.getInstance().startAutomaticCapture();
    }

    //private Timer autoTimer;

    @Override
    public void robotInit() { // Initialize Robot
       /* for (ParadigmSystem system : systems) { // Enable systems
            system.enable();
        }*/
    }

    @Override
    public void teleopInit() {
    }

    @Override
    public void teleopPeriodic() { // Teleop UPS
        //for (ParadigmSystem system : systems) { // Update systems
           // systems[0].update();
            //systems[1].update();
        //}
    }

    @Override
    public void robotPeriodic() { // UP Every "Robot Packet" / Debug output
    }

    /**
     * This 
     * 
     * 
     * 
     * 
     * autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString line to get the auto name from the text box below the Gyro
     *
     * <p>You can add additional auto modes by adding additional comparisons to
     * the switch structure below with additional strings. If using the
     * SendableChooser make sure to add them to the chooser code above as well.
     */
    @Override
    public void autonomousInit() {
        //autoTimer = new Timer(); // Initialize autonomous timer
        //autoTimer.start(); // Start timer

        //m_autoSelected = m_chooser.getSelected();
        // autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
        //System.out.println("Auto selected: " + m_autoSelected)
        

    }

    /**
     * This function is called periodically during autonomous.
     */ 
    @Override
    public void autonomousPeriodic() {
        /*switch (m_autoSelected) {
            case kCustomAuto:
                // Put custom auto code here
                break;
            case kDefaultAuto:
            default:

                // Put default auto code here
                break;
        }*/
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
       /* for (ParadigmSystem system : systems) { // Disable systems
            system.disable();
        }*/
    }
}