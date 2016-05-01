package com.google.everloser12.eleven;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private EditText edit1, edit2;
    private Button button, buttonJ;
    private DbHelper dbHelper;
    private static ListView listView;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        listView =(ListView) findViewById(R.id.listView);
        button = (Button) findViewById(R.id.button);

        dbHelper = new DbHelper(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToDatabase();
            }
        });

        getFromDatabase();

        buttonJ = (Button) findViewById(R.id.button2);
        buttonJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.loadDataToSecondTable();
                String[] array = dbHelper.join();
                adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, array);

                listView.setAdapter(adapter);
            }
        });
    }

    private void saveToDatabase()
    {
        String text = edit1.getText().toString();
        int newid = 0;
        if (!text.equals(""))
            newid = (int)(Integer.valueOf(text));
        dbHelper.save(String.valueOf(edit2.getText()), newid);
    }

    private void getFromDatabase()
    {
        String[] array = dbHelper.getUser();


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);

            listView.setAdapter(adapter);


    }
}
