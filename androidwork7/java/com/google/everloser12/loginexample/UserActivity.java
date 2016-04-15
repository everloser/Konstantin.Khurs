package com.google.everloser12.loginexample;

import android.content.Context;
import android.content.Intent;
//import android.support.v4.view.GestureDetectorCompat;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
//import static android.view.GestureDetector.*;

//import android.view.MotionEvent;
import android.widget.Toast;

import com.google.everloser12.loginexample.rest.LoginCallBack;
import com.google.everloser12.loginexample.rest.ServiceBroker;
import com.google.everloser12.loginexample.rest.models.LoginRequest;
import com.google.everloser12.loginexample.rest.models.RegisterRequest;

public class UserActivity extends AppCompatActivity //implements OnGestureListener, OnDoubleTapListener
{

    //private TextView mWellcomeText;
    private EditText name, email, pass;
    private Button mButton;
    private ProgressBar progBar;
    //private GestureDetectorCompat gestureDetectorCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        mButton = (Button) findViewById(R.id.user_button);
        name = (EditText) findViewById(R.id.reg_edit_name);
        email = (EditText) findViewById(R.id.reg_edit_email);
        pass = (EditText) findViewById(R.id.reg_edit_pass);
        //mWellcomeText = (TextView) findViewById(R.id.welcome_text);
        progBar = (ProgressBar) findViewById(R.id.progressBar);


        //gestureDetectorCompat = new GestureDetectorCompat(this, this);
        //gestureDetectorCompat.setOnDoubleTapListener(this);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mButton.setVisibility(mButton.GONE);
                progBar.setVisibility(progBar.VISIBLE);
                RegisterRequest registerRequest = new RegisterRequest(email.getText().toString(),
                        pass.getText().toString(), name.getText().toString());
                ServiceBroker.getInstance().register(registerRequest, new LoginCallBack() {
                    @Override
                    public void response(boolean isError) {


                        if (!isError) {
                            Toast.makeText(UserActivity.this, "Registration is successful, wait for login",
                                    Toast.LENGTH_SHORT).show();
                            LoginRequest loginRequest = new LoginRequest(email.getText().toString(),
                                    pass.getText().toString());
                            email.setText("");
                            pass.setText("");
                            name.setText("");

                            ServiceBroker.getInstance().login(loginRequest, new LoginCallBack() {


                                @Override
                                public void response(boolean isError) {

                                    mButton.setVisibility(mButton.VISIBLE);
                                    progBar.setVisibility(progBar.GONE);
                                    if (!isError) {

                                        Intent intent = new Intent(UserActivity.this, ConnectedActivity.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(UserActivity.this, "Login or Password is incorrect",
                                                Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });



                        } else {
                            Toast.makeText(UserActivity.this, "Data is incorrect",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }


//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        gestureDetectorCompat.onTouchEvent(event);
//        return super.onTouchEvent(event);
//    }
//
//    @Override
//    public boolean onSingleTapConfirmed(MotionEvent e) {
//        //mTextView.setText("onSingleTapConfirmed" + e.toString());
//        return false;
//    }

//    @Override
//    public boolean onDoubleTap(MotionEvent e) {
//       // mWellcomeText.setText("onDoubleTap");
//        return false;
//    }
//
//    @Override
//    public boolean onDoubleTapEvent(MotionEvent e) {
//        //mWellcomeText.setText("onDoubleTapEvent");
//        return false;
//    }

//    @Override
//    public boolean onDown(MotionEvent e) {
//        //mWellcomeText.setText("onDown");
//        return false;
//    }
//
//    @Override
//    public void onShowPress(MotionEvent e) {
//
//        //mTextView.setText("onShowPress" + e.toString());
//    }

//    @Override
//    public boolean onSingleTapUp(MotionEvent e) {
//        //mTextView.setText("onSingleTapUp" + e.toString());
//        return false;
//    }
//
//    @Override
//    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//        //mWellcomeText.setText("onScroll");
//        return false;
//    }

//    @Override
//    public void onLongPress(MotionEvent e) {
//
//       // mWellcomeText.setText("onLongPress");
//    }
//
//    @Override
//    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//        //mTextView.setText("onDoubleTap" + e1.toString() + e2.toString());
//        return false;
//    }
}
