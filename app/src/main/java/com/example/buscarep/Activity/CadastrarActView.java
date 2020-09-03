package com.example.buscarep.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.buscarep.R;

public class CadastrarActView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_act_view);

        getSupportActionBar().hide();
    }
}