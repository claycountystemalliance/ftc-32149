package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Blender {
    CRServo servo;
    
    public void init(HardwareMap hardwareMap) {
        servo = hardwareMap.get(CRServo.class, "blender");
        servo.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    
    public void spin() {
        servo.setPower(1);
    }
    
    public void stop() {
        servo.setPower(0);
    }
}
