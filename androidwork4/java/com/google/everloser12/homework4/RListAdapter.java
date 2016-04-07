package com.google.everloser12.homework4;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by al-ev on 05.04.2016.
 */
public class RListAdapter extends RecyclerView.Adapter<RListAdapter.Holder> {

    private List<String> mList;
    private OnItemClickListener mListener;
    Context mContext;

    public RListAdapter(Context context, List<String> list, OnItemClickListener listener)
    {
        mList = list;
        mListener = listener;
        mContext = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text2,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {

        final String text = mList.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) mListener.onClick(text, position);
            }
        });

        int r = (int)(Math.random()*24+1);
        String icn = "dog"+r;
        int resID = mContext.getResources().getIdentifier(icn, "drawable", mContext.getPackageName());
        holder.mTextView.setText(text);
        holder.mImageView.setImageResource(resID);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }


    protected static class Holder extends RecyclerView.ViewHolder
    {
        private CardView cv;
        private TextView mTextView;
        private ImageView mImageView;

        public Holder(View itemView)
        {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            mTextView = (TextView) itemView.findViewById(R.id.tv_text2);
            mImageView = (ImageView) itemView.findViewById(R.id.icon2);
        }
    }
    interface OnItemClickListener
    {
        void onClick(String text, int position);
    }

}
