package com.example.mockapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mockapi.model.DataWebFramework;

import java.util.ArrayList;

public class AdapterWebFramework extends ArrayAdapter {
    ArrayList<DataWebFramework> dataFrameworks= new ArrayList();
    LayoutInflater layoutInflater;
    Context context;

    public AdapterWebFramework(Context context, ArrayList<DataWebFramework> dataFrameworks) {
        super(context, R.layout.item_list, dataFrameworks);
        this.dataFrameworks = dataFrameworks;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.item_list, parent, false);
        DataWebFramework dataFramework = this.dataFrameworks.get(position);

        TextView titleListview = convertView.findViewById(R.id.titleListview);
        TextView authoListview = convertView.findViewById(R.id.authorListview);
        ImageView imageView = convertView.findViewById(R.id.imgListview);

        Glide
                .with(context)
                .load(dataFramework.getImage())
                .placeholder(R.drawable.ic_refres_foreground)
                .into(imageView);

        titleListview.setText(dataFramework.getNameFramework());
        authoListview.setText(""+dataFramework.getOriginal_author());

        return convertView;
    }
}
