package com.example.buscarep.Interfaces;

import android.app.Activity;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.buscarep.mvc.Model.Usuario;

public interface IUserDao {

    void entrarUser(Usuario usuario, Activity activity, ProgressBar progressBar, Button button, TextView textView);

    void cadastrarUser(Usuario usuario, Activity activity, ProgressBar progressBar, Button button);
}
