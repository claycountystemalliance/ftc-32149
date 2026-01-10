package org.firstinspires.ftc.teamcode.opmodes.teleop.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Intake;
import org.firstinspires.ftc.teamcode.hardware.driving.MecanumDrive;
import org.firstinspires.ftc.teamcode.hardware.Outake;
import org.firstinspires.ftc.teamcode.hardware.Pusher;

@TeleOp(name = "Comp: Teleop", group = "Comp")
public class Teleop extends OpMode {
    private MecanumDrive drive = new MecanumDrive();
    private Intake intake = new Intake();
    private Outake outake = new Outake();
    private Pusher pusher = new Pusher();
    
    
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
        outake.spin(gamepad2.right_trigger);
        if (gamepad2.dpad_up) {
            outake.liftBall();
        } else {
            outake.resetLifter();
        }
    }
    private void handlePusher() {
        if (gamepad2.right_bumper) {
            pusher.spin();
            
        }
        else {
            pusher.stop();
        }
    }
    
    
    
    
    @Override
    public void init() {
        drive.init(hardwareMap);
        outake.init(hardwareMap);
        intake.init(hardwareMap);
        pusher.init(hardwareMap);
    }

    @Override
    public void loop() {
        handleIntake();
        handleOutake();
        handlePusher();
        drive.Teleopdrive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
        
        
        
        
    }
}
