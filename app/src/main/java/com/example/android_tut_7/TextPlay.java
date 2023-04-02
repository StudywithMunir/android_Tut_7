package com.example.android_tut_7;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;

import java.util.Random;

public class TextPlay extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button chkCmd=(Button) findViewById(R.id.b1);
         ToggleButton PassTogl=(ToggleButton) findViewById(R.id.tb1);
        //using final keyword to use variable in subClass
         EditText input=(EditText) findViewById(R.id.et);
         TextView output=(TextView) findViewById(R.id.tv);

        PassTogl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //isChecked means true

                if(PassTogl.isChecked()){

                    //if true then changing input type to text and password
                    //the below statment means if the toggle button is On
                    //whatever the user write in command first the letter turns to text for a sec
                    //then it turns to password type similarly the process goes on
                    input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

                }else {
                    //if false then changing input type to text
                    //when the toggle button is off the command is shown in the form of text
                    //not password
                    input.setInputType(InputType.TYPE_CLASS_TEXT);
                }


            }
        });

        //Button method for Try command
        chkCmd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //whatever is in the input field is stored in check variable
                String check = input.getText().toString().trim();

                //setting output text to whatever in the input field
                output.setText(check);

                if (check.contentEquals("left")){
                    output.setGravity(Gravity.LEFT);

                } else if (check.contentEquals("center")) {
                    output.setGravity(Gravity.CENTER);

                } else if (check.contentEquals("right")){
                    output.setGravity(Gravity.RIGHT);

                } else if (check.contentEquals("blue")){
                    output.setTextColor(Color.BLUE);

                } else if (check.contentEquals("WTF")) {
                    //Creating Random Variable
                    Random digit = new Random();
                    output.setText("WTF!!!");

                    //changing the text size through random variable we created it choose
                    //random digit btw 0 to 50
                    output.setTextSize(digit.nextInt(50));

                    //changing text color through random digit and using rgb (max value for rgb=265 each color)
                    output.setTextColor(Color.rgb(digit.nextInt(265),digit.nextInt(265),digit.nextInt(265)));


                    //to give 3 choices (0,1,2)
                    switch (digit.nextInt(3)){
                        case 0:
                            output.setGravity(Gravity.LEFT);
                            break;

                        case 1:
                            output.setGravity(Gravity.CENTER);
                            break;

                        case 2:
                            output.setGravity(Gravity.RIGHT);
                            break;

                    }


                } else {

                    //if user write something that not matches the above cases then it shows invalid
                    output.setText("invalid");
                    output.setGravity(Gravity.CENTER);
                    output.setTextColor(Color.BLACK);
                }
            }
        });



    }
}
