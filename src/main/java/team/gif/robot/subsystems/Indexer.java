// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.Constants;
import team.gif.robot.RobotMap;

public class Indexer extends SubsystemBase {
    /** Creates a new ExampleSubsystem. */
    public TalonSRX indexerMotor;
    public Indexer() {
        indexerMotor = new TalonSRX(RobotMap.IDEXER_ID);
    }
    public void runIndexer(){
        indexerMotor.set(TalonSRXControlMode.PercentOutput, Constants.Indexer.INDEXER_PERCENT);
    }
    public void stopmotor(){
        indexerMotor.set(TalonSRXControlMode.PercentOutput, 0);}
}
