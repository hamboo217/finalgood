package com.example.finalhw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<roo> allWords = new ArrayList<>();

    public void setAllWords(List<roo> allWords) {
        this.allWords = allWords;
    }

    @NonNull

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.cell,parent,false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull  MyAdapter.MyViewHolder holder, int position) {
        roo roo = allWords.get(position);
        holder.tv_dead.setText(roo.getPartySize());
        holder.tv_do.setText(roo.getGuestName());
    }

    @Override
    public int getItemCount() {
        return allWords.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_dead,tv_do;
        int texttime;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            tv_dead = itemView.findViewById(R.id.tv_dead);
            tv_do = itemView.findViewById(R.id.tv_do);


        }
    }

    public void removed(int position,MyAdapter myAdapter,rooDao rooDao){
        rooDao.deleteallword1(allWords.get(position));
        myAdapter.notifyItemRemoved(position);
    }


}
