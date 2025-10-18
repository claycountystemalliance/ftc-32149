package org.firstinspires.ftc.teamcode.opmodes.teleop.tests;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp(name="Tests: Controller Test", group="Tests")
public class ControllerTest extends OpMode {
    @Override
    public void init() {
    }

    @Override
    public void loop() {
        if (gamepad1.touchpad) {
            telemetry.addLine("TouchPad used");
        }
        else if (gamepad1.ps) {
            telemetry.addLine("ps used");
        }
    }
}
