// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class Pneumatics extends SubsystemBase {
    private static final DoubleSolenoid solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotMap.SOLENOID_IN_ID, RobotMap.SOLENOID_OUT_ID);
    private DoubleSolenoid.Value state = DoubleSolenoid.Value.kForward;


    public Pneumatics() {}
    public void collectorToggle() {
        if (state == DoubleSolenoid.Value.kForward) {
            state = DoubleSolenoid.Value.kReverse;
        } else {
            state = DoubleSolenoid.Value.kForward;
        }
    }

}
