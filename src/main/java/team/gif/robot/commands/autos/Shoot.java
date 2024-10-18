package team.gif.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class Shoot extends Command {

    private int count;
    private int countSensorOff;

    public Shoot() {
        super();
        addRequirements(Robot.shooter);
        //addRequirements(Robot.climber); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        count = 0;
        countSensorOff = 0;
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        Robot.shooter.setRPM(Constants.Shooter.SHOOTER_RPM);

        if (Robot.shooter.getRPM() > Constants.Shooter.SHOOTER_RPM) {
            Robot.indexer.runIndexer(Constants.Indexer.INDEXER_PERCENT_ON_SHOOT );
        }
        System.out.println(Robot.shooter.getRPM());
        count++;

        if(!Robot.indexer.getSensor()) {
            countSensorOff++;
        }


    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return countSensorOff > 25;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.shooter.shooter(0);
        Robot.indexer.runIndexer(0);
    }
}
