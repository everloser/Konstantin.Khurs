package com.google.everloser12.second;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NoticeDialogListener{

    private TextView text, fishText;
    private Button butt;
    private RatingBar rBar;
    private Button butt_alert;
    private Button butt_sec;
    private Button butt_alert2;
    private Button butt_alert3;
    private Button butt_frag;
    private Button butt_time;
    private Button butt_date;
    public static final int ALERT2 = 0;
    public static final int TIMEP = 1;
    public static final int DATEP = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listenerForRatingBar();
        listenerOnButtClick();
        alert2listener();
        butt_alert3 = (Button) findViewById(R.id.button_alert3);
        fishText = (TextView) findViewById(R.id.textView4);
        butt_alert3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment ddd = new Dialogger();
                ddd.show(getFragmentManager(), "dlg2");

            }
        });
        butt_frag = (Button) findViewById(R.id.button_frag);
        butt_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FragActivity.class);
                startActivity(intent);
            }
        });
    }

    public void listenerForRatingBar()
    {
        rBar = (RatingBar)findViewById(R.id.ratingBar);
        text = (TextView)findViewById(R.id.textView);
        rBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                text.setText(String.valueOf(rating));
            }
        });
    }
    public void listenerOnButtClick()
    {
        butt = (Button)findViewById(R.id.button);
        butt_alert = (Button)findViewById(R.id.buttonAlert);
        butt_sec = (Button)findViewById(R.id.button2);
        rBar = (RatingBar)findViewById(R.id.ratingBar);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, String.valueOf(rBar.getRating()), Toast.LENGTH_SHORT).show();
            }
        });
        butt_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert_b = new AlertDialog.Builder(MainActivity.this);
                alert_b.setMessage("Quit? Are you sure???").setCancelable(false).
                        setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).
                        setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                AlertDialog alt = alert_b.create();
                alt.setTitle("Uwaha! Alert!");
                alt.show();
            }
        });
        butt_sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.google.everloser12.second.SecondActivity");
                startActivity(intent);
            }
        });

    }

    public void alert2listener()
    {
        butt_alert2 = (Button) findViewById(R.id.button_alert2);
        butt_alert2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment ddd = MyDialog.newInstance(ALERT2);
                ddd.show(getFragmentManager(), "dlg3");
            }
        });
        butt_time = (Button) findViewById(R.id.time_dial);
        butt_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment ddd = MyDialog.newInstance(TIMEP);
                ddd.show(getFragmentManager(), "dlgTime");
            }
        });

        butt_date = (Button) findViewById(R.id.date_dial);
        butt_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment ddd = MyDialog.newInstance(DATEP);
                ddd.show(getFragmentManager(), "dlgDate");
            }
        });

    }


    @Override
    public void onDialogPositiveClick(DialogFragment dialog, String stg) {
//
        fishText.setText(stg);

    }
}
