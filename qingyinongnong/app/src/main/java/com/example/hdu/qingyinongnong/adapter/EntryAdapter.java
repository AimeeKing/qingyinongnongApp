package com.example.hdu.qingyinongnong.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hdu.qingyinongnong.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Aimee on 2016/4/27.
 */
public class EntryAdapter extends ArrayAdapter {
    private Context context;
    private List< Map<String, Object>> items;
    private LayoutInflater vi;


    public EntryAdapter(Context context, List<Map<String,Object>> resource) {
        super(context,0, resource);
        this.context = context;
        this.items =resource;
        vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        final  String title = (String) items.get(position).get("title");
        final  int img = (int) items.get(position).get("img");
        if(title==null)
        {
            v = new LinearLayout(getContext());
            v.setLayoutParams(new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,img
                    ));
        }
        else
        {
            v=vi.inflate(R.layout.listitem,null);
            TextView titleTextView = (TextView) v.findViewById(R.id.item_name);
            ImageView titleImg = (ImageView) v.findViewById(R.id.img);
            titleImg.setImageResource(img);
            titleTextView.setText(title);

        }

        return v;
    }
}
