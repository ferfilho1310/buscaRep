package com.example.buscarep.Controllers;

import android.app.Activity;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.buscarep.Daos.UserDao;
import com.example.buscarep.Interfaces.IUserController;
import com.example.buscarep.Interfaces.IUserDao;
import com.example.buscarep.Model.Usuario;

public class UserController implements IUserController {

    private static UserController userController;
    private static IUserDao iUserDao;

    public static synchronized UserController getInstance() {
        if (userController == null) {
            userController = new UserController();
            iUserDao = new UserDao();
        }
        return userController;
    }

    @Override
    public void mEntrar(Usuario usuario, Activity activity, ProgressBar progressBar, Button button, TextView textView) {
        iUserDao.entrarUser(usuario, activity, progressBar, button, textView);
    }

    @Override
    public void mCadastrarUser(Usuario usuario, Activity activity, ProgressBar progressBar, Button button) {
       iUserDao.cadastrarUser(usuario, activity, progressBar, button);
    }

}
