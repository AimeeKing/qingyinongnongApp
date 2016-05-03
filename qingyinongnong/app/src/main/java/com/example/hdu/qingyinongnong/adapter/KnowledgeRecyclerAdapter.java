package com.example.hdu.qingyinongnong.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.example.hdu.qingyinongnong.R;
import com.example.hdu.qingyinongnong.model.Question;
import com.example.hdu.qingyinongnong.utils.Singleton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Aimee on 2016/4/16.
 */
public class KnowledgeRecyclerAdapter extends RecyclerView.Adapter<KnowledgeRecyclerAdapter.CustomViewHolder> {
    private ArrayList<Question> itemList;
    private Activity activity;
    private Context context;


    public KnowledgeRecyclerAdapter(Activity activity, Context context, ArrayList<Question> itemList) {
        this.activity = activity;
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate( R.layout.cardview_small, parent,false));
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {
        holder.title.setText(itemList.get(position).getTitle());
        holder.describ.setText(itemList.get(position).getDescrib());
        holder.talk_num.setText(itemList.get(position).getTalk_num()+"");
        holder.love_num.setText(itemList.get(position).getLove_num()+"");
        SimpleDateFormat df = new SimpleDateFormat("yy-MM-dd");
        holder.time.setText(df.format(itemList.get(position).getTime()));
        String url = itemList.get(position).getImg();
        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                holder.commodity.setImageBitmap(bitmap);
            }
        },0,0, ImageView.ScaleType.CENTER_CROP,null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                holder.commodity.setImageResource(R.drawable.shucai);
            }
        });
        Singleton.getmInstance(context.getApplicationContext()).addToRequestQueue(imageRequest);

    }



    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView title ;
        public TextView describ;
        public ImageView commodity;
        public TextView talk_num;
        public TextView love_num;
        public TextView time;
        public CustomViewHolder(View itemView) {
            super(itemView);
             title = (TextView) itemView.findViewById(R.id.title);
             describ = (TextView) itemView.findViewById(R.id.describ);
             commodity = (ImageView) itemView.findViewById(R.id.commodity);
            talk_num = (TextView) itemView.findViewById(R.id.talk_num);
             love_num = (TextView) itemView.findViewById(R.id.love_num);
             time = (TextView) itemView.findViewById(R.id.time);
        }
    }
}
