package com.google.everloser12.homework4;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private static String KEY_S = "text";
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

    }
}
