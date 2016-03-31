package com.google.everloser12.homework2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView text = (TextView)findViewById(R.id.textView2);
        if (Manage.getRoot()!= null)
        {
            text.setText(Manage.getRoot().getEmployees().toString());
        }

    }
}
