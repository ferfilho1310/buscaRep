package com.example.buscarep.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.buscarep.R;

public class FragShowAnunciar extends Fragment {

    private String title;
    private int page;

    public static FragShowAnunciar newInstance(int page) {
        FragShowAnunciar fragmentFirst = new FragShowAnunciar();
        Bundle args = new Bundle();
        args.putInt("SecondPage", page);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        page = getArguments().getInt("SecondPage",0);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         return inflater.inflate(R.layout.fragment_anunciar, container, false);
    }
}
