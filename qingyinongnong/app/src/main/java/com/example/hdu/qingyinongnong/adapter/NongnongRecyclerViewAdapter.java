package com.example.hdu.qingyinongnong.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.example.hdu.qingyinongnong.R;
import com.example.hdu.qingyinongnong.model.Topic;
import com.example.hdu.qingyinongnong.utils.Singleton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by Aimee on 2016/4/18.
 */
public class NongnongRecyclerViewAdapter extends RecyclerView.Adapter<NongnongRecyclerViewAdapter.CustomerViewHolder> {
    private ArrayList<Topic> itemList;
    private Activity activity;
    private Context context;

    public NongnongRecyclerViewAdapter(Activity activity, Context context, ArrayList<Topic> itemList) {
        this.activity = activity;
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public CustomerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomerViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview_nongnongquan, parent, false));
    }

    @Override
    public void onBindViewHolder(final CustomerViewHolder holder,  int position) {
        Topic item = itemList.get(position);
        holder.title.setText(item.getTitle());
        holder.care.setTag(holder);
        holder.care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomerViewHolder tempholder = (CustomerViewHolder) v.getTag();
                int position = tempholder.getAdapterPosition();
                Toast.makeText(context, itemList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.loveNum.setText(item.getLove_num() + "");
        holder.talkNum.setText(item.getTalk_num() + "");
        String url = item.getImg().get(0);
        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                holder.nongnongImg.setImageBitmap(bitmap);
            }
        },0,0, ImageView.ScaleType.CENTER_CROP,null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                holder.nongnongImg.setImageResource(R.drawable.shucai);
            }
        });

        Singleton.getmInstance(context.getApplicationContext()).addToRequestQueue(imageRequest);
        String url2 = item.getImg().get(0);
        ImageRequest imageRequest2 = new ImageRequest(url2, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                holder.nongnongImg2.setImageBitmap(bitmap);
            }
        },0,0, ImageView.ScaleType.CENTER_CROP,null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                holder.nongnongImg2.setImageResource(R.drawable.shucai);
            }
        });

        Singleton.getmInstance(context.getApplicationContext()).addToRequestQueue(imageRequest2);
        Date date = item.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
        holder.time.setText(dateFormat.format(date));
        holder.user.setText("农农小助手");
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder {

       public TextView title;

        public ImageView nongnongImg;

        public ImageView nongnongImg2;

        public TextView talkNum;

        public TextView loveNum;

        public TextView time;

        ImageButton care;
        TextView user;
        public CustomerViewHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.title);
            nongnongImg= (ImageView) itemView.findViewById(R.id.nongnong_img);
            nongnongImg2= (ImageView) itemView.findViewById(R.id.nongnong_img2);
            talkNum= (TextView) itemView.findViewById(R.id.talk_num);
            loveNum= (TextView) itemView.findViewById(R.id.love_num);
            time= (TextView) itemView.findViewById(R.id.time);
            care= (ImageButton) itemView.findViewById(R.id.care);
            user= (TextView) itemView.findViewById(R.id.user);
        }

    }

}
