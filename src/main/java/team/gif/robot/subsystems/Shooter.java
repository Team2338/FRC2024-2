// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.*;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.Constants;
import team.gif.robot.RobotMap;

public class Shooter extends SubsystemBase {
    /** Creates a new ExampleSubsystem. */
    private static CANSparkFlex shooter;
    private static SparkPIDController shooterPid;
    public Shooter() {
        shooter = new CANSparkFlex(RobotMap.SHOOTER_ID, CANSparkLowLevel.MotorType.kBrushless);
        shooter.restoreFactoryDefaults();
        shooter.setInverted(true);
        shooter.setIdleMode(CANSparkBase.IdleMode.kCoast);
        shooterPid = shooter.getPIDController();
        shooterPid.setP(0.00035);
        shooterPid.setI(0.0000006);
    }
    public void setRPM (double rpm) {shooterPid.setReference(rpm, CANSparkBase.ControlType.kVelocity); }
    public void shooter (double speed){
        shooter.set(speed);
    }

    public double getRPM() {
        return shooter.getEncoder().getVelocity();
    }

}
