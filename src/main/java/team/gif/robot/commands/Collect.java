package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;
public class Collect extends Command {

    public Collect() {
        super();
        //addRequirements(Robot.climber); // uncomment
        addRequirements(Robot.collector);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        double collectorSpeed = 1;
        Robot.collector.runCollector(collectorSpeed);
        if (Robot.isReversed) {
        collectorSpeed *= -1;
        }
        Robot.collector.runCollector(collectorSpeed);

    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.collector.runCollector(0);
    }
}
