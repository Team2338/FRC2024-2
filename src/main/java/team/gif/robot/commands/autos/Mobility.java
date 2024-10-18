package team.gif.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;

public class Mobility extends Command {
private int timer;
    public Mobility() {
        super();
        addRequirements(Robot.driveTrain);
        //addRequirements(Robot.climber); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    timer = 0;
        System.out.println("mobility");
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        timer++;

        //runs every 20ms, so 100 will be 2 seconds
        Robot.driveTrain.driveTank(0.75, -0.75);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return timer < 90 ? false : true;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}
}
