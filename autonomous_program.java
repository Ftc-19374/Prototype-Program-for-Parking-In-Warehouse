package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "park in warehouse")
public class autonomous_program extends LinearOpMode {
    DcMotor motor;
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    
    @Override
    public void runOpMode() throws InterruptedException{
        motor = hardwareMap.dcMotor.get("motor");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");

        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
        waitForStart();
        chassis(4000,4000,4000,4000);
        chassis(2000,-2000, 2000, -2000);
        lift(3200);
        chassis(20000,20000,20000,20000);
    }
    
    
    
    public void lift(double ticks) {
        int newTarget;
        double speed2 = 1;
        if (opModeIsActive()) {
            newTarget = motor.getCurrentPosition() + (int) ticks;
            motor.setTargetPosition(newTarget);
            motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motor.setPower(Math.abs(speed2));


            motor.setPower(0);
            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            telemetry.addData("Height", motor.getCurrentPosition());
            telemetry.update();
        }
    }
    public void chassis(double fl, double fr, double bl, double br) {
        int ntfl;
        int ntfr;
        int ntbl;
        int ntbr;
        double speed2 = 1;
        if (opModeIsActive()) {
            ntfl = frontLeft.getCurrentPosition() + (int) fl;
            ntfr = frontRight.getCurrentPosition() + (int) fr;
            ntbl = backLeft.getCurrentPosition() + (int) bl;
            ntbr = backRight.getCurrentPosition() + (int) br;
            frontLeft.setTargetPosition(ntfl);
            frontRight.setTargetPosition(ntfr);
            backLeft.setTargetPosition(ntbl);
            backRight.setTargetPosition(ntbr);
            frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontLeft.setPower(Math.abs(speed2));
            frontRight.setPower(Math.abs(-speed2));
            backLeft.setPower(Math.abs(speed2));
            backRight.setPower(Math.abs(-speed2));


            frontLeft.setPower(0);
            frontRight.setPower(0);
            backLeft.setPower(0);
            backRight.setPower(0);
            frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }
}
