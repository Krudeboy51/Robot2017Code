package org.usfirst.frc369.Robot2017Code.subsystems;

import org.usfirst.frc369.Robot2017Code.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveSystem extends Subsystem implements PIDOutput {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private final RobotDrive driveSystem = RobotMap.driveSystem;
	private final DoubleSolenoid gearSwitcher = RobotMap.gearSwitcher;
	private final AHRS navX_Gyro = RobotMap.navX_Gyro;
	
	private PIDController turnController;
	
	static final double kP = 0.03;
	static final double kI = 0.00;
	static final double kD = 0.00;
	static final double kF = 0.00;
	
	static final double kToleranceDegrees = 2.0;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	turnController = new PIDController(kP, kI, kD, kF, navX_Gyro, this);
        turnController.setInputRange(-180.0f,  180.0f);
        turnController.setOutputRange(-1.0, 1.0);
        turnController.setAbsoluteTolerance(kToleranceDegrees);
        turnController.setContinuous(true);
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
    
    public void resetAngle(){
    	navX_Gyro.reset();
    }
    
    public void driveStraight(double speed){
        try {
            SmartDashboard.putNumber("Gyro Angle", navX_Gyro.getAngle());
            driveSystem.drive(0.5, -navX_Gyro.getAngle()*0.005);
        } catch( RuntimeException ex ) {
            DriverStation.reportError("Error communicating with drive system:  " + ex.getMessage(), true);
        }
    }
    
    public void rotateToAngle(double angle){
    	turnController.setSetpoint(angle);
    	turnController.enable();
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

