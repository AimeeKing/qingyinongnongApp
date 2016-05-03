package com.example.hdu.qingyinongnong.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
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
import com.example.hdu.qingyinongnong.activities.CrowedDetailActivity;
import com.example.hdu.qingyinongnong.model.Crow_funding;
import com.example.hdu.qingyinongnong.utils.Singleton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by Aimee on 2016/4/16.
 * 为了方便我这里使用了butterknife,太多findviewById写的好累的
 */
public class CrowRecyclerAdapter extends RecyclerView.Adapter<CrowRecyclerAdapter.CustomViewHolder> {
    public static final int CROW = 0;
    public static final int SOLD = 1;

    private ArrayList<Crow_funding> itemList;
    private Activity activity;
    private Context context;

    public CrowRecyclerAdapter(Activity activity, Context context, ArrayList<Crow_funding> itemList) {
        this.activity = activity;
        this.context = context;
        this.itemList = itemList;
    }


    @Override
    public int getItemViewType(int position) {
        int status = itemList.get(position).getStatus();
        return status;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(0 == viewType)
        {
            View v = LayoutInflater.from(context).inflate(R.layout.crowfunding_cardview,parent,false);
            return  new CrowViewHolder(v);
        }
        else if(1 == viewType)
        {
            View v = LayoutInflater.from(context).inflate(R.layout.sold_cardview,parent,false);
            return  new SoldViewHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, CrowedDetailActivity.class);
                Bundle imfoBundle = new Bundle();
                imfoBundle.putInt("position", (Integer) v.getTag());
                i.putExtras(imfoBundle);
                activity.startActivity(i);
            }
        };
        if (CROW==holder.getItemViewType())
        {
            final CrowViewHolder crowViewHolder = (CrowViewHolder) holder;
            crowViewHolder.title.setText(itemList.get(position).getTitle());
            crowViewHolder.have_fund.setText(itemList.get(position).getHave_sold()+"");
            crowViewHolder.have_jion.setText(itemList.get(position).getPeople()+"");
            crowViewHolder.aim_fund.setText(itemList.get(position).getAim_fund()+"");
            crowViewHolder.user.setText(itemList.get(position).getUser_id()+"");
            Date date=new Date();
            Date difference = new Date(itemList.get(position).getPublic_time().getTime() -date.getTime());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(difference);
            crowViewHolder.day.setText(calendar.get(Calendar.DATE) + "");
            crowViewHolder.hour.setText(calendar.get(Calendar.HOUR_OF_DAY)+"");
            crowViewHolder.minite.setText(calendar.get(Calendar.MINUTE)+"");
            String url = itemList.get(position).getImg();
            ImageRequest request_img = new ImageRequest(url,
                    new Response.Listener<Bitmap>(){

                        @Override
                        public void onResponse(Bitmap o) {
                            crowViewHolder.item_img.setImageBitmap(o);
                        }
                    },0,0, ImageView.ScaleType.CENTER_CROP,null, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    crowViewHolder.item_img.setImageResource(R.drawable.shucai);
                }
            });
            Singleton.getmInstance(context.getApplicationContext()).addToRequestQueue(request_img);
            crowViewHolder.item_img.setTag(position);
            crowViewHolder.have_fund.setTag(position);
            crowViewHolder.have_jion.setTag(position);
            crowViewHolder.item_img.setOnClickListener(onClickListener);
            crowViewHolder.have_fund.setOnClickListener(onClickListener);
            crowViewHolder.have_jion.setOnClickListener(onClickListener);
        }
        else if(SOLD==holder.getItemViewType())
        {
            final SoldViewHolder soldViewHolder = (SoldViewHolder) holder;
            String url = itemList.get(position).getImg();
            ImageRequest request_img = new ImageRequest(url,
                    new Response.Listener<Bitmap>(){

                        @Override
                        public void onResponse(Bitmap o) {
                            soldViewHolder.item_img.setImageBitmap(o);
                        }
                    },0,0,ImageView.ScaleType.CENTER_CROP,null, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    soldViewHolder.item_img.setImageResource(R.drawable.shucai);
                }
            });
            Singleton.getmInstance(context.getApplicationContext()).addToRequestQueue(request_img);
            soldViewHolder.title.setText(itemList.get(position).getTitle());
            soldViewHolder.describ.setText(itemList.get(position).getDescrib());
            soldViewHolder.had_sold.setText(itemList.get(position).getHave_sold()+"");
            soldViewHolder.user.setText("小王");//itemList.get(position).getUser_id()+""
            soldViewHolder.item_img.setTag(position);
            soldViewHolder.describ.setTag(position);
            soldViewHolder.title.setTag(position);
            soldViewHolder.item_img.setOnClickListener(onClickListener);
            soldViewHolder.title.setOnClickListener(onClickListener);
            soldViewHolder.describ.setOnClickListener(onClickListener);
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public CustomViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class CrowViewHolder extends CustomViewHolder {
        public ImageView item_img;
        public  TextView title;
        public  TextView aim_fund;
        public  TextView have_jion;
        public  TextView have_fund;
        public  TextView user;
        public  TextView day;
        public  TextView hour;
        public TextView minite;

        public CrowViewHolder(View itemView) {
            super(itemView);
            item_img= (ImageView) itemView.findViewById(R.id.imageView);
            title= (TextView) itemView.findViewById(R.id.title);
            aim_fund= (TextView) itemView.findViewById(R.id.want_fund);
            have_jion= (TextView) itemView.findViewById(R.id.have_jion);
            have_fund= (TextView) itemView.findViewById(R.id.have_fund);
            user= (TextView) itemView.findViewById(R.id.user);
            day= (TextView) itemView.findViewById(R.id.day);
            hour= (TextView) itemView.findViewById(R.id.hour);
            minite= (TextView) itemView.findViewById(R.id.minite);
        }
    }

    public class SoldViewHolder extends CustomViewHolder {
        public ImageView item_img;
        public TextView title;
        public TextView describ;
        public TextView had_sold;
        public TextView user;

        public SoldViewHolder(View itemView) {
            super(itemView);
             item_img= (ImageView) itemView.findViewById(R.id.imageView);
            title= (TextView) itemView.findViewById(R.id.title);
            describ= (TextView) itemView.findViewById(R.id.describ);
             had_sold= (TextView) itemView.findViewById(R.id.had_sold);
            user= (TextView) itemView.findViewById(R.id.user);

        }
    }

}
