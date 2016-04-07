package com.google.everloser12.homework4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        rv = (RecyclerView) findViewById(R.id.rv_list);

        List<String> list = new ArrayList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("dog.txt")));

            String mLine;
            while ((mLine = reader.readLine()) != null) {
                mLine = mLine.trim();
                list.add(mLine);
            }
        } catch (IOException e) {

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {

                }
            }
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        RListAdapter rListAdapter = new RListAdapter(this, list, new RListAdapter.OnItemClickListener() {
            @Override
            public void onClick(String text, int position) {
                Log.d("Moi", " text = " + text + " position = " + position);
                Main2Activity.show(RecyclerActivity.this, text);
            }
        });
        rv.setAdapter(rListAdapter);

    }
}
