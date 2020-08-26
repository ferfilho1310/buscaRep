package com.example.buscarep.Interfaces;

import android.app.Activity;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.buscarep.Model.Usuario;

public interface IEntrarController {

    void mEntrar(Usuario usuario, Activity activity, ProgressBar progressBar, Button button);

    void mCadastrarUser(Usuario usuario, Activity activity, ProgressBar progressBar, Button button);
}
