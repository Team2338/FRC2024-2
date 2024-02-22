package team.gif.robot.commands.indexer;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class IndexNote extends Command {

    public IndexNote() {
        super();
    addRequirements(Robot.indexer);
        //addRequirements(Robot.climber); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {



        double indexerModifier = 1;
        if (Robot.isReversed){
            indexerModifier *= -1;
        }


        Robot.indexer.runIndexer(Constants.Indexer.INDEXER_PERCENT * indexerModifier);

        if(Robot.indexer.getSensor()) {
            Robot.indexer.stopmotor();
        }
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.indexer.stopmotor();
    }
}
