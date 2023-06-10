package com.TK.sonobudoyoyk.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.TK.sonobudoyoyk.R;
import com.TK.sonobudoyoyk.model.news;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.listViewHolder> {
    private ArrayList<news> listnews;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    private OnItemClick onItemClick;

    public ListAdapter(ArrayList<news> listnews) {
        this.listnews = listnews;
    }

    @NonNull
    @Override
    public listViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_news, parent, false);
        return new listViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull listViewHolder holder, int position) {
        news news=listnews.get(position);
        Glide.with(holder.itemView.getContext())
                .load(news.getFoto())
                .override(150,100)
                .fitCenter()
                .into(holder.imgFoto);
        holder.title.setText(news.getTitle());
        holder.desc.setText(news.getDescription());
        holder.itemView.setOnClickListener(v -> {
            onItemClick.onItemClick(listnews.get(holder.getAdapterPosition()));
        });

    }

    @Override
    public int getItemCount() {
        return listnews.size();
    }

    public class listViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFoto;
        TextView title, desc;
        public listViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto=itemView.findViewById(R.id.imageNews);
            title=itemView.findViewById(R.id.tvTitle);
            desc=itemView.findViewById(R.id.tvDesc);
        }
    }
    public interface OnItemClick{
        void onItemClick(news data);
    }
}
