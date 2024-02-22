package team.gif.robot.commands.collector;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;
public class Collect extends Command {

    public Collect() {
        super();
        //addRequirements(Robot.climber); // uncomment
        addRequirements(Robot.collector, Robot.indexer);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        double collectorSpeed = -1;
        double indexModifier = 1;
        if (Robot.isReversed) {
        collectorSpeed *= -1;
        indexModifier *= -1;
        }
        if (Robot.indexer.getSensor()) {
            indexModifier *= 0;
        }
        Robot.collector.runCollector(collectorSpeed);
        Robot.indexer.runIndexer(indexModifier * Constants.Indexer.INDEXER_PERCENT);

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
        Robot.indexer.runIndexer(0);
    }
}
