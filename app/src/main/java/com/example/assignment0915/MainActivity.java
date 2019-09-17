package com.example.assignment0915;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onCheckBoxClicked(View view){

        boolean checked = ((CheckBox) view).isChecked();


        TextView checkbox = findViewById(R.id.cTextView1);
        TextView checkbox1 = findViewById(R.id.cTextView2);


        switch(view.getId()){
            case R.id.time1:
                if(checked)
                    checkbox.setText("Hello");
                else
                    checkbox.setText("");
                    break;
            case R.id.date1:
                if(checked)
                    checkbox1.setText("Hi");
                else
                    checkbox1.setText("");
                    break;
        }

    }

    public void onRadioButtonClicked(View view ){
        // Is the button now checked ?
        boolean checked = ((RadioButton) view).isChecked();


        Log.d("ButtonTag", " Button clicked");

        RadioButton RB = (RadioButton) findViewById(R.id.RedButton);
        RadioButton BB = (RadioButton) findViewById(R.id.BlueButton);
        RadioButton GB = (RadioButton) findViewById(R.id.GreenButton);

        ConstraintLayout cl = (ConstraintLayout)findViewById(R.id.mainpage);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.RedButton:
                if (checked)
                    // Pirates are the best
                    Log.d("ButtonTag", " Red radio button is clicked");
                //  RB.setBackgroundColor(Color.parseColor("#FF9999"));
                //  BB.setBackgroundColor(Color.parseColor("#FAF9F9"));
                // GB.setBackgroundColor(Color.parseColor("#FAF9F9"));
                cl.setBackgroundColor(Color.parseColor("#FF9999"));

                break;
            case R.id.BlueButton:
                if (checked)
                    Log.d("ButtonTag", " Blue radio button is clicked");
                //     BB.setBackgroundColor(Color.parseColor("#99CCFF"));
                //     RB.setBackgroundColor(Color.parseColor("#FAF9F9"));
                //     GB.setBackgroundColor(Color.parseColor("#FAF9F9"));
                cl.setBackgroundColor(Color.parseColor("#99CCFF"));

                break;

            case R.id.GreenButton:
                if (checked) {
                    // Ninjas rule
                    Log.d("ButtonTag", " Green radio button is clicked");
                    //    GB.setBackgroundColor(Color.parseColor("#66FFB2"));
                    //   RB.setBackgroundColor(Color.parseColor("#FAF9F9"));
                    //  BB.setBackgroundColor(Color.parseColor("#FAF9F9"));
                    cl.setBackgroundColor(Color.parseColor("#66FFB2"));


                }

                //  tv.setText(" You selected Green ");

                break;
        }
    }

}
