// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class Indexer extends SubsystemBase {
    /** Creates a new ExampleSubsystem. */
    public CANSparkFlex spark = new CANSparkFlex(RobotMap.SPARK_FLEX_ID, CANSparkLowLevel.MotorType.kBrushless);
    public Indexer() {}
    public void runIndexer(){
        spark.set(0.1);
    }
    public void stopmotor(){spark.setVoltage(0);}
}
