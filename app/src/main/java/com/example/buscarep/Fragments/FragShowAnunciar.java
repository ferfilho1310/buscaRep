package com.example.buscarep.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.buscarep.Activity.EntrarActView;
import com.example.buscarep.R;
import com.example.buscarep.Util.IntentHelper;

public class FragShowAnunciar extends Fragment implements View.OnClickListener{

    Button btnAdicionarAnucios;

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
        View view = inflater.inflate(R.layout.fragment_anunciar, container, false);
        btnAdicionarAnucios = view.findViewById(R.id.btn_adicionar_anuncios_frag_meus_anuncios);

        btnAdicionarAnucios.setOnClickListener(this);

         return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_adicionar_anuncios_frag_meus_anuncios:
                IntentHelper.getInstance().SimpleIntent(getActivity(), EntrarActView.class);
                break;
        }

    }
}
