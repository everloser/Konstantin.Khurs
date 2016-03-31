package com.google.everloser12.homework2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button xmlButt, jsonButt;
    private ProgressDialog dialog;
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenersToBtn();
    }

    public void addListenersToBtn()
    {
        xmlButt = (Button)findViewById(R.id.button);
        jsonButt = (Button)findViewById(R.id.button2);
        xmlButt.setOnClickListener(listener);
        jsonButt.setOnClickListener(listener);

    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setTitle("Downloading");
            dialog.setMessage("PLZ, wait for downloading and parsing");
            dialog.setCancelable(false);
            dialog.show();
            final View w = v;
            thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    switch (w.getId())
                    {
                        case R.id.button:
                            Manage.parseXML();
                            Log.d("MoiMoi", "otparsili");
                            //dialog.dismiss();
                            break;
                        case R.id.button2:
                            Manage.parseJSONSimpl();
                            //dialog.dismiss();
                            break;

                    }

//                    try {
//                        Thread.sleep(5000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    //
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            dialog.dismiss();
                        }
                    });
                    Intent intent = new Intent("com.google.everloser12.homework2.SecondActivity");
                    startActivity(intent);

                }
            });
            thread.start();
        }
    };
}
