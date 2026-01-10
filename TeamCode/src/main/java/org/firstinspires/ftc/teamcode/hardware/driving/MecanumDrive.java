package org.firstinspires.ftc.teamcode.hardware.driving;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class MecanumDrive {
    
    // Declare motors
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    
    public void init(HardwareMap hardwareMap) {
        // Initialize motors
        frontLeft = hardwareMap.get(DcMotor.class, "leftfront");
        frontRight = hardwareMap.get(DcMotor.class, "rightfront");
        backLeft = hardwareMap.get(DcMotor.class, "leftrear");
        backRight = hardwareMap.get(DcMotor.class, "rightrear");
        
        // Set motor directions
        // You may need to reverse some motors depending on your robot's configuration
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.FORWARD);
        
        // Set zero power behavior
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        
    }
    
    
    public void Teleopdrive(double left_stick_y, double left_stick_x, double right_stick_x) {
        // Get joystick values
        double drive = -left_stick_y;  // Forward/backward (negative because y is inverted)
        double strafe = left_stick_x;  // Left/right strafe
        double rotate = right_stick_x; // Rotation
        
        // Calculate power for each motor
        double frontLeftPower = drive + strafe + rotate;
        double frontRightPower = drive - strafe - rotate;
        double backLeftPower = drive - strafe + rotate;
        double backRightPower = drive + strafe - rotate;
        
        // Normalize powers to keep them within -1.0 to 1.0 range
        double maxPower = Math.max(Math.abs(frontLeftPower), 
                          Math.max(Math.abs(frontRightPower),
                          Math.max(Math.abs(backLeftPower), 
                                   Math.abs(backRightPower))));
        
        if (maxPower > 1.0) {
            frontLeftPower /= maxPower;
            frontRightPower /= maxPower;
            backLeftPower /= maxPower;
            backRightPower /= maxPower;
        }
        
        // Set motor powers
        frontLeft.setPower(frontLeftPower);
        frontRight.setPower(frontRightPower);
        backLeft.setPower(backLeftPower);
        backRight.setPower(backRightPower);
        
    }
}