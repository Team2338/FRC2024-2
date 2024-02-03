package team.gif.robot;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class UiSmartDashboard {

    public UiSmartDashboard() {
        ShuffleboardTab shuffleboardTab = Shuffleboard.getTab("SmartDashboard");

//        shuffleboardTab.add("Pigeon Heading", Robot.pigeon.get360Heading());
//        shuffleboardTab.add("BotHead", (x) -> {
//                    x.setSmartDashboardType("Gyro");
//                    x.addDoubleProperty("Value", () -> Robot.pigeon.getCompassHeading(), null);
//                })
//                .withPosition(5, 0);
//

    }
}
