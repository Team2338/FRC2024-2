// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.Constants;
import team.gif.robot.RobotMap;

public class Indexer extends SubsystemBase {
    /** Creates a new ExampleSubsystem. */
    public TalonSRX indexerMotor;
    public DigitalInput indexerSensor;
    public Indexer() {
        indexerMotor = new TalonSRX(RobotMap.INDEXER_ID);
        indexerMotor.configFactoryDefault();
        indexerMotor.setNeutralMode(NeutralMode.Brake);
        indexerSensor = new DigitalInput(0);
    }
    public void runIndexer(double speed){
        indexerMotor.set(TalonSRXControlMode.PercentOutput, speed);
    }
    public void stopmotor(){
        indexerMotor.set(TalonSRXControlMode.PercentOutput, 0);}

    public boolean getSensor() {
        return !indexerSensor.get();
    }
}
