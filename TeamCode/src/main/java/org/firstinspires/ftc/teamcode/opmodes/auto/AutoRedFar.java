package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.Intake;
import org.firstinspires.ftc.teamcode.hardware.Outake;
import org.firstinspires.ftc.teamcode.hardware.Blender;
import org.firstinspires.ftc.teamcode.hardware.driving.AutoDrive;
import org.firstinspires.ftc.teamcode.hardware.driving.enums.DriveDirection;

@Autonomous(name = "Tests: Auto Red Far", group = "Tests")
public class AutoRedFar extends LinearOpMode {
    AutoDrive drive = new AutoDrive();
    Blender blender = new Blender();
    Outake outake = new Outake();
    Intake intake = new Intake();
    
    public void launchBall(double power) {
        outake.spin(power);
        sleep(4000);
        outake.liftBall();
        sleep(2500);
        outake.resetLifter();
        ;
        
    }
    
    @Override
    public void runOpMode() throws InterruptedException {
        drive.init(hardwareMap);
        blender.init(hardwareMap);
        outake.init(hardwareMap);
        intake.init(hardwareMap);
        waitForStart();
        drive.drive(1, 1000, DriveDirection.RIGHT);
       
        
        
        
    }
}
