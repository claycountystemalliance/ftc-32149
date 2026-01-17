package org.firstinspires.ftc.teamcode.hardware;

import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Outake {
    
    DcMotor motor;
    
    Servo servo;
    
    
    public void init(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotor.class, "outake");
        motor.setDirection(DcMotorSimple.Direction.FORWARD);
        servo = hardwareMap.get(Servo.class, "lifter");
        servo.setPosition(.33);
    }
    
    public void spin(double power) {
        motor.setPower(power);
    }
    
    public void stop()
    {
        motor.setPower(0);
    }
    
    public void liftBall(){
        servo.setPosition(.7);
    }
    public void resetLifter() {
        servo.setPosition(.33);
    }
}
