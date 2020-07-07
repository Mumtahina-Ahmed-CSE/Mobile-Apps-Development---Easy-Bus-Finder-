package com.example.ahsan.easybusfinder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContex;
    private List<BusData> mData;

    public RecyclerViewAdapter(Context mContex,List<BusData> mData){
        this.mContex=mContex;
        this.mData=mData;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater=LayoutInflater.from(mContex);
        view=mInflater.inflate(R.layout.cardview_item_book,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_boook_title.setText(mData.get(position).getTitle());
        holder.img_book_thumnail.setImageResource(mData.get(position).getThumbnail());

        //set click listener

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //passing data to Location activity
                Intent intent=new Intent(mContex,Location_Information.class);
                intent.putExtra("Bus no",mData.get(position).getTitle());
                //start the activity
                mContex.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_boook_title;
        ImageView img_book_thumnail;

        CardView cardView;
        public MyViewHolder(View itemView){
            super(itemView);
            tv_boook_title=(TextView) itemView.findViewById(R.id.book_title_id);
            img_book_thumnail=itemView.findViewById(R.id.book_img_id);
            cardView=itemView.findViewById(R.id.card_view_id);
        }
    }
}
