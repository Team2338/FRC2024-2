package team.gif.robot.commands.collector;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;

public class CollectorPositionToggle extends Command {

    public CollectorPositionToggle() {
        super();
        //addRequirements(Robot.climber); // uncomment
        addRequirements(Robot.pneumatics);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        Robot.pneumatics.collectorToggle();
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}
}
