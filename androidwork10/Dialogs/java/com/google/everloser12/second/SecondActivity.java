package com.google.everloser12.second;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.DigitalClock;

public class SecondActivity extends AppCompatActivity {

    private AnalogClock analogClock;
    private DigitalClock digitalClock;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        onButtonClickker();
    }

    public void onButtonClickker()
    {
        analogClock = (AnalogClock)findViewById(R.id.analogClock);
        digitalClock = (DigitalClock)findViewById(R.id.textClock);
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (digitalClock.getVisibility() == DigitalClock.GONE)
                {
                    digitalClock.setVisibility(DigitalClock.VISIBLE);
                    analogClock.setVisibility(AnalogClock.GONE);
                }
                else {
                    digitalClock.setVisibility(DigitalClock.GONE);
                    analogClock.setVisibility(AnalogClock.VISIBLE);
                }
            }
        });
    }
}
