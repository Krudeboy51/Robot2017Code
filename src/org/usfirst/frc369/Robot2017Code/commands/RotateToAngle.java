package org.usfirst.frc369.Robot2017Code.commands;

import org.usfirst.frc369.Robot2017Code.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateToAngle extends Command {

	private double angleToAcquire = 0.0;
	
    public RotateToAngle(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSys);
    	angleToAcquire = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveSys.resetAngle();
    	Robot.driveSys.rotateToAngle(angleToAcquire);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveSys.didAchievedAngle();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSys.stopDrive();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
