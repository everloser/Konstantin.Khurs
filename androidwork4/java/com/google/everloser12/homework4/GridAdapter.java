package com.google.everloser12.homework4;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.google.everloser12.homework4.helper.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by al-ev on 05.04.2016.
 */
public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ItemViewHolder> implements ItemTouchHelperAdapter{

    private final List<Integer> mItems = new ArrayList<>();
    private OnItemClickListener mListener;
    private final OnStartDragListener mDragStartListener;



    public GridAdapter(OnStartDragListener dragStartListener, OnItemClickListener listener)
    {
        for (int i = 1; i<= 24; i++)
        {
            mItems.add(i);
        }
        mListener = listener;
        mDragStartListener = dragStartListener;


    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_icon,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {

        final String text = "dog_"+(position+1);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) mListener.onClick(text, position);
            }
        });


        String icn = "dog_"+mItems.get(position);
        int resID = holder.itemView.getContext().getResources()
                .getIdentifier(icn, "drawable", holder.itemView.getContext().getPackageName());
        holder.mImageView.setImageResource(resID);

        holder.itemView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN && mDragStartListener!=null) {
                    mDragStartListener.onStartDrag(holder);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mItems, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {

        mItems.remove(position);
        notifyItemRemoved(position);
    }


    protected static class ItemViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder
    {
        private CardView cv;
        private ImageView mImageView;

        public ItemViewHolder(View itemView)
        {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            mImageView = (ImageView) itemView.findViewById(R.id.icon_only);
        }

        @Override
        public void onItemSelected() {

            itemView.setBackgroundColor(Color.LTGRAY);
        }

        @Override
        public void onItemClear() {

            itemView.setBackgroundColor(0);
        }
    }
    interface OnItemClickListener
    {
        void onClick(String text, int position);
    }

    interface OnStartDragListener {
        void onStartDrag(RecyclerView.ViewHolder viewHolder);
    }
}