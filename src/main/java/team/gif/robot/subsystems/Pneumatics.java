// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.simulation.SolenoidSim;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class Pneumatics extends SubsystemBase {
    private static final Solenoid solenoid = new Solenoid (PneumaticsModuleType.REVPH,0);
    private Solenoid.Value state = Solenoid.Value.kForward;


    /** Creates a new ExampleSubsystem. */
    public Pneumatics() {}
    public void collectorDown(){
    state = Solenoid.Value;
    }

}
