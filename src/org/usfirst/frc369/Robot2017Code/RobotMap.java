// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc369.Robot2017Code;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SerialPort;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController robotHangerleftGHMotor;
    public static SpeedController robotHangerrightGHMotor;
    
    public static SpeedController leftFrontDriveMotor;
    public static SpeedController leftRearDriveMotor;
    public static SpeedController rightFrontDriveMotor;
    public static SpeedController rightRearDriveMotor;
    
    public static DoubleSolenoid gearSwitcher;
    public static DoubleSolenoid gearHandler;
    public static DoubleSolenoid gearClaw;
    
    public static Encoder leftEncoder;
    public static Encoder rightEncoder;
    
    public static AHRS navX_Gyro;
    
    //constants
    public static double LEFT_GO_MAX = 0.87;
    public static double RIGHT_GO_MAX = 0.90;
    public static double LEFT_BACK_MAX = -0.90;
    public static double RIGHT_BACK_MAX = -0.87;
    
   // public static Solenoid
    
    public static RobotDrive driveSystem;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        robotHangerleftGHMotor = new VictorSP(4);
        LiveWindow.addActuator("RobotHanger", "leftGHMotor", (VictorSP) robotHangerleftGHMotor);
        
        robotHangerrightGHMotor = new VictorSP(5);
        LiveWindow.addActuator("RobotHanger", "rightGHMotor", (VictorSP) robotHangerrightGHMotor);
        
        leftFrontDriveMotor = new VictorSP(0);
        leftRearDriveMotor = new VictorSP(1);
        rightFrontDriveMotor = new VictorSP(2);
        rightRearDriveMotor = new VictorSP(3);
        
        LiveWindow.addActuator("DriveSystem", "leftFrontDriveMotor", (VictorSP) leftFrontDriveMotor);
        LiveWindow.addActuator("DriveSystem", "leftRearDriveMotor", (VictorSP) leftRearDriveMotor);
        LiveWindow.addActuator("DriveSystem", "rightFrontDriveMotor", (VictorSP) rightFrontDriveMotor);
        LiveWindow.addActuator("DriveSystem", "rightRearDriveMotor", (VictorSP) rightRearDriveMotor);
       
        driveSystem = new RobotDrive(leftFrontDriveMotor, leftRearDriveMotor, rightFrontDriveMotor, rightRearDriveMotor);
        driveSystem.setExpiration(0.1);
        driveSystem.setSafetyEnabled(false);

        gearSwitcher = new DoubleSolenoid(0, 1);
        
        gearHandler = new DoubleSolenoid(2, 3);
        
        gearClaw = new DoubleSolenoid(4, 5);
        
        leftEncoder = new Encoder(0,1);
        rightEncoder = new Encoder(2,3);
        
        try {
            /* Communicate w/navX-MXP via the MXP SPI Bus.                                     */
            /* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
            /* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
            navX_Gyro = new AHRS(SerialPort.Port.kUSB); 
        } catch (RuntimeException ex ) {
            DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
        }
        
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
