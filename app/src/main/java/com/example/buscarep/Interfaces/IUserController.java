package com.example.buscarep.Interfaces;

import android.app.Activity;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.buscarep.mvc.Model.Usuario;

public interface IUserController {

    void mEntrar(Usuario usuario, Activity activity, ProgressBar progressBar, Button button, TextView textView);

    void mCadastrarUser(Usuario usuario, Activity activity, ProgressBar progressBar, Button button);

    boolean mPersisteUser(Activity activity, Class clazz);
}
