package com.example.buscarep.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.buscarep.R;

public class FragShowRoom extends Fragment {

    private String title;
    private int page;

    public static FragShowRoom newInstance(int page) {
        FragShowRoom fragmentFirst = new FragShowRoom();
        Bundle args = new Bundle();
        args.putInt("FirstPage", page);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        page = getArguments().getInt("FirstPage",0);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }
}
