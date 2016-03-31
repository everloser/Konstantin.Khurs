package com.google.everloser12.classwork1;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by al-ev on 25.03.2016.
 */
public class MainActivity extends Activity
{
    private TextView text1, text2;
    private Button butt;
    private CheckBox check1, check2;
    private RadioButton radB1, radB2;
    private View.OnClickListener check = new View.OnClickListener() {
        @Override
        public void onClick(View w) {
            String str = "";
            check1 = (CheckBox)findViewById(R.id.checkBoxB);
            check2 = (CheckBox)findViewById(R.id.checkBoxI);
            text1 = (TextView) findViewById(R.id.textView);
            text2 = (TextView) findViewById(R.id.textView2);
            if (((CheckBox)w).isChecked())
            {
                str = ((CheckBox)w).getText().toString() + " Checked";

            }
            else
            {
                str = ((CheckBox)w).getText().toString() + " Unchecked";
            }

            Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            if (check1.isChecked() && check2.isChecked())
            {
                text1.setTypeface(null, Typeface.BOLD_ITALIC);
                text2.setTypeface(null, Typeface.BOLD_ITALIC);
            }
            else if (check1.isChecked() && !check2.isChecked())
            {
                text1.setTypeface(null, Typeface.BOLD);
                text2.setTypeface(null, Typeface.BOLD);
            }
            else if (!check1.isChecked() && check2.isChecked())
            {
                text1.setTypeface(null, Typeface.ITALIC);
                text2.setTypeface(null, Typeface.ITALIC);
            }
            else
            {
                text1.setTypeface(null, Typeface.NORMAL);
                text2.setTypeface(null, Typeface.NORMAL);
            }
        }
    };
    private View.OnClickListener rad = new View.OnClickListener() {
        @Override
        public void onClick(View w) {
            text1 = (TextView) findViewById(R.id.textView);
            text2 = (TextView) findViewById(R.id.textView2);
            Toast.makeText(MainActivity.this, ((RadioButton) w).getText() + " Checked", Toast.LENGTH_SHORT).show();
            if (((RadioButton) w).getId() == R.id.radioButton20) {
                text1.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                text2.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
            }
            if (((RadioButton) w).getId() == R.id.radioButton15) {
                text1.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
                text2.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerToButt();
        check1 = (CheckBox)findViewById(R.id.checkBoxB);
        check2 = (CheckBox)findViewById(R.id.checkBoxI);
        check1.setOnClickListener(check);
        check2.setOnClickListener(check);
        radB1 = (RadioButton)findViewById(R.id.radioButton15);
        radB2 = (RadioButton)findViewById(R.id.radioButton20);
        radB1.setOnClickListener(rad);
        radB2.setOnClickListener(rad);
        Log.d("MainActivity", "onCreate");
    }

    public void addListenerToButt()
    {
        butt = (Button)findViewById(R.id.button);
        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = text1.getText().toString();
                text1.setText(text2.getText().toString());
                text2.setText(temp);
                Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume");
    }
}
