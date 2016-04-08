package com.google.everloser12.homework4;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ClipDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private static String KEY_S = "text";
    ImageView imageView, imageView2;


    public static void show(Activity activity, String text)
    {
        Intent intent = new Intent(activity,Main2Activity.class);
        intent.putExtra(KEY_S,text);
        activity.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView = (TextView)findViewById(R.id.textView);
        Intent intent = getIntent();
        String text = intent.getStringExtra(KEY_S);
        textView.setText(text);
        imageView = (ImageView) findViewById(R.id.imageViewClip);
        imageView2 = (ImageView) findViewById(R.id.imageViewAnimated);
        final ClipDrawable clipDrawable = (ClipDrawable) imageView.getDrawable();
        clipDrawable.setLevel(200);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i<=50; i++)
                {
                  final int k = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            clipDrawable.setLevel(k * 200);
                        }
                    });

                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        imageView.setOnClickListener(listener);
        imageView2.setOnClickListener(listener);


    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (imageView.getVisibility() == imageView.GONE)
            {
                imageView.setVisibility(imageView.VISIBLE);
                imageView2.setVisibility(imageView2.GONE);
            }
            else {
                imageView.setVisibility(imageView.GONE);
                imageView2.setVisibility(imageView2.VISIBLE);
            }
        }
    };
}
