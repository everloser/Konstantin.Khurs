package com.google.everloser12.homework4;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class SuperMainActivity extends AppCompatActivity {

    private Button butt1, butt2, butt3, butt4;
    private ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_main);
        icon = (ImageView) findViewById(R.id.imageView);
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animRotateIn_icon = AnimationUtils.loadAnimation(SuperMainActivity.this,
                        R.anim.first_anim);
                icon.startAnimation(animRotateIn_icon);
            }
        });

        butt1 = (Button) findViewById(R.id.button);
        butt2 = (Button) findViewById(R.id.button2);
        butt3 = (Button) findViewById(R.id.button3);
        butt4 = (Button) findViewById(R.id.button4);
        butt1.setOnClickListener(listener);
        butt2.setOnClickListener(listener);
        butt3.setOnClickListener(listener);
        butt4.setOnClickListener(listener);


    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent();
            switch (v.getId())
            {
                case R.id.button:
                {
                    intent = new Intent(SuperMainActivity.this,MainActivity.class);
                    break;
                }
                case R.id.button2:
                {
                    intent = new Intent(SuperMainActivity.this,RecyclerActivity.class);
                    break;
                }
                case R.id.button3:
                {
                    intent = new Intent(SuperMainActivity.this,GridActivity.class);
                    break;
                }
                case R.id.button4:
                {
                    intent = new Intent(SuperMainActivity.this,HeaderActivity.class);
                    break;
                }
            }
            startActivity(intent);
            overridePendingTransition(R.anim.transition_first,R.anim.transition_second);
        }
    };

}
