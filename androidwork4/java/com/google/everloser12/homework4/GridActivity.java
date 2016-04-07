package com.google.everloser12.homework4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.everloser12.homework4.helper.*;

public class GridActivity extends AppCompatActivity implements GridAdapter.OnStartDragListener{

    private RecyclerView rv;
    private ItemTouchHelper mItemTouchHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        rv = (RecyclerView) findViewById(R.id.rv_grid);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,14);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                DisplayMetrics displaymetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
                int wt = displaymetrics.widthPixels;
                return (14 / ((wt - 32) / 140) + 1);
            }
        });

        //rv.setLayoutManager(new GridLayoutManager(this, 3));
        GridAdapter gridAdapter = new GridAdapter(this, new GridAdapter.OnItemClickListener() {
            @Override
            public void onClick(String text, int position) {
                Log.d("Moi", " text = " + text + " position = " + position);
                Main2Activity.show(GridActivity.this, text);
            }
        });
        rv.setAdapter(gridAdapter);
        rv.setLayoutManager(gridLayoutManager);
        ItemTouchHelper.Callback callback =
                new SimpleItemTouchHelperCallback(gridAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(rv);

    }


    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        if(mItemTouchHelper != null)
            mItemTouchHelper.startDrag(viewHolder);
    }
}
