package com.example.rohankankapurkar.gameoflife;

/**
 * Created by Rohan Kankapurkar on 2/20/2017.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    private Context mContext;

    public static int LIFE_GRID;
    private ArrayList<Boolean> list;

    public GridAdapter(Context context, ArrayList<Boolean> list) {
        mContext = context;
        this.list = list;
        LIFE_GRID = Integer.parseInt(mContext.getResources().getString(R.string.grid_size));
    }

    public int getCount() {
        return LIFE_GRID;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        GridHolder holder;
        if (convertView == null) {
            holder = new GridHolder();
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setTag(holder);
        }
        else
        {
            imageView = (ImageView) convertView;
            holder = (GridHolder) imageView.getTag();
        }
        holder.isAlive = list.get(position);
        if(holder.isAlive) {
            imageView.setImageResource(R.drawable.black);
        } else {
            imageView.setImageResource(R.drawable.wood);
        }

        return imageView;
    }

    public class GridHolder {
        boolean isAlive;
    }

}