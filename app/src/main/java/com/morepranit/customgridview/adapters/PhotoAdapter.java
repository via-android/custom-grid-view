package com.morepranit.customgridview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.morepranit.customgridview.R;
import com.morepranit.customgridview.models.PhotoModel;

import java.util.ArrayList;

public class PhotoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<PhotoModel> photoModels;

    public PhotoAdapter(Context context, ArrayList<PhotoModel> photoModels) {
        this.context = context;
        this.photoModels = photoModels;
    }

    @Override
    public int getCount() {
        return photoModels.size();
    }

    @Override
    public Object getItem(int i) {
        return photoModels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.grid_item, viewGroup, false);
            holder = new ViewHolder();
            holder.tvTitle = view.findViewById(R.id.tv_title);
            holder.ivPhoto = view.findViewById(R.id.iv_photo);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        PhotoModel model = photoModels.get(i);
        holder.tvTitle.setText(model.getTitle());
        Glide.with(context)
                .load(model.getUrl())
                .into(holder.ivPhoto);

        return view;
    }

    class ViewHolder {
        TextView tvTitle;
        ImageView ivPhoto;
    }
}
