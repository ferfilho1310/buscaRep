package com.example.buscarep.mvc.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.buscarep.R;
import com.example.buscarep.Util.IntentHelper;

public class ModoUserActView extends AppCompatActivity implements View.OnClickListener {

    private Button visualizar_anuncios;
    private Button entrar_como_anuncios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modo_user);

        getSupportActionBar().hide();

        visualizar_anuncios = findViewById(R.id.visualizar_anuncios);
        entrar_como_anuncios = findViewById(R.id.entrar_como_anunciante);

        visualizar_anuncios.setOnClickListener(this);
        entrar_como_anuncios.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.visualizar_anuncios:
                IntentHelper.getInstance().intentWithPutExtra(this, MainActivity.class,true,"mostraBotao");
                break;
            case R.id.entrar_como_anunciante:
                IntentHelper.getInstance().intentWithPutExtra(this, EntrarActView.class,true,"mostraBotaoAnunciante");
                break;
        }
    }
}