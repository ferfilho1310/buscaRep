package com.example.buscarep.Daos;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;

import com.example.buscarep.DialogHelpers.AbstratcAlertDialog;
import com.example.buscarep.Enums.SharedEnums;
import com.example.buscarep.Interfaces.IUserDao;
import com.example.buscarep.Model.Usuario;
import com.example.buscarep.Util.GetViewData;
import com.example.buscarep.Util.MensagemSistema;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserDao implements IUserDao {

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    private static UserDao userDao;

    public static synchronized UserDao getInstance() {
        userDao = new UserDao();
        return userDao;
    }

    @Override
    public void entrarUser(Usuario usuario, final Activity activity, final ProgressBar progressBar, final Button button) {

        progressBar.setVisibility(View.VISIBLE);
        button.setVisibility(View.GONE);

        firebaseAuth.signInWithEmailAndPassword(usuario.getmEmail(), usuario.getmSenha())
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            progressBar.setVisibility(View.VISIBLE);
                            button.setVisibility(View.GONE);
                        } else {
                            progressBar.setVisibility(View.GONE);
                            button.setVisibility(View.VISIBLE);
                            AbstratcAlertDialog.getInstance().mShowInfo(activity, MensagemSistema.ERRO_ENTRAR);
                        }
                    }
                });
    }

    @Override
    public void cadastrarUser(Usuario usuario, Activity activity, ProgressBar progressBar, Button button) {

        firebaseAuth.createUserWithEmailAndPassword(usuario.getmEmail(),usuario.getmSenha()).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

}
