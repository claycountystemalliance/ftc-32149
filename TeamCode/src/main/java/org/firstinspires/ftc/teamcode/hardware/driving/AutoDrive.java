package org.firstinspires.ftc.teamcode.hardware.driving;

import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.hardware.driving.enums.DriveDirection;
import org.firstinspires.ftc.teamcode.hardware.driving.enums.RotationDirection;

public class AutoDrive {
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
    private void applyMotorPower(double flPower, double frPower, double blPower, double brPower) {
        frontLeft.setPower(flPower);
        frontRight.setPower(frPower);
        backLeft.setPower(blPower);
        backRight.setPower(brPower);
    }
    
    public void drive(double power, long time, DriveDirection driveDirection) throws InterruptedException {
            switch (driveDirection) {
                case FOWARD:
                    applyMotorPower(power, power, power, power);
                    sleep(time);
                    applyMotorPower(0, 0, 0, 0);
                    break;
                case BACKWARD:
                    applyMotorPower(-power, -power, -power, -power);
                    sleep(time);
                    applyMotorPower(0, 0, 0, 0);
                case LEFT:
                    applyMotorPower(-power, power, power, -power);
                    sleep(time);
                    applyMotorPower(0, 0, 0, 0);
                case RIGHT:
                    applyMotorPower(power, -power, -power, power);
                    sleep(time);
                    applyMotorPower(0, 0, 0, 0);
                case FRONT_LEFT:
                    applyMotorPower(0, power, power, 0);
                    sleep(time);
                    applyMotorPower(0, 0, 0, 0);
                case FRONT_RIGHT:
                    applyMotorPower(power, 0, 0, power);
                    sleep(time);
                    applyMotorPower(0, 0, 0, 0);
                case BACK_LEFT:
                    applyMotorPower(-power, 0, 0, -power);
                    sleep(time);
                    applyMotorPower(0, 0, 0, 0);
                case BACK_RIGHT:
                    applyMotorPower(0, -power, -power, 0);
                    sleep(time);
                    applyMotorPower(0, 0, 0, 0);
            }
    }
    
    public void rotate(double power, long time, RotationDirection rotationDirection) throws InterruptedException {
        switch (rotationDirection) {
            case LEFT:
                applyMotorPower(-power, power, -power, power);
                sleep(time);
                applyMotorPower(0, 0, 0, 0);
            case RIGHT:
                applyMotorPower(power, -power, power, -power);
                sleep(time);
                applyMotorPower(0, 0, 0, 0);
        }
    }
}
