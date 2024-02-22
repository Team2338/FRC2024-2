package team.gif.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class Shoot extends Command {
private int runs;
    public Shoot() {
        super();
        //addRequirements(Robot.climber); // uncomment
        addRequirements(Robot.shooter, Robot.indexer);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        runs = 0;
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        runs++;
        double shooterPercent = -.8;
        if(Robot.isReversed) {
            shooterPercent *= 1;
        }
        Robot.shooter.shooter(shooterPercent);
        //TODO: Sensor broke?
        if(runs>100 && Robot.indexer.getSensor()) {
            Robot.indexer.runIndexer(Constants.Indexer.INDEXER_PERCENT);

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
        Robot.shooter.shooter(0);
        Robot.indexer.stopmotor();
    }
}
