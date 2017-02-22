package org.usfirst.frc369.Robot2017Code.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc369.Robot2017Code.RobotMap;

/**
 *
 */
public class DoubleEncoder extends Subsystem implements PIDOutput{

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public double P = 2.0;
	public double I = 0.8;
	public double D = 0.7;
	private final Encoder leftEncoder = RobotMap.leftEncoder;
	private final Encoder rightEncoder = RobotMap.rightEncoder;
	private double speedCorrectionValue = 0.0;
	private double distanceToTravel = 0.0;
	
	
	private PIDController pidController = new PIDController(P, I, D, rightEncoder, this);
	//private PIDController pidController2 = new PIDController(P, I, D, rightEncoder, this);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void reset(){
    	leftEncoder.reset();
    	rightEncoder.reset();
    }
    
    public void setDistanceToAcquire(double dist){
    	//pidController.setSetpoint(dist);
    	distanceToTravel = dist;
    }
    
    public void startTracking(){
    	pidController.setContinuous(true);
    	pidController.enable();
    	//pidController2.enable();
    }
    
    public double getDistanceTravelled(){
    	return leftEncoder.getDistance();
    }
    
    public boolean didAcquireDistance(){
    	if (leftEncoder.getDistance() >= distanceToTravel)
    		return true;
    	
    	return false;			
    }
    
    public void getValues(){
    	SmartDashboard.putNumber("left Drvie Encoder", leftEncoder.getDistance());
    	SmartDashboard.putNumber("Right Drive Encoder", rightEncoder.getDistance());
    	SmartDashboard.putNumber("speed Correction", speedCorrectionValue);
    	SmartDashboard.putNumber("P", P);
    	SmartDashboard.putNumber("I", I);
    	SmartDashboard.putNumber("D", D);
    	//SmartDashboard.putBoolean("TargetAcquired", didAcquireDistance());
    }
    
   public double getPIDOut(){
	   return speedCorrectionValue;
   }
   
   
    
  /*  public void setDistanceToAqcuire(double dist){
    	PID = new SimPID(P, I, D, dist);
    	PID.calcPID(leftEncoder.getDistance());
    }*/


	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		speedCorrectionValue = output*-0.5;
	}
    
}

