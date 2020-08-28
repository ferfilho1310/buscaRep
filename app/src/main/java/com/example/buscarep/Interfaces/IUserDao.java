package com.example.buscarep.Interfaces;

import android.app.Activity;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.buscarep.Model.Usuario;

public interface IUserDao {

    void entrarUser(Usuario usuario, Activity activity, ProgressBar progressBar, Button button);

    void cadastrarUser(Usuario usuario, Activity activity, ProgressBar progressBar, Button button);
}
