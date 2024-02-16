// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.units.Voltage;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class Climber extends SubsystemBase {
    private TalonSRX climber;
    public Climber() {
        climber = new TalonSRX(RobotMap.CLIMBER_ID);
        climber.configFactoryDefault();
        climber.setNeutralMode(NeutralMode.Brake);
    }

    public void setPercent(double speed) {
        climber.set(ControlMode.PercentOutput, speed);
    }
}
