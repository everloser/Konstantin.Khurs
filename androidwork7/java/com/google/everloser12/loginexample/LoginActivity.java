package com.google.everloser12.loginexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.everloser12.loginexample.rest.LoginCallBack;
import com.google.everloser12.loginexample.rest.ServiceBroker;
import com.google.everloser12.loginexample.rest.models.LoginRequest;

public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private Button login_btn, reg_btn;
    private TextView attemptstext;
    private TextView attempts;
    private TextView counter;
    int att_counter = 3;
    private ProgressBar pb2;
    static final String ACTION_MY = "com.google.everloser12.loginexample.LoginActivity.ACTION_MY";
    static final String COUNTER = "count";
    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.edittext_user);
        password = (EditText) findViewById(R.id.edittext_pass);
        login_btn = (Button) findViewById(R.id.login_button);
        attemptstext = (TextView) findViewById(R.id.attempts_text);
        attempts = (TextView) findViewById(R.id.attempts);
        counter = (TextView) findViewById(R.id.counter);
        pb2 = (ProgressBar) findViewById(R.id.pBar_login);
        reg_btn = (Button) findViewById(R.id.register_button);
        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });
        buttonLoginer();

    }

    public void buttonLoginer()
    {



        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                pb2.setVisibility(pb2.VISIBLE);
                LoginRequest loginRequest = new LoginRequest(username.getText().toString(),
                        password.getText().toString());
                ServiceBroker.getInstance().login(loginRequest, new LoginCallBack() {
                    @Override
                    public void response(boolean isError) {



                        pb2.setVisibility(pb2.GONE);
                        if (!isError) {
                            if (att_counter != 3)
                            {
                                att_counter = 3;
                                attemptstext.setVisibility(attemptstext.INVISIBLE);
                                attempts.setText("");
                            }
                            username.setText("");
                            password.setText("");
                            Intent intent = new Intent(LoginActivity.this, ConnectedActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "Login or Password is incorrect",
                                    Toast.LENGTH_SHORT).show();
                            attemptstext.setVisibility(attemptstext.VISIBLE);
                            att_counter--;
                            attempts.setText(String.valueOf(att_counter));
                            if (att_counter == 0)
                            {
                                login_btn.setEnabled(false);

                                Intent serv = new Intent(LoginActivity.this, MyService.class);
                                startService(serv);

                            }
                        }
                    }
                });

            }
        });

    }



    @Override
    protected void onStart() {
        super.onStart();
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                login_btn.setEnabled(false);
                int cc = intent.getIntExtra(COUNTER, 0);
                String rec = "wait for "+ cc + " sec";
                counter.setText(rec);
                if (cc == 0)
                {
                    login_btn.setEnabled(true);
                    att_counter = 3;
                    attemptstext.setVisibility(attemptstext.INVISIBLE);
                    counter.setText("");
                    attempts.setText("");

                }

            }
        };
        IntentFilter intFilt = new IntentFilter(ACTION_MY);
        registerReceiver(broadcastReceiver, intFilt);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }

    @Override
        protected void onDestroy() {
        super.onDestroy();

    }
}
