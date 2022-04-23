package com.example.databasemysql.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databasemysql.R;
import com.example.databasemysql.database.Teman;

import java.util.ArrayList;
import java.util.HashMap;

public class TemanAdapter extends RecyclerView.Adapter<TemanAdapter.TemanViewHolder> {
    private ArrayList<Teman> listData;

    public TemanAdapter(ArrayList<Teman> listData){

        this.listData = listData;
    }

    @Override
    public TemanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInf = LayoutInflater.from(parent.getContext());
        View v = layoutInf.inflate(R.layout.row_data_teman,parent,false);
        return new TemanViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TemanViewHolder holder, int position) {
        String nm, tlp;

        nm = listData.get(position).getNama();
        tlp = listData.get(position).getTelepon();

        holder.namaTxt.setTextColor(Color.BLUE);
        holder.namaTxt.setTextSize(20);

        holder.namaTxt.setText(nm);
        holder.telponTxt.setText(tlp);

        holder.kartu.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }

        });
    }

    @Override
    public int getItemCount() {

        return (listData != null)? listData.size() : 0;
    }

    public class TemanViewHolder extends  RecyclerView.ViewHolder{
        private CardView kartu;
        private TextView namaTxt, telponTxt;
        public TemanViewHolder(View v){
            super(v);
            kartu = (CardView) v.findViewById(R.id.kartuku);
            namaTxt = (TextView) v.findViewById(R.id.textNama);
            telponTxt = (TextView) v.findViewById(R.id.textTelpon);

        }
    }
}

