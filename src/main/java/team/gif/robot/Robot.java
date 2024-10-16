// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import team.gif.robot.commands.autos.Autos;
import team.gif.robot.commands.autos.Mobility;
import team.gif.robot.commands.drivetrain.ArcadeDrive;
import team.gif.robot.commands.drivetrain.TankDrive;
import team.gif.robot.commands.shooter.StupidShooter;
import team.gif.robot.subsystems.*;
import team.gif.robot.subsystems.drivers.Limelight;
import team.gif.robot.subsystems.drivers.Pigeon;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
    private Command autonomousCommand;

    private RobotContainer robotContainer;
    public static Pigeon pigeon;
    public static Limelight limelight;
    public static Shooter shooter;
    public static Indexer indexer;
    public static Pneumatics pneumatics;
    public static OI oi;
    public static UI ui;
    public static UiSmartDashboard uiSmartDashboard;
    public static DriveTrain driveTrain;
    public static Collector collector;
    public static Climber climber;
    public static boolean isReversed;

    /**
     * This function is run when the robot is first started up and should be used for any
     * initialization code.
     */
    @Override
    public void robotInit() {
        // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
        // autonomous chooser on the dashboard.
        robotContainer = new RobotContainer();
        isReversed = false;
        pigeon = new Pigeon(new TalonSRX(RobotMap.PIGEON));
        pigeon.addToShuffleboard("FRC2024", "head");
        limelight = new Limelight();
        driveTrain = new DriveTrain();
        driveTrain.setDefaultCommand(new ArcadeDrive());
//        driveTrain.setDefaultCommand(new TankDrive());
        shooter = new Shooter();
        shooter.setDefaultCommand(new StupidShooter());
        collector = new Collector();
        indexer = new Indexer();
        pneumatics = new Pneumatics();
        climber = new Climber();
        ui = new UI();
        uiSmartDashboard = new UiSmartDashboard();
        oi = new OI();
        autonomousCommand = new Mobility();

    }

    /**
     * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
     * that you want ran during disabled, autonomous, teleoperated and test.
     *
     * <p>This runs after the mode specific periodic functions, but before LiveWindow and
     * SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() {
        // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
        // commands, running already-scheduled commands, removing finished or interrupted commands,
        // and running subsystem periodic() methods.  This must be called from the robot's periodic
        // block in order for anything in the Command-based framework to work.
        CommandScheduler.getInstance().run();
    }

    /** This function is called once each time the robot enters Disabled mode. */
    @Override
    public void disabledInit() {}

    @Override
    public void disabledPeriodic() {}

    /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
    @Override
    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) {
            System.out.println("auto scheduled");
            autonomousCommand.schedule();
        }
    }

    /** This function is called periodically during autonomous. */
    @Override
    public void autonomousPeriodic() {}

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }
    }

    /** This function is called periodically during operator control. */
    @Override
    public void teleopPeriodic() {}

    @Override
    public void testInit() {
        // Cancels all running commands at the start of test mode.
        CommandScheduler.getInstance().cancelAll();
    }

    /** This function is called periodically during test mode. */
    @Override
    public void testPeriodic() {}

    /** This function is called once when the robot is first started up. */
    @Override
    public void simulationInit() {}

    /** This function is called periodically whilst in simulation. */
    @Override
    public void simulationPeriodic() {}
}
