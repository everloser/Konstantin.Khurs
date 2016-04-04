package com.google.everloser12.homework4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by al-ev on 04.04.2016.
 */
public class ListAdapter extends BaseAdapter {
    private Activity mContext;
    private List<String> mList;
    private LayoutInflater mlayoutInflater;


    public ListAdapter(Activity context, List<String> list)
    {
        mContext = context;
        mList = list;
        mlayoutInflater = mContext.getLayoutInflater();
    }

    static class ViewHolder {
        public TextView text;
        public ImageView image;
    }
    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        if (mList == null)

        {return null;}
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null)
        {
            view = mlayoutInflater.inflate(R.layout.item_text, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) view.findViewById(R.id.tv_text);
            viewHolder.image = (ImageView) view.findViewById(R.id.icon);
            view.setTag(viewHolder);
        }
        ViewHolder holder = (ViewHolder) view.getTag();
        String text = mList.get(position);
        holder.text.setText(text);
        int r = (int)(Math.random()*24+1);
        String icn = "dog"+r;
        int resID = mContext.getResources().getIdentifier(icn, "drawable", mContext.getPackageName());
        holder.image.setImageResource(resID);

        return view;
    }
}
