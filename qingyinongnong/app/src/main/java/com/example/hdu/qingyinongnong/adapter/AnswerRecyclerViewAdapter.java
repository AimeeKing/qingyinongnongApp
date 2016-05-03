package com.example.hdu.qingyinongnong.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hdu.qingyinongnong.R;
import com.example.hdu.qingyinongnong.model.Question;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by Aimee on 2016/4/18.
 */
public class AnswerRecyclerViewAdapter extends RecyclerView.Adapter<AnswerRecyclerViewAdapter.CustomerViewHolder> {
    private ArrayList<Question> itemList;
    private Activity activity;
    private Context context;

    public AnswerRecyclerViewAdapter(Activity activity, Context context, ArrayList<Question> itemList) {
        this.activity = activity;
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public CustomerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomerViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview_myanswer, parent, false));
    }

    @Override
    public void onBindViewHolder(final CustomerViewHolder holder,  int position) {
        Question item = itemList.get(position);
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

        public TextView talkNum;

        public TextView loveNum;

        public TextView time;

        ImageButton care;
        TextView user;
        public CustomerViewHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.title);
            talkNum= (TextView) itemView.findViewById(R.id.talk_num);
            loveNum= (TextView) itemView.findViewById(R.id.love_num);
            time= (TextView) itemView.findViewById(R.id.time);
            care= (ImageButton) itemView.findViewById(R.id.care);
            user= (TextView) itemView.findViewById(R.id.user);
        }

    }

}
