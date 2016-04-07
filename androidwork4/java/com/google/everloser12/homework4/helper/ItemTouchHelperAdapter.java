package com.google.everloser12.homework4.helper;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
/**
 * Created by al-ev on 06.04.2016.
 */
public interface ItemTouchHelperAdapter {


    boolean onItemMove(int fromPosition, int toPosition);



    void onItemDismiss(int position);
}