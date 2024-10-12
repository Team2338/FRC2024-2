package team.gif.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class Auto extends SequentialCommandGroup {

    public Auto() {
        addCommands(
                new Shoot(),
                new Mobility()
        );

    }
}
