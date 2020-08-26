package com.example.buscarep.Controlles;

import android.app.Activity;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.buscarep.Daos.UserDao;
import com.example.buscarep.Interfaces.IEntrarController;
import com.example.buscarep.Model.Usuario;

public class EntrarController implements IEntrarController {

    private static EntrarController entrarController;

    public static synchronized EntrarController getInstance(){
        entrarController = new EntrarController();
        return entrarController;
    }

    @Override
    public void mEntrar(Usuario usuario, Activity activity, ProgressBar progressBar, Button button){
        UserDao.getInstance().entrarUser(usuario,activity,progressBar,button);
    }

    @Override
    public void mCadastrarUser(Usuario usuario, Activity activity, ProgressBar progressBar, Button button) {
        UserDao.getInstance().cadastrarUser(usuario,activity,progressBar,button);
    }

}
