package com.example.buscarep.Fragments;

import android.app.DownloadManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buscarep.Activity.EntrarActView;
import com.example.buscarep.Controllers.AnuncioController;
import com.example.buscarep.R;
import com.example.buscarep.Util.IntentHelper;
import com.google.firebase.firestore.Query;

public class FragShowRoom extends Fragment implements View.OnClickListener {

    private int page;
    RecyclerView mRcShowRoom;
    ProgressBar pganuncio;
    ReclerviewRoom reclerviewRoomAdapter;
    TextView nenhumDadoEncontrado;
    Button btnAdicionarAnuncio;

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
        page = getArguments().getInt("FirstPage", 0);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_inicio, container, false);
        mRcShowRoom = view.findViewById(R.id.rc_show_room);
        pganuncio = view.findViewById(R.id.pganuncio);
        nenhumDadoEncontrado = view.findViewById(R.id.nenhum_dado_encontrado);
        btnAdicionarAnuncio = view.findViewById(R.id.btn_adicionar_anuncios_frag_main);

        reclerviewRoomAdapter = new ReclerviewRoom(AnuncioController.getInstance().buscaAnuncios());

        pganuncio.setVisibility(View.VISIBLE);

        if (mRcShowRoom.getAdapter() != null) {
            pganuncio.setVisibility(View.GONE);
        } else {
            mRcShowRoom.setVisibility(View.GONE);
            nenhumDadoEncontrado.setVisibility(View.VISIBLE);
            pganuncio.setVisibility(View.GONE);
        }

        btnAdicionarAnuncio.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_adicionar_anuncios_frag_main:
                IntentHelper.getInstance().SimpleIntent(getActivity(), EntrarActView.class);
                break;
        }

    }
}
