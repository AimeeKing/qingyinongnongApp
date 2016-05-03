package com.example.hdu.qingyinongnong.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.example.hdu.qingyinongnong.R;
import com.example.hdu.qingyinongnong.activities.MenuContentActivity;
import com.example.hdu.qingyinongnong.model.Menu;
import com.example.hdu.qingyinongnong.utils.Singleton;

import java.util.ArrayList;

/**
 * Created by Aimee on 2016/4/29.
 */
public class MenuRecyclerViewAdapter extends RecyclerView.Adapter<MenuRecyclerViewAdapter.MenuCustomView> {
    private static final int HREDVIEW = 0;
    private static final int MENUITEM = 1;
    public ArrayList<Menu> menuList;
    private Context context;
    private Activity activity;

    public MenuRecyclerViewAdapter(Activity activity, Context context, ArrayList<Menu> menuList) {
        this.activity = activity;
        this.context = context;
        this.menuList = menuList;
    }

    @Override
    public MenuCustomView onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == MENUITEM)
        return new MenuItemCustomView(LayoutInflater.from(context).inflate(R.layout.cardview_menu,parent,false));
        else
            return new MenuHeadCustomView(LayoutInflater.from(context).inflate(R.layout.cardview_menuheader,parent,false));
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0? HREDVIEW:MENUITEM;
    }

    @Override
    public void onBindViewHolder(MenuCustomView holder, final int position) {
        if(getItemViewType(position) == MENUITEM) {
            final MenuItemCustomView mholder = (MenuItemCustomView) holder;
            mholder.lookedNumTv.setText(menuList.get(position).getLookNum() + "");
            mholder.loveedNumTv.setText(menuList.get(position).getLoveNum() + "");
            mholder.title.setText(menuList.get(position).getTitle());
            String url = menuList.get(position).getMainPic();
            ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
                @Override
                public void onResponse(Bitmap response) {
                    mholder.mainImg.setImageBitmap(response);
                }
            }, 0, 0, ImageView.ScaleType.CENTER_CROP, null, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    mholder.mainImg.setImageResource(R.drawable.page_menu_6);
                }
            });
            Singleton.getmInstance(context.getApplicationContext()).addToRequestQueue(imageRequest);
            mholder.menuItem.setTag(position);
            mholder.menuItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(activity, MenuContentActivity.class);
                    Bundle menuItemBundle =new Bundle();
                    menuItemBundle.putInt("position",position);
                    i.putExtras(menuItemBundle);
                    activity.startActivity(i);
                }
            });
        }
        else
        {
            final MenuHeadCustomView menuHeadCustomView = (MenuHeadCustomView) holder;
            String url = "http://img.hb.aicdn.com/548d16ee5db486a18d8e3dc6fb2561c3be9c0b4c1a8f5c-JY7Hxe_fw658";
            ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
                @Override
                public void onResponse(Bitmap response) {
                    menuHeadCustomView.mainImg.setImageBitmap(response);
                }
            }, 0, 0, ImageView.ScaleType.CENTER_CROP, null, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    menuHeadCustomView.mainImg.setImageResource(R.drawable.page_menu_7);
                }
            });
            Singleton.getmInstance(context.getApplicationContext()).addToRequestQueue(imageRequest);
        }
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public class MenuCustomView extends RecyclerView.ViewHolder {

        public MenuCustomView(View itemView) {
            super(itemView);
        }
    }

    public  class MenuItemCustomView extends MenuCustomView {
        private ImageView mainImg;
        private TextView title;
        private TextView lookedNumTv;
        private TextView loveedNumTv;
        private LinearLayout menuItem;
        public MenuItemCustomView(View itemView) {
            super(itemView);
            mainImg = (ImageView) itemView.findViewById(R.id.main_img);
            title = (TextView) itemView.findViewById(R.id.title);
            lookedNumTv = (TextView) itemView.findViewById(R.id.looknum_tv);
            loveedNumTv = (TextView) itemView.findViewById(R.id.lovenum_tv);
            menuItem = (LinearLayout) itemView.findViewById(R.id.menu_item);
        }
    }

    public  class MenuHeadCustomView extends MenuCustomView {
        private ImageView mainImg;
        private TextView title;
        public MenuHeadCustomView(View itemView) {
            super(itemView);
            mainImg = (ImageView) itemView.findViewById(R.id.head_img);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }




    @Override
    public void onViewAttachedToWindow(MenuCustomView holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if(lp!=null && lp instanceof StaggeredGridLayoutManager.LayoutParams && holder.getLayoutPosition() == 0)
        {
            StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
            p.setFullSpan(true);
        }
    }
}
