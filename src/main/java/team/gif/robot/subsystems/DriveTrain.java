// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class DriveTrain extends SubsystemBase {
    private WPI_TalonSRX frontLeftCIM;
    private WPI_TalonSRX rearLeftCIM;
    private WPI_TalonSRX frontRightCIM;
    private WPI_TalonSRX rearRightCIM
    MotorControllerGroup leftMotors;
    MotorControllerGroup rightMotors;
    private DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);
    public DriveTrain() {
        frontLeftCIM = new WPI_TalonSRX(RobotMap.FRONT_LEFT_CIM);
        rearLeftCIM = new WPI_TalonSRX(RobotMap.REAR_LEFT_CIM);
        frontRightCIM = new WPI_TalonSRX(RobotMap.FRONT_RIGHT_CIM);
        rearRightCIM = new WPI_TalonSRX(RobotMap.REAR_RIGHT_CIM);
        frontLeftCIM.configFactoryDefault();
        rearLeftCIM.configFactoryDefault();
        frontRightCIM.configFactoryDefault();
        rearRightCIM.configFactoryDefault();
        leftMotors = new MotorControllerGroup(frontLeftCIM, rearLeftCIM);
        rightMotors = new MotorControllerGroup(frontRightCIM, rearRightCIM);
    }
    public void driveArcade(double speed, double rotation) {drive.arcadeDrive(speed, rotation);}
    public void driveTank(double leftSpeed, double rightSpeed){drive.tankDrive(leftSpeed, rightSpeed);}
}
