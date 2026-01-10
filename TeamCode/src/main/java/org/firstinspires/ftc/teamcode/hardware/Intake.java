package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    DcMotor motor;
    
    public void init(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotor.class, "intake");
        motor.setDirection(DcMotorSimple.Direction.FORWARD);
    }
    public void in() {
        motor.setPower(1);
    }
    public void out() {
        motor.setPower(-1);
    }
    public void stop() {
        motor.setPower(0);
    }
}
