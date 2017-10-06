


package org.firstinspires.ftc.team5135;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import com.qualcomm.robotcore.hardware.DcMotor;


import com.qualcomm.robotcore.hardware.Servo;


import com.qualcomm.robotcore.util.ElapsedTime;










@TeleOp(name="Team5135DriverControlled", group="TeleOp")  // @Autonomous(...) is the other common choice


public class Trevor_Example1 extends LinearOpMode{


    DcMotor frontleft, frontright, backleft, backright;


    // Servo tilt;


    //double mPower;







    @Override


    public void runOpMode(){


        telemetry.addData("Status", "Initialized");







        frontleft = hardwareMap.dcMotor.get("fL");


        frontright = hardwareMap.dcMotor.get("fR");
        backleft = hardwareMap.dcMotor.get("bL");
        backright = hardwareMap.dcMotor.get("bR");






        //lift = hardwareMap.dcMotor.get("lift");







        backright.setDirection(DcMotor.Direction.REVERSE);
        frontright.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("fL", frontleft.getPower());


        telemetry.addData("fR", frontright.getPower());
        telemetry.addData("bR", backright.getPower());
        telemetry.addData("bL", backleft.getPower());
        //telemetry.addData("lift”, lift.getPower());


        telemetry.addData("Status", "Initialized");







        waitForStart();







        while(opModeIsActive()){


            forward(gamepad1.left_stick_y);


            turn(gamepad1.right_stick_x);
            strafeR(gamepad1.right_trigger);
            strafeL(gamepad1.left_trigger);

















/**
            if(gamepad2.a){


                lift(-0.20);


            }


            if(gamepad2.b){


                lift(0.20);


            }

**/
        }


    }







    public void forward(double power){


        frontleft.setPower(power);


        frontright.setPower(power);
        backleft.setPower(power);
        backright.setPower(power);


    }







    public void turn(double power){


        frontleft.setPower(-power);
        backleft.setPower(-power);


        frontright.setPower(power);
        backright.setPower(power);


    }






/**
    public void lift(double power){


        lift.setPower(power);


    }
 **/
    public void strafeR(double power){
        frontright.setPower(-power);
        backright.setPower(power);
        frontleft.setPower(power);
        backright.setPower(-power);
    }
    public void strafeL(double power){
        frontright.setPower(power);
        backright.setPower(-power);
        frontleft.setPower(-power);
        backright.setPower(power);
    }


}

