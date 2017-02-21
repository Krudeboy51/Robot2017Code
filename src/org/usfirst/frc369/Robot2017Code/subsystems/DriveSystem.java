package org.usfirst.frc369.Robot2017Code.subsystems;

import org.usfirst.frc369.Robot2017Code.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
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
	private final DoubleSolenoid gearSwitcher = RobotMap.gearSwitcher;
	private double speed;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    private void Drive(double leftspeed, double rightspeed){
    	driveSystem.tankDrive(-leftspeed, -rightspeed);
    }
    
    public void normalizedSpeed(double left, double right){
    	if (left > RobotMap.LEFT_GO_MAX)
    		left = RobotMap.LEFT_GO_MAX;	
    	
    	if (left < RobotMap.LEFT_BACK_MAX)
    		left = RobotMap.LEFT_BACK_MAX;
    	
    	if (right > RobotMap.RIGHT_GO_MAX)
    		right = RobotMap.RIGHT_GO_MAX;
    	
    	if (right < RobotMap.RIGHT_BACK_MAX)
    		right = RobotMap.RIGHT_BACK_MAX;
    	
    	Drive(left, right);
    }
    
    public void Drive2(double speed, double angle){
    	driveSystem.drive(speed, angle);
    }
    
    public void shiftToHighGear(){
    	gearSwitcher.set(Value.kForward);
    }
    
    public void shiftToLowGear(){
    	gearSwitcher.set(Value.kReverse);
    }

	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		
	}
}

