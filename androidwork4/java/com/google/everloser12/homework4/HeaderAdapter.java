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
 * Created by al-ev on 06.04.2016.
 */
public class HeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_FOOTER = 2;
    private List<String> mList;
    private OnItemClickListener mListener;


    public HeaderAdapter(List<String> list, OnItemClickListener listener)
    {
        mList = list;
        mListener = listener;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType == TYPE_HEADER)
        {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false);
            return  new HHeader(v);
        }
        else if(viewType == TYPE_ITEM)
        {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text2, parent, false);
            return new HolderMain(v);
        }
        else if (viewType == TYPE_FOOTER)
        {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_footer, parent, false);
            return new HFooter(v);
        }
        throw new RuntimeException("there is no type that matches the type " + viewType
                + " + make sure your using types correctly");
    }




    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if(holder instanceof HolderMain) {

            final String text = mList.get(position-1);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) mListener.onClick(text, position-1);
                }
            });

            int r = (int) (Math.random() * 24 + 1);
            String icn = "dog" + r;
            int resID = holder.itemView.getContext().getResources()
                    .getIdentifier(icn, "drawable", holder.itemView.getContext().getPackageName());
            ((HolderMain) holder).mTextView1.setText(text);
            ((HolderMain) holder).mImageView1.setImageResource(resID);
        }
        else if(holder instanceof HHeader)
        {
        ((HHeader) holder).txtHeader.setText("Dogs, dogs...");
        }
        else if (holder instanceof HFooter)
        {
            ((HFooter) holder).txtFooter.setText("Do you like dogs?");
        }
    }

    @Override
    public int getItemCount()
    {
        return mList == null ? 0 : mList.size()+2;
    }

    private String getItem(int position)
    {
        return mList.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        if(isPositionHeader(position))
            return TYPE_HEADER;
        else if (isPositionFooter(position))
            return TYPE_FOOTER;
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position)
    {
        return position == 0;
    }

    private boolean isPositionFooter(int position)
    {
        return position == mList.size()+1;
    }



    protected class HolderMain extends RecyclerView.ViewHolder
    {
        private CardView cv1;
        private TextView mTextView1;
        private ImageView mImageView1;

        public HolderMain(View itemView)
        {
            super(itemView);
            cv1 = (CardView)itemView.findViewById(R.id.cv);
            mTextView1 = (TextView) itemView.findViewById(R.id.tv_text2);
            mImageView1 = (ImageView) itemView.findViewById(R.id.icon2);
        }
    }

    protected class HHeader extends RecyclerView.ViewHolder{
        private TextView txtHeader;
        public HHeader(View itemView) {
            super(itemView);
            txtHeader = (TextView)itemView.findViewById(R.id.text_header);
        }
    }
    protected class HFooter extends RecyclerView.ViewHolder{
        private TextView txtFooter;
        public HFooter(View itemView) {
            super(itemView);
            txtFooter = (TextView)itemView.findViewById(R.id.text_footer);
        }
    }

    interface OnItemClickListener
    {
        void onClick(String text, int position);
    }

}
