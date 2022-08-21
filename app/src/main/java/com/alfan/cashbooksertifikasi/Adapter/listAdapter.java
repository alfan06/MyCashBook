package com.alfan.cashbooksertifikasi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import androidx.annotation.NonNull;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.alfan.cashbooksertifikasi.DB.DBHelper;
import com.alfan.cashbooksertifikasi.Models.DetailModel;
import com.alfan.cashbooksertifikasi.R;

public class listAdapter extends RecyclerView.Adapter<listAdapter.MyViewHolder>{
    Context context;
    private ArrayList<DetailModel> detailModelArrayList;
    DBHelper db;

    public listAdapter(ArrayList<DetailModel> detailModelArrayList,Context context) {
        this.context = context;
        this.detailModelArrayList = detailModelArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_detail_pemasukan, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DetailModel model = detailModelArrayList.get(position);
        if (model.getCursor() == 0) {
            holder.txt_id_pemasukan.setText(model.getId());
            holder.txt_nominal_pemasukan.setText(String.valueOf(model.getJumlah()));
            holder.txt_keterangan_pemasukan.setText(model.getKeterangan());
            holder.txt_tanggal_pemasukan.setText(model.getTanggal());
            holder.cursor.setImageResource(R.drawable.ic_baseline_arrow_back_24);
        } else {
            holder.txt_id_pemasukan.setText(model.getId());
            holder.txt_nominal_pemasukan.setText(String.valueOf(model.getJumlah()));
            holder.txt_keterangan_pemasukan.setText(model.getKeterangan());
            holder.txt_tanggal_pemasukan.setText(model.getTanggal());
            holder.cursor.setImageResource(R.drawable.ic_baseline_arrow_forward_24);
        }
    }

    @Override
    public int getItemCount() {
        return detailModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_id_pemasukan, txt_nominal_pemasukan, txt_keterangan_pemasukan, txt_tanggal_pemasukan;
        ImageView cursor;

        public MyViewHolder(@NonNull View itemView) { super(itemView);
            txt_id_pemasukan = itemView.findViewById(R.id.txt_id_pemasukan);
            txt_id_pemasukan.setVisibility(View.INVISIBLE);
            txt_nominal_pemasukan = itemView.findViewById(R.id.txt_nominal_pemasukan);
            txt_keterangan_pemasukan = itemView.findViewById(R.id.txt_keterangan_pemasukan);
            txt_tanggal_pemasukan = itemView.findViewById(R.id.txt_tanggal_pemasukan);
            cursor = itemView.findViewById(R.id.panah);
        }
    }
}
