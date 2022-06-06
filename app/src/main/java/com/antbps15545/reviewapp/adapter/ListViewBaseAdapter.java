package com.antbps15545.reviewapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.antbps15545.reviewapp.R;
import com.antbps15545.reviewapp.models.Country;

import java.util.List;

public class ListViewBaseAdapter extends BaseAdapter {
    private List<Country> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public ListViewBaseAdapter(Context aContext,  List<Country> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_lv_ex_simple, null);
            holder = new ViewHolder();
            holder.flagView = (ImageView) convertView.findViewById(R.id.flagsimple);
            holder.countryNameView = (TextView) convertView.findViewById(R.id.namesimple);
            holder.populationView = (TextView) convertView.findViewById(R.id.popusimple);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Country country = this.listData.get(position);
        holder.countryNameView.setText(country.getCountryName());
        holder.populationView.setText("Population: " + country.getPopulation());

        int imageId = this.getMipmapResIdByName(country.getFlagName());

        holder.flagView.setImageResource(imageId);

        return convertView;
    }

    // Find Image ID corresponding to the name of the image (in the directory mipmap).
    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    static class ViewHolder {
        ImageView flagView;
        TextView countryNameView;
        TextView populationView;
    }
}
