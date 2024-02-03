// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class Indexer extends SubsystemBase {
    /** Creates a new ExampleSubsystem. */
    public CANSparkMax spark = new CANSparkMax(RobotMap.SPARK_MAX_ID, CANSparkLowLevel.MotorType.kBrushless);
    public Indexer() {}
    public void runIndexer(){
        spark.set(0.3);
    }
    public void stopmotor(){spark.setVoltage(0);}
}
