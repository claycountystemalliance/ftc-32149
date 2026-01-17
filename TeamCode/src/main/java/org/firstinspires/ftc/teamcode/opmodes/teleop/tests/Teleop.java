package org.firstinspires.ftc.teamcode.opmodes.teleop.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Intake;
import org.firstinspires.ftc.teamcode.hardware.driving.MecanumDrive;
import org.firstinspires.ftc.teamcode.hardware.Outake;
import org.firstinspires.ftc.teamcode.hardware.Blender;

@TeleOp(name = "Comp: Teleop", group = "Comp")
public class Teleop extends OpMode {
    private MecanumDrive drive = new MecanumDrive();
    private Intake intake = new Intake();
    private Outake outake = new Outake();
    private Blender blender = new Blender();
    
    
    private void handleIntake(){
        if (gamepad2.dpad_right) {
            intake.in();
        } else if (gamepad2.dpad_left) {
            intake.out();
        }
        else {
            intake.stop();
        }
    }
    
    private void handleOutake(){
        if (gamepad2.right_trigger > 0) {
            outake.spin(0.76);
        }
        else {
            outake.stop();
        }
        if (gamepad2.dpad_up) {
            outake.liftBall();
        } else {
            outake.resetLifter();
        }
    }
    private void handlePusher() {
        if (gamepad2.right_bumper) {
            blender.spin();
            
        }
        else {
            blender.stop();
        }
    }
    
    
    
    
    @Override
    public void init() {
        drive.init(hardwareMap);
        outake.init(hardwareMap);
        intake.init(hardwareMap);
        blender.init(hardwareMap);
    }

    @Override
    public void loop() {
        handleIntake();
        handleOutake();
        handlePusher();
        drive.Teleopdrive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
        
        
        
        
    }
}
