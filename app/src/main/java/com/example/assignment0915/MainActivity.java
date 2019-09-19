package com.example.assignment0915;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView image = (ImageView) findViewById(R.id.image);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.seasons, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String season1 = adapterView.getItemAtPosition(i).toString();
                if(season1.equals("Spring"))
                    image.setImageResource(R.drawable.spring);
                if(season1.equals("Summer"))
                    image.setImageResource(R.drawable.summer);
                if(season1.equals("Autumn"))
                    image.setImageResource(R.drawable.autumn);
                if(season1.equals("Winter"))
                    image.setImageResource(R.drawable.winter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                image.setImageResource(R.drawable.winter);
            }
        });

        ImageButton myImageButton;

        myImageButton = (ImageButton) findViewById(R.id.imageButton);

        myImageButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intentLoadNewActivity = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
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

    public void onSwitchClick(View view){
        boolean checked = ((Switch) view).isChecked();

        GradientDrawable gd = new GradientDrawable();
        gd.setColor(0xFF00FF00); // Changes this drawbale to use a single color instead of a gradient
        gd.setCornerRadius(5);
        gd.setStroke(1, 0xFF000000);
        TextView tv = (TextView)findViewById(R.id.date1);

       if(checked)
           tv.setBackground(gd);
        else
            tv.setBackgroundColor(Color.TRANSPARENT);
    }



}
