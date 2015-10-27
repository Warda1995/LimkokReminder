package com.warda.anam.limkokreminder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button b = (Button)findViewById(R.id.test);
        b.setOnClickListener(this);

        Button b1 = (Button)findViewById(R.id.timetable);
        b1.setOnClickListener(this);

        Button b2 = (Button)findViewById(R.id.homework);
        b2.setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.test:
                Intent myIntent = new Intent(MainActivity.this, Test.class);
                startActivity(myIntent);
                break;
            case R.id.timetable:
                Intent myIntent1 = new Intent(MainActivity.this, timetable.class);
                startActivity(myIntent1);
                break;
            case R.id.homework:
                Intent myIntent2 = new Intent(MainActivity.this, homework.class);
                startActivity(myIntent2);
                break;

        }


    }


}
