package org.usfirst.frc369.Robot2017Code.subsystems;

import org.usfirst.frc369.Robot2017Code.RobotMap;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSystem extends Subsystem implements PIDOutput {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private final RobotDrive driveSystem = RobotMap.driveSystem;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void Drive(double leftspeed, double rightspeed){
    	driveSystem.tankDrive(-leftspeed, -rightspeed);
    }

	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		
	}
}

