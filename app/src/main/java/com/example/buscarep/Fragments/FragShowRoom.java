package com.example.buscarep.Fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buscarep.mvc.View.EntrarActView;
import com.example.buscarep.mvc.Controllers.AnuncioController;
import com.example.buscarep.R;
import com.example.buscarep.Util.IntentHelper;

public class FragShowRoom extends Fragment implements View.OnClickListener {

    private int page;
    RecyclerView mRcShowRoom;
    ReclerviewRoom reclerviewRoomAdapter;
    TextView nenhumDadoEncontrado;
    Button btnAdicionarAnuncio;

    boolean escondeBotao;
    boolean mostrabotao;

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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_inicio, container, false);
        escondeBotao = getActivity().getIntent().getBooleanExtra("mostraBotao", false);
        mostrabotao = getActivity().getIntent().getBooleanExtra("mostraBotaoAnunciante", true);

        mRcShowRoom = view.findViewById(R.id.rc_show_room);
        nenhumDadoEncontrado = view.findViewById(R.id.nenhum_dado_encontrado);
        btnAdicionarAnuncio = view.findViewById(R.id.btn_adicionar_anuncios_frag_main);

        if (escondeBotao) {
            btnAdicionarAnuncio.setVisibility(View.GONE);
        } else if (mostrabotao) {
            btnAdicionarAnuncio.setVisibility(View.VISIBLE);
        }

        reclerviewRoomAdapter = new ReclerviewRoom(AnuncioController.getInstance().buscaAnuncios());

        mRcShowRoom.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if (dy < 0) {
                    btnAdicionarAnuncio.setVisibility(View.VISIBLE);
                } else if (dy > 0) {
                    btnAdicionarAnuncio.setVisibility(View.GONE);
                }
            }
        });
        btnAdicionarAnuncio.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_adicionar_anuncios_frag_main:
                IntentHelper.getInstance().simpleIntent(getActivity(), EntrarActView.class);
                break;
        }

    }
}
