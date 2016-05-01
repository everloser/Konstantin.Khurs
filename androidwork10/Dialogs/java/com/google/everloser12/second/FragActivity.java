package com.google.everloser12.second;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import layout.FragmentOne;
import layout.FragmentTwo;


public class FragActivity extends AppCompatActivity {

   private Button btn_frag1, btn_frag2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);
        btn_frag1 = (Button) findViewById(R.id.b_frafment_first);
        btn_frag2 = (Button) findViewById(R.id.b_frafment_second);
        btn_frag1.setOnClickListener(listener);
        btn_frag2.setOnClickListener(listener);





    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment;
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            if (view == findViewById(R.id.b_frafment_first))
            {
                fragment = new FragmentOne();
                ft.replace(R.id.frag_place, fragment);
                ft.commit();

            }
            else if (view == findViewById(R.id.b_frafment_second))
            {
                fragment = new FragmentTwo();
                ft.replace(R.id.frag_place, fragment);
                ft.commit();
            }
        }
    };

//    public void changeFrag(View view)
//    {
//        Fragment fragment;
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//
//        if (view == findViewById(R.id.b_frafment_first))
//        {
//            fragment = new FragmentOne();
//            ft.replace(R.id.frag_place, fragment);
//            ft.commit();
//
//        }
//        else if (view == findViewById(R.id.b_frafment_second))
//        {
//            fragment = new FragmentTwo();
//            ft.replace(R.id.frag_place, fragment);
//            ft.commit();
//        }
//    }
}
