package com.alfan.cashbooksertifikasi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;

import com.alfan.cashbooksertifikasi.Adapter.listAdapter;
import com.alfan.cashbooksertifikasi.DB.DBHelper;
import com.alfan.cashbooksertifikasi.Models.DetailModel;

import java.util.ArrayList;

public class DetailFragment extends Fragment {
    DetailFragment binding;
    RecyclerView recyclerView, recycleview2;
    DBHelper db;
    private ArrayList<DetailModel> DetailArrayList;
    listAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}